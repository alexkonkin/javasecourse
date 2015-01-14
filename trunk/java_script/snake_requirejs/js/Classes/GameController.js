/**
 * Created by oleksiy.konkin on 12/26/2014.
 */
define('Classes/GameController',['Classes/Snake','Classes/GameField'],function (Snake, GameField) {

function GameController(aDelayValue, aGameField) {
    this.delayValue = aDelayValue;
    this.GameField = aGameField;
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


GameController.prototype.startMovement = function(Snake, GameField){

    if(this.gameIsStarted == false) {
        var self = this;
        clearInterval(this.intervalID);

        this.intervalID = setInterval (function() {
            self.doOneStep(Snake, GameField);
        }, this.delayValue);
        this.gameIsStarted = true;
        this.gameIsOver = false;
    }
    else{
        clearInterval(this.intervalID);
    }
    var pauseButton = document.getElementById("pause_button");
    pauseButton.focus();
};

GameController.prototype.setResetPause = function(aMessage, aButtonPauseMessage, aButtonContinueMessage, Snake, GameField) {
    document.getElementById("game_message").innerHTML = aMessage;
    var self = this,
        pauseButton = document.getElementById("pause_button");

    if(this.gameIsPaused == true) {
        clearInterval(this.intervalID);
        //TODO is closure has allowed to fix undefined not a function error here
        this.intervalID = setInterval (function() {
            self.doOneStep(Snake, GameField);
        }, this.delayValue, Snake, GameField);


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

GameController.prototype.putNewMealToGameField = function(aGameField){
        var aRundomRow = 0;
        var aRundomColumn = 0;
        var flag = false;
        this.GameField = aGameField;
        do{
            aRundomRow = this.generateRundomValue(/*ROWS-1*/this.GameField.getNumberOfRows()-1);
            aRundomColumn = this.generateRundomValue(/*COLUMNS-1*/this.GameField.getNumberOfColumns()-1);
            flag = this.GameField.putMealToTheGameField(aRundomRow,aRundomColumn);
        }while(flag == false);
        console.log("accepted random values are "+aRundomRow + " " +aRundomColumn);
        //TODO solve Uncaught TypeError: Cannot read property '1' of undefined, it raised because gameArray is sometimes empty
        //this.GameField.dumpGameField();
};

GameController.prototype.tryToFindMealAndDoOneStep = function (Snake, GameField){
        if(Snake.ifMealIsPresentEatIt(GameField)){
            if((Snake.getNumberOfEatenItems()% Snake.getGrowSpeed()) == 0){
            Snake.increaseBodyLength();
        }
            console.log("meal is found and eaten, new meal should be placed");
            this.putNewMealToGameField(GameField);
        }
};

GameController.prototype.moveRight = function (Snake, GameField){
        Snake.setCurrentDirection("leftToRight");
        if(this.collisionHasOccurred(GameField, Snake) == false) {
            this.tryToFindMealAndDoOneStep(Snake, GameField);
            Snake.doOneStepRight();
        }
        else{
            this.takeOneLifeOrFinishGame(Snake);
        }
        this.refreshGameInterface(Snake);
};

GameController.prototype.moveLeft = function (Snake, GameField){
        Snake.setCurrentDirection("rightToLeft");
        if(this.collisionHasOccurred(GameField, Snake) == false) {
            this.tryToFindMealAndDoOneStep(Snake, GameField);
            Snake.doOneStepLeft();
        }
        else{
            this.takeOneLifeOrFinishGame(Snake);
        }
        this.refreshGameInterface(Snake);
};

GameController.prototype.moveDown = function(Snake, GameField){
        Snake.setCurrentDirection("topToBottom");
        if(this.collisionHasOccurred(GameField, Snake) == false) {
            this.tryToFindMealAndDoOneStep(Snake, GameField);
            Snake.doOneStepDown();
        }
        else{
            this.takeOneLifeOrFinishGame(Snake);
        }
        this.refreshGameInterface(Snake);
};

GameController.prototype.moveUpward = function(Snake, GameField){
        Snake.setCurrentDirection("bottomToTop");
        if(this.collisionHasOccurred(GameField, Snake) == false) {
            this.tryToFindMealAndDoOneStep(Snake, GameField);
            Snake.doOneStepUpward();
        }
        else{
            this.takeOneLifeOrFinishGame(Snake);
        }
        this.refreshGameInterface(Snake);
};


GameController.prototype.doOneStep = function(Snake, GameField) {
    this.GameField = GameField;
    ////TODO detect why I should directly use aGameController here, why parameter does not work
    //if(aGameField.containsMeal() == false){
    if(this.GameField.containsMeal() == false){
        this.putNewMealToGameField();
    }

    if(this.gameIsOver == false && this.GameField.haveFreeCells() == true) {
        switch (Snake.getCurrentDirection()) {
            case "leftToRight":
                this.moveRight(Snake, GameField);
                break;
            case "rightToLeft":
                this.moveLeft(Snake, GameField);
                break;
            case "bottomToTop":
                this.moveUpward(Snake, GameField);
                break;
            case "topToBottom":
                this.moveDown(Snake, GameField);
                break;
        }
    }

    else if (this.gameIsOver == true){
        document.getElementById("game_message").innerHTML = "Game is over";
        document.getElementById("game_message").style.display = "block";
        clearInterval(this.intervalID);
    }
    else if(this.GameField.haveFreeCells() == false){
        document.getElementById("game_message").innerHTML = "Congratulations!<br>You've won this game!<br>Click start to start new game.";
        document.getElementById("game_message").style.display = "block";
        this.gameIsFinished = true;
        this.gameIsStarted = false;
        clearInterval(this.intervalID);
    }
    this.refreshGameInterface(Snake);
};

GameController.prototype.refreshGameInterface = function(Snake){
    this.GameField.clearGameField();
    this.GameField.putSnakeToGameField(Snake);
    this.GameField.refreshGameField();
    this.updateCounters(Snake, "lifes_count", "items_count", "body_count");
};

GameController.prototype.collisionHasOccurred = function(GameField, Snake){
    var currentPosition = Snake.getCurrentPosition();
    var result;

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
    }
    else{
        this.gameIsOver = true;
    }
};


GameController.prototype.updateCounters = function(Snake, lifesLeftTag, itemsEatenTag, bodyLengthTag) {
    document.getElementById(lifesLeftTag).innerHTML = Snake.getNumberOfLives();
    document.getElementById(itemsEatenTag).innerHTML = Snake.getNumberOfEatenItems();
    document.getElementById(bodyLengthTag).innerHTML = Snake.getBodyLength();
};

GameController.prototype.generateRundomValue = function(aMaxValue) {
    return Math.floor(Math.random() * (aMaxValue + 1));
};

    return GameController;
});
