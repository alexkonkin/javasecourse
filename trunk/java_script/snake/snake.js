/**
 * Created by oleksiy.konkin on 10/31/2014.
 */
/*
 http://jasmine.github.io/2.0/introduction.html

 http://techoctave.com/c7/posts/77-javascript-testing-with-jasmine

 http://codepen.io/jweden/pen/Irmil

 http://bittersweetryan.github.io/jasmine-presentation/#slide-70


 */

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
}


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
}

GameField.prototype.refreshGameField = function(){
    for (var row = 0; row < this.getNumberOfRows() ; row++) {
        for (var column = 0; column < this.getNumberOfColumns(); column++) {
            var tagThatShouldBePainted = "td_" + row + "_" + column;
            var gameCell = document.getElementById(tagThatShouldBePainted);
            if(column < this.getNumberOfColumns()) {
                if (this.gameArray[row][column] != 0) {
                    gameCell.bgColor = 'red';
                }
                else {
                    gameCell.bgColor = 'white';
                }
            }
        }
    }
}

GameField.prototype.clearGameField = function(){
    for (var row = 0; row < this.getNumberOfRows() ; row++) {
        for (var column = 0; column < this.getNumberOfColumns(); column++) {
                 this.gameArray[row][column] = 0;
        }
    }
}

function Snake(){
    this.movementDirection = {"leftToRight":"leftToRight", "bottomToTop":"bottomToTop", "topToBottom":"topToBottom", "rightToLeft":"rightToLeft"};
    this.snakeBody = [];
    this.directionOfMovement = this.movementDirection.leftToRight;
    this.movementIsAllowed = true;
    this.numberOfLives = 0;

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

function GameController() {
}

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
        alert("One life has been taken "+Snake.getNumberOfLives());
    }
    else{
        alert("game is over");
    }
}



function moveDown(){
    aSnake.setCurrentDirection("topToBottom");
    if(!aGameController.collisionHasOccurred(aGameField, aSnake)) {
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
        aSnake.doOneStepUpward();
    }
    else{
        aGameController.takeOneLifeOrFinishGame(aSnake);
    }
    refreshGameInterface();
}

function moveRight(){
    aSnake.setCurrentDirection("leftToRight");
    if(!aGameController.collisionHasOccurred(aGameField, aSnake)) {
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

}

function initGame(){
    aGameField = new GameField();
    aSnake = new Snake();
    aSnake.setNumberOfLives(3);
    aGameController = new GameController();

    aGameField.initGameField(10,20);
    aGameField.drawGameField("game_field");
    aGameField.putSnakeToGameField(aSnake);
    aGameField.refreshGameField();
}

function test(){
    var arr = aSnake.getCurrentPosition();
    console.log(arr[0]);
    console.log(arr[1]);
}