/**
 * Created by oleksiy.konkin on 10/31/2014.
 */
/*
 http://jasmine.github.io/2.0/introduction.html

 http://techoctave.com/c7/posts/77-javascript-testing-with-jasmine

 http://codepen.io/jweden/pen/Irmil

 http://bittersweetryan.github.io/jasmine-presentation/#slide-70


 */
var ROWS=4;
var COLUMNS=4;

function GameField(){
    this.gameArray = [];
}

GameField.prototype.drawGameField = function (aGameFieldTag){
    var aDiv = document.getElementById(aGameFieldTag);
    var table = document.createElement('TABLE');

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var row=0; row < this.getNumberOfRows(); row++){
        var tr = document.createElement('TR');
        tableBody.appendChild(tr);

        for (var column=0; column < this.getNumberOfColumns(); column++){
            var td = document.createElement('TD');
            td.id = "td_"+row+"_"+column;
            tr.appendChild(td);
        }
    }
    aDiv.appendChild(table);
};

GameField.prototype.getValue = function (aRaw, aColumn){
    return this.gameArray[aRaw][aColumn];
};

GameField.prototype.setValue = function (aRaw, aColumn, aValue){
    this.gameArray[aRaw][aColumn] = aValue;
};

GameField.prototype.getGameFieldTag = function (aGameFieldTag){
    return document.getElementById(aGameFieldTag);
};

GameField.prototype.initGameField = function(aRow, aColumn){
    this.row = aRow;
    this.column = aColumn;

    if(this.gameArray.length == 0) {
        while (this.gameArray.push([]) < aRow);

        for (var row = 0; row < this.gameArray.length; row++) {
            for (var col = 0; col < aColumn; col++)
                this.gameArray[row].push(0);
        }
    }
};

GameField.prototype.getNumberOfRows = function(){
    return this.gameArray.length;
};

GameField.prototype.getNumberOfColumns = function (){
    return this.gameArray[0].length;
};

GameField.prototype.putSnakeToGameField = function (Snake){
    var raw = 0;
    var column = 0;
    for(var body = 0; body < aSnake.getBodyLength(); body++){
            raw = aSnake.snakeBody[body][0];
            column = aSnake.snakeBody[body][1];
            this.gameArray[raw][column] = 1;
    }
};

GameField.prototype.checkIfCellIsOccupied = function (aRow, aColumn){
    if(this.gameArray[aRow][aColumn] > 0){
        return true;
    }
    else{
        return false;
    }
};

GameField.prototype.putMealToTheGameField = function (aRow, aColumn){
    if(this.gameArray[aRow][aColumn] != 1){
        this.gameArray[aRow][aColumn] = 2;
        return true;
    }
    else{
        //console.log("the values are not valid row"+aRow+" column"+aColumn);
        return false;
    }

};


GameField.prototype.refreshGameField = function(){
    for (var row = 0; row < this.getNumberOfRows() ; row++) {
        for (var column = 0; column < this.getNumberOfColumns(); column++) {
            var tagThatShouldBePainted = "td_" + row + "_" + column;
            var gameCell = document.getElementById(tagThatShouldBePainted);
            if(column < this.getNumberOfColumns()) {
                if (this.gameArray[row][column] == 1) {
                    gameCell.bgColor = 'red';
                }
                else if(this.gameArray[row][column] == 2){
                    gameCell.bgColor = 'green';
                }
                else {
                    gameCell.bgColor = 'white';
                }
            }
        }
    }
};

GameField.prototype.clearGameField = function(){
    for (var row = 0; row < this.getNumberOfRows() ; row++) {
        for (var column = 0; column < this.getNumberOfColumns(); column++) {
            if(this.gameArray[row][column] !=2) {
                this.gameArray[row][column] = 0;
            }
        }
    }
};

GameField.prototype.containsMeal = function(){
    for (var row = 0; row < this.getNumberOfRows() ; row++) {
        for (var column = 0; column < this.getNumberOfColumns(); column++) {
            if(this.gameArray[row][column] == 2) {
                return true;
            }
        }
    }
    return false;
};

GameField.prototype.haveFreeCells = function(){
    var emptyFieldCounter = 0;
    for (var row = 0; row < this.getNumberOfRows() ; row++) {
        for (var column = 0; column < this.getNumberOfColumns(); column++) {
            if(this.gameArray[row][column] == 0) {
                emptyFieldCounter++;
            }
        }
    }

    if(emptyFieldCounter > 1){
        console.log("we can continue game "+emptyFieldCounter);
        return true;
    }
    else{
        console.log("victory "+emptyFieldCounter);
        return false;
    }
};

GameField.prototype.dumpGameField = function(){
    console.log("----===< Game array >===----");
    var oneRow;
    for (var row = 0; row <= ROWS - 1; row++) {
        oneRow = "";
        for (var column = 0; column <= COLUMNS - 1; column++) {
            oneRow += this.gameArray[row][column] + " ";
        }
        console.log(oneRow);
    }
    console.log("--------------------------");
};

function Snake(){
    this.movementDirection = {"leftToRight":"leftToRight", "bottomToTop":"bottomToTop", "topToBottom":"topToBottom", "rightToLeft":"rightToLeft"};
    this.snakeBody = [];
    this.directionOfMovement = this.movementDirection.leftToRight;
    this.movementIsAllowed = true;
    this.numberOfLives = 0;
    this.numberOfEatenItems = 0;

    while (this.snakeBody.push([]) < 3);
    var coordinate = 2;

    //we need to place snake along one of the walls in our game field
    for (var body = 0; body < this.getBodyLength(); body++) {
        for (var bodySegment = 0; bodySegment < 2; bodySegment++) {

            this.snakeBody[body].push(0);

            if (bodySegment == 0) {
                this.snakeBody[body][bodySegment] = 0;
            }
            else {
                this.snakeBody[body][bodySegment] = coordinate--;
            }
        }
    }
}

Snake.prototype.getMovementIsAllowed = function(){
    return this.movementIsAllowed;
};

Snake.prototype.setMovementIsAllowed = function(aValue){
    return this.movementIsAllowed = aValue;
};


Snake.prototype.getCurrentDirection = function(){
    return this.directionOfMovement;
};

Snake.prototype.getNumberOfLives = function(){
    return this.numberOfLives;
};

Snake.prototype.setNumberOfLives = function(aNumberOfLives){
    this.numberOfLives = aNumberOfLives;
};

Snake.prototype.takeOneLife = function(){
    this.numberOfLives -= 1;
};

Snake.prototype.eatOneItem = function(){
    this.numberOfEatenItems += 1;
};

Snake.prototype.getNumberOfEatenItems = function(){
    return this.numberOfEatenItems;
};

Snake.prototype.setCurrentDirection = function(aDirection){
    switch (aDirection) {
        case "leftToRight":
            if(this.directionOfMovement == this.movementDirection.rightToLeft){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                this.setMovementIsAllowed(true);
                console.log(this.directionOfMovement);
            }
        break;
        case "rightToLeft":
            if(this.directionOfMovement == this.movementDirection.leftToRight){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
                this.setMovementIsAllowed(true);
            }
         break;
        case "bottomToTop":
            if(this.directionOfMovement == this.movementDirection.topToBottom){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
                this.setMovementIsAllowed(true);
            }
        break;
        case "topToBottom":
            if(this.directionOfMovement == this.movementDirection.bottomToTop){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
                this.setMovementIsAllowed(true);
            }
            break;
    }
};


Snake.prototype.getBodyLength = function(){
    return this.snakeBody.length;
};

Snake.prototype.doOneStepUpward = function(){
    console.log("Snake.prototype.doOneStepDown");
    console.log(this.getCurrentDirection());
    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][0] -= 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
};

Snake.prototype.doOneStepLeft = function(){
    console.log("Snake.prototype.doOneStepLeft");
    console.log(this.getCurrentDirection());


    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;
    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][1] -= 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
};

Snake.prototype.doOneStepRight = function(){
    console.log("Snake.prototype.doOneStepRight");
    console.log(this.getCurrentDirection());
    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][1] += 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
};

Snake.prototype.doOneStepDown = function(){
    console.log("Snake.prototype.doOneStepDown");
    console.log(this.getCurrentDirection());


    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][0] += 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
};

Snake.prototype.getCurrentPosition = function(){
    return this.snakeBody[0];
};

Snake.prototype.increaseBodyLength = function(){
    var tail = this.snakeBody.slice(-1)[0];
    var firstSegment = this.snakeBody.slice(-2)[0];
    this.snakeBody.push([]);

    if(tail[0] == firstSegment[0]){
        // horizontal segment stable vertical should be corrected
        this.snakeBody[this.snakeBody.length-1][0] = tail[0];
        if(tail[1] < firstSegment[1]){
            this.snakeBody[this.snakeBody.length-1][1] = tail[1]-1;
        }
        else{
            this.snakeBody[this.snakeBody.length-1][1] = tail[1]+1;
        }
    }else{
        // vertical segment is stable horizontal should be corrected
        this.snakeBody[this.snakeBody.length-1][1] = tail[1];
        if(tail[0] < firstSegment[0]){
            this.snakeBody[this.snakeBody.length-1][0] = tail[0]-1;
        }
        else{
            this.snakeBody[this.snakeBody.length-1][0] = tail[0]+1;
        }
    }
};

Snake.prototype.ifMealIsPresentEatIt = function(aGameField){
    var aSnakeHead = this.getCurrentPosition();
    switch(this.getCurrentDirection()){
        case "leftToRight":
                if(aGameField.getValue(aSnakeHead[0],(aSnakeHead[1]+1)) == 2){
                    aGameField.setValue(aSnakeHead[0],(aSnakeHead[1]+1),0);
                    this.eatOneItem();
                    return true;
                }
                else{
                    return false;
                }
            break;
        case "rightToLeft":
            if(aGameField.getValue(aSnakeHead[0],(aSnakeHead[1]-1)) == 2){
                aGameField.setValue(aSnakeHead[0],(aSnakeHead[1]-1),0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
        case "bottomToTop":
            if(aGameField.getValue((aSnakeHead[0]-1),aSnakeHead[1]) == 2){
                aGameField.setValue((aSnakeHead[0]-1),aSnakeHead[1],0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
        case "topToBottom":
            if(aGameField.getValue((aSnakeHead[0]+1),aSnakeHead[1]) == 2){
                aGameField.setValue((aSnakeHead[0]+1),aSnakeHead[1],0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
    }
};

function GameController(aDelayValue) {
    this.delayValue = aDelayValue;
    this.gameIsStarted = false;
    this.gameIsPaused = false;
    this.gameIsOver = false;
    this.gameIsFinished = false;
    this.intervalID = 0;
}

GameController.prototype.gameIsStarted = function() {
    return this.gameIsStarted;
};

GameController.prototype.gameIsPaused = function() {
    return this.gameIsPaused;
};

GameController.prototype.gameIsOver = function() {
    return this.gameIsOver;
};

GameController.prototype.setPauseStatus = function(aPauseStatus) {
    this.gameIsPaused = aPauseStatus;
};


GameController.prototype.startMovement = function(){

    if(this.gameIsStarted == false) {
        clearInterval(this.intervalID);
        this.intervalID = setInterval (this.doOneStep, this.delayValue, aSnake);
        this.gameIsStarted = true;
        this.gameIsOver = false;
        //var intervalID = setInterval (aGameController.doOneStep, 1000, aSnake);
    }
    else{
        clearInterval(this.intervalID);
        //document.getElementById("gameIsOver_message").style.display = "block";
    }
    var pauseButton = document.getElementById("pause_button");
    pauseButton.focus();
};

GameController.prototype.setResetPause = function(aMessage, aButtonPauseMessage, aButtonContinueMessage) {
    document.getElementById("game_message").innerHTML = aMessage;
    var pauseButton = document.getElementById("pause_button");
    if(this.gameIsPaused == true) {
        clearInterval(this.intervalID);
        this.intervalID = setInterval (aGameController.doOneStep, this.delayValue, aSnake);
        this.setPauseStatus(false);
        document.getElementById("game_message").style.display = "none";
        document.getElementById("pause_button").innerHTML = aButtonPauseMessage;
    }
    else{
        clearInterval(this.intervalID);
        this.setPauseStatus(true);
        document.getElementById("pause_button").innerHTML = aButtonContinueMessage;
        document.getElementById("game_message").style.display = "block";
    }

    pauseButton.focus();
};

GameController.prototype.doOneStep = function(Snake, GameController) {
    if(aGameField.containsMeal() == false){
        putNewMealToGameField();
    }


    //TODO detect why I should directly use aGameController here, why parameter does not work
    if(aGameController.gameIsOver == false && aGameField.haveFreeCells() == true) {
        switch (Snake.getCurrentDirection()) {
            case "leftToRight":
                moveRight();
                break;
            case "rightToLeft":
                moveLeft();
                break;
            case "bottomToTop":
                moveUpward();
                break;
            case "topToBottom":
                moveDown();
                break;
        }
    }
    else if (aGameController.gameIsOver == true){
        document.getElementById("game_message").innerHTML = "Game is over";
        document.getElementById("game_message").style.display = "block";
        clearInterval(aGameController.intervalID);
    }
    else if(aGameField.haveFreeCells() == false){
        document.getElementById("game_message").innerHTML = "Congratulations!<br>You've won this game!<br>Click start to start new game.";
        document.getElementById("game_message").style.display = "block";
        //clearInterval(this.intervalID);
        //TODO why aGameController but not this.gameIsFinished
        aGameController.gameIsFinished = true;
        this.gameIsStarted = false;
        clearInterval(aGameController.intervalID);
    }
    aGameField.dumpGameField();
    refreshGameInterface();
};

GameController.prototype.collisionHasOccurred = function(GameField, Snake){
    var currentPosition = Snake.getCurrentPosition();
    var result;
    //var currentDirection = Snake.getCurrentDirection();
    switch (Snake.getCurrentDirection()) {
        case "leftToRight":
                result = ((currentPosition[1] + 1) >= GameField.getNumberOfColumns()) ? true : false;
            break;
        case "rightToLeft":
                result = ((currentPosition[1] - 1) < 0) ? true : false;
            break;
        case "bottomToTop":
                result = ((currentPosition[0] - 1) < 0) ? true : false;
            break;
        case "topToBottom":
                result = ((currentPosition[0] + 1) >= GameField.getNumberOfRows()) ? true : false;
            break;
    }
    return result;
};

GameController.prototype.takeOneLifeOrFinishGame = function(Snake) {
    if(Snake.getNumberOfLives() > 0){
        Snake.takeOneLife();
        //alert("One life has been taken "+Snake.getNumberOfLives());
    }
    else{
        //alert("game is over");
        this.gameIsOver = true;
    }
};


GameController.prototype.updateCounters = function(Snake, lifesLeftTag, itemsEatenTag) {
    document.getElementById(lifesLeftTag).innerHTML = Snake.getNumberOfLives();
    document.getElementById(itemsEatenTag).innerHTML = Snake.getNumberOfEatenItems();
};

GameController.prototype.generateRundomValue = function(aMaxValue) {
        return Math.floor(Math.random() * (aMaxValue + 1));
};

function moveDown(){
    aSnake.setCurrentDirection("topToBottom");
    if(!aGameController.collisionHasOccurred(aGameField, aSnake)) {
        tryToFindMealAndDoOneStep();
        aSnake.doOneStepDown();
    }
    else{
        aGameController.takeOneLifeOrFinishGame(aSnake);
    }
    refreshGameInterface();
}

function moveUpward(){
    aSnake.setCurrentDirection("bottomToTop");
    if(!aGameController.collisionHasOccurred(aGameField, aSnake)) {
        tryToFindMealAndDoOneStep();
        aSnake.doOneStepUpward();
    }
    else{
        aGameController.takeOneLifeOrFinishGame(aSnake);
    }
    refreshGameInterface();
}

function tryToFindMealAndDoOneStep(){
    if(aSnake.ifMealIsPresentEatIt(aGameField)){
        if((aSnake.getNumberOfEatenItems()%1) == 0){
            aSnake.increaseBodyLength();
        }
        console.log("meal is found and eaten, new meal should be placed");
        putNewMealToGameField();
    }
}

function moveRight(){
    aSnake.setCurrentDirection("leftToRight");
    if(!aGameController.collisionHasOccurred(aGameField, aSnake)) {
        tryToFindMealAndDoOneStep();
        aSnake.doOneStepRight();
    }
    else{
        aGameController.takeOneLifeOrFinishGame(aSnake);
    }
    refreshGameInterface();
}

function moveLeft(){
    aSnake.setCurrentDirection("rightToLeft");
    if(!aGameController.collisionHasOccurred(aGameField, aSnake)) {
        tryToFindMealAndDoOneStep();
        aSnake.doOneStepLeft();
    }
    else{
        aGameController.takeOneLifeOrFinishGame(aSnake);
    }
    refreshGameInterface();
}

function refreshGameInterface(){
    aGameField.clearGameField();
    aGameField.putSnakeToGameField(aSnake);
    aGameField.refreshGameField();
    aGameController.updateCounters(aSnake, "lifes_count", "items_count");

}

function putNewMealToGameField(){
    var aRundomRow = 0;
    var aRundomColumn = 0;
    var flag = false;
    do{
        aRundomRow = aGameController.generateRundomValue(ROWS-1);
        aRundomColumn = aGameController.generateRundomValue(COLUMNS-1);
        flag = aGameField.putMealToTheGameField(aRundomRow,aRundomColumn);
    }while(flag == false);
    console.log("accepted random values are "+aRundomRow + " " +aRundomColumn);
    aGameField.dumpGameField();
}

function initGame(){
    aGameField = new GameField();
    aSnake = new Snake();
    aSnake.setNumberOfLives(3);
    aGameController = new GameController(1000);

    aGameField.initGameField(ROWS,COLUMNS);
    aGameField.drawGameField("game_field");
    aGameField.putSnakeToGameField(aSnake);
    aGameField.refreshGameField();
    putNewMealToGameField();

    refreshGameInterface();
}

document.onkeyup = function(e) {
    switch (e.keyCode) {
        case 37:
            aSnake.setCurrentDirection("rightToLeft");
            break;
        case 38:
            aSnake.setCurrentDirection("bottomToTop");
            break;
        case 39:
            aSnake.setCurrentDirection("leftToRight");
            break;
        case 40:
            aSnake.setCurrentDirection("topToBottom");
            break;
        case 19:
            // Pause button is clicked
            aGameController.setResetPause("Game is paused","pause game","continue game");
            break;
    }
};

function startGame(){
    aGameField.dumpGameField();

    if(aGameController.gameIsOver == false && aGameController.gameIsFinished == false){
        aGameController.gameIsStarted = false;
        aGameController.startMovement();
    }
    else if (aGameController.gameIsOver == true || aGameController.gameIsFinished == true){
        document.getElementById("game_message").style.display = "none";
        aGameController.gameIsOver = false;
        aGameController.gameIsFinished = false;
        aGameController.gameIsStarted = false;
        aGameField.clearGameField();
        aSnake = new Snake();
        aSnake.setNumberOfLives(3);
        aGameController.startMovement();
        refreshGameInterface();
    }
}