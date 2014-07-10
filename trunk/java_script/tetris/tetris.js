/**
 * Created by oleksiy.konkin on 7/9/2014.
 */
var gameArray = [];
var figureArray = [];
var figureType;
var figurePosition = 1;
var valueX;
var valueY;
var ROW=20;
var COLUMN=12;

function initGameField(aRow, aColumn){
    this.row = aRow;
    this.column = aColumn;
    //var gameArray = [];
    if(gameArray.length == 0) {
        while (gameArray.push([]) < aRow);

        for (var row = 0; row < gameArray.length; row++) {
            for (var col = 0; col < aColumn; col++)
                gameArray[row].push(0);
        }

    }
    else{
        console.log("game array is already initialized");
    }
}

function drawGameField(){
    var myTableDiv = document.getElementById("game_field");
    var table = document.createElement('TABLE');

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var row=0; row < gameArray.length; row++){
        var tr = document.createElement('TR');
        tableBody.appendChild(tr);

        for (var column=0; column < gameArray[row].length; column++){
            var td = document.createElement('TD');
            td.id = "td_"+row+"_"+column;
            //td.appendChild(document.createTextNode(row + "," + column));
            tr.appendChild(td);
        }
    }
    myTableDiv.appendChild(table);
}

generateRandomFigure = function () {
    function getRandomInt(min, max) {
        //return Math.floor(Math.random() * (max - min + 1)) + min;
        // return I
        return 1;
    }

    //var aNum = getRandomInt(1,7);
    aNum = 1;

    switch (aNum) {
        // letter I
        case 1:
            figureArray = [
                [0, 1, 0, 0],
                [0, 1, 0, 0],
                [0, 1, 0, 0],
                [0, 1, 0, 0]
            ];
            figureType = "I";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;
            break;
        // letter J
        case 2:
            ;
            break;
        // letter L
        case 3:
            ;
            break;
        // letter S
        case 4:
            ;
            break;
        // letter T
        case 5:
            ;
            break;
        // letter S
        case 6:
            ;
            break;
        // letter Z
        case 7:
            ;
            break;
    }
}

function putFigureToGameField(){
    //gameArray = figureArray.slice();
    console.log("figure array " + figureArray);
    for (var row = 0; row < figureArray.length; row++) {
        //console.log(figureArray[row]);
        for (var column = 0; column < figureArray.length; column++) {
            //console.log("column "+figureArray[row][column]);
            gameArray[row][column + valueX] = figureArray[row][column]
        }
    }
}

function refreshGameField(){
    for (var row = 0; row < gameArray.length; row++) {
        //console.log(figureArray[row]);
        for (var column = 0; column < gameArray[row].length; column++) {
            //console.log("column "+figureArray[row][column]);
            var tagThatShouldBePainted = "td_" + row + "_" + column;
            var gameCell = document.getElementById(tagThatShouldBePainted);
            if(column < 12) {
                if (gameArray[row][column] != 0) {
                    gameCell.bgColor = 'red';
                }
                else {
                    gameCell.bgColor = 'white';
                }
            }
        }
    }
}

function testFigureGeneration() {
    /*
     var gameField = GameField(4,4);
     var aFigure = RandomFigure();
     var aGameController = GameController();
     aGameController.drawGameField(gameField);
     */

    //console.log("empty game array" + gameArray.length);
    initGameField(ROW,COLUMN);
    console.log("init game array " + gameArray);


    drawGameField();

    generateRandomFigure();
    //console.log("figure array "+ figureArray);
    putFigureToGameField();
    //console.log("game array " + gameArray);
    refreshGameField();

}

function moveFigureRight(){
    //detect if we don't hit the border of our game field
    if(valueX < gameArray[0].length - (figureArray.length-1) && false) {
        valueX += 1;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                gameArray[row][column + valueX] = figureArray[row][column]
            }
        }
    }
    else{
    //we have hit a border of our game field, we should add one hidden column to allow movement
    // in the right direction, however we should stop the figure when it hits our border
        var flag = false;
        var firstOccupiedCellPosition=0;

        for (var row = 0; row < figureArray.length; row++) {
            for (var column = (figureArray.length-1) ; column >= 0; column--) {
                if (figureArray[row][column] == 1){
                    firstOccupiedCellPosition=column+1;
                    if ((column+1+valueX) >= COLUMN){
                        flag = false;
                        console.log("we hit the right border!");
                        console.log("first occupied element is "+firstOccupiedCellPosition);
                        break;
                    }
                    else{
                        flag = true;
                        break;
                    }
                }
            }
        }

        if(/* valueX < gameArray[0].length - figureArray.length &&*/ flag == true) {
            for (var row = 0; row < gameArray.length; row++) {
                gameArray[row].push(0);
            }

            valueX += 1;
            for (var row = 0; row < figureArray.length; row++) {
                for (var column = 0; column < figureArray.length; column++) {
                    gameArray[row][column + valueX] = figureArray[row][column];
               }
            }
        }
        console.log("figure array " +figureArray);
        console.log("test for moving array right in the figure array " + flag);
    }
    refreshGameField();
    console.log(gameArray);
}

function moveFigureLeft(){
    if(valueX > 0) {
        valueX -= 1;
        for (var row = 0; row < figureArray.length; row++) {
            //console.log(figureArray[row]);
            for (var column = 0; column < figureArray.length; column++) {
                //console.log("column "+figureArray[row][column]);
                gameArray[row][column + valueX] = figureArray[row][column]
            }
        }
        refreshGameField();
    }
    console.log(gameArray);
}