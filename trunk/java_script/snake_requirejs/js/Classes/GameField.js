/**
 * Created by oleksiy.konkin on 12/26/2014.
 */
define('Classes/GameField', ['Classes/Snake'], function (Snake) {

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
    for(var body = 0; body < Snake.getBodyLength(); body++){
        raw = Snake.snakeBody[body][0];
        column = Snake.snakeBody[body][1];
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
    for (var row = 0; row <= /*ROWS - 1*/this.row-1; row++) {
        oneRow = "";
        for (var column = 0; column <= /*COLUMNS - 1*/this.column-1; column++) {
            oneRow += this.gameArray[row][column] + " ";
        }
        console.log(oneRow);
    }
    console.log("--------------------------");
};

    return GameField;
});