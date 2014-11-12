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


Snake.prototype.getCurrentDirection = function(){
    return this.directionOfMovement;
};

Snake.prototype.setCurrentDirection = function(aDirection){
    switch (aDirection) {
        case "leftToRight":
            if(this.directionOfMovement == "rightToLeft"){
                console.log("such movement is prohibited");
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
            }
        break;
        case "rightToLeft":
            if(this.directionOfMovement == "leftToRight"){
                console.log("such movement is prohibited");
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
            }
         break;
        case "bottomToTop":
            if(this.directionOfMovement == "topToBottom"){
                console.log("such movement is prohibited");
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
            }
        break;
        case "topToBottom":
            if(this.directionOfMovement == "bottomToTop"){
                console.log("such movement is prohibited");
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
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
    this.setCurrentDirection("topToBottom");

    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    for (var body = 0; body < this.getBodyLength(); body++) {
        if(body == 0) {
            tmpHorizontal = this.snakeBody[body][0];
            tmpVertical = this.snakeBody[body][1];
            this.snakeBody[body][0] -= 1;
        }
        else{
            currentValueHorizontal = this.snakeBody[body][0];
            currentValueVertical = this.snakeBody[body][1];

            this.snakeBody[body][0] = tmpHorizontal;
            this.snakeBody[body][1] = tmpVertical;

            tmpHorizontal = currentValueHorizontal;
            tmpVertical = currentValueVertical;
        }
    }
};

Snake.prototype.doOneStepLeft = function(){
    console.log("Snake.prototype.doOneStepRight");
    console.log(this.getCurrentDirection());
    this.setCurrentDirection("leftToRight");

    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    for (var body = 0; body < this.getBodyLength(); body++) {
        if(body == 0) {
            tmpHorizontal = this.snakeBody[body][0];
            tmpVertical = this.snakeBody[body][1];
            this.snakeBody[body][1] -= 1;
        }
        else{
            currentValueHorizontal = this.snakeBody[body][0];
            currentValueVertical = this.snakeBody[body][1];

            this.snakeBody[body][0] = tmpHorizontal;
            this.snakeBody[body][1] = tmpVertical;

            tmpHorizontal = currentValueHorizontal;
            tmpVertical = currentValueVertical;
        }
    }
};

Snake.prototype.doOneStepRight = function(){
    console.log("Snake.prototype.doOneStepRight");
    console.log(this.getCurrentDirection());
    this.setCurrentDirection("leftToRight");

    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    for (var body = 0; body < this.getBodyLength(); body++) {
        if(body == 0) {
            tmpHorizontal = this.snakeBody[body][0];
            tmpVertical = this.snakeBody[body][1];
            this.snakeBody[body][1] += 1;
        }
        else{
            currentValueHorizontal = this.snakeBody[body][0];
            currentValueVertical = this.snakeBody[body][1];

            this.snakeBody[body][0] = tmpHorizontal;
            this.snakeBody[body][1] = tmpVertical;

            tmpHorizontal = currentValueHorizontal;
            tmpVertical = currentValueVertical;
        }
    }

};

Snake.prototype.doOneStepDown = function(){
    console.log("Snake.prototype.doOneStepDown");
    console.log(this.getCurrentDirection());
    this.setCurrentDirection("topToBottom");

    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    for (var body = 0; body < this.getBodyLength(); body++) {
        if(body == 0) {
            tmpHorizontal = this.snakeBody[body][0];
            tmpVertical = this.snakeBody[body][1];
            this.snakeBody[body][0] += 1;
        }
        else{
            currentValueHorizontal = this.snakeBody[body][0];
            currentValueVertical = this.snakeBody[body][1];

            this.snakeBody[body][0] = tmpHorizontal;
            this.snakeBody[body][1] = tmpVertical;

            tmpHorizontal = currentValueHorizontal;
            tmpVertical = currentValueVertical;
        }
    }
};


var gameField;
//var aSnake;

function moveDown(){
    aSnake.doOneStepDown();
    gameField.clearGameField();
    gameField.putSnakeToGameField(aSnake);
    gameField.refreshGameField();
}

function moveUpward(){
    aSnake.doOneStepUpward();
    gameField.clearGameField();
    gameField.putSnakeToGameField(aSnake);
    gameField.refreshGameField();
}

function moveRight(){
    aSnake.doOneStepRight();
    gameField.clearGameField();
    gameField.putSnakeToGameField(aSnake);
    gameField.refreshGameField();
}

function moveLeft(){
    aSnake.doOneStepLeft();
    gameField.clearGameField();
    gameField.putSnakeToGameField(aSnake);
    gameField.refreshGameField();
}

function initGame(){
    gameField = new GameField();
    aSnake = new Snake();

    gameField.initGameField(10,20);
    gameField.drawGameField("game_field");
    gameField.putSnakeToGameField(aSnake);
    gameField.refreshGameField();
}