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
var borderIsHitted=false;
var movementLeftIsAllowed=true;
var movementRightIsAllowed=true;

// http://www.hunlock.com/blogs/Mastering_Javascript_Arrays#filter

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
         return Math.floor(Math.random() * (max - min + 1)) + min;
         return I
        //return 1;
    }

    var aNum = getRandomInt(1,7);
    //aNum = 1;

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
            figureArray = [
                [0, 0, 1],
                [0, 0, 1],
                [0, 1, 1]
            ];
            figureType = "J";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;

            ;
            break;
        // letter L
        case 3:
            figureArray = [
                [1, 0, 0],
                [1, 0, 0],
                [1, 1, 0]
            ];
            figureType = "L";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;
            ;
            break;
        // letter S
        case 4:
            figureArray = [
                [0, 1, 1],
                [1, 1, 0],
                [0, 0, 0]
            ];
            figureType = "S";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;
            ;
            break;
        // letter T
        case 5:
            figureArray = [
                [1, 1, 1],
                [0, 1, 0],
                [0, 0, 0]
            ];
            figureType = "T";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;
            ;
            break;
        // letter Z
        case 6:
            figureArray = [
                [1, 1, 0],
                [0, 1, 1],
                [0, 0, 0]
            ];
            figureType = "Z";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;

            ;
            break;
        // letter Z
        case 7:
            figureArray = [
                [1, 1],
                [1, 1]
            ];
            figureType = "0";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;

            ;
            break;
    }
}

function rotateFigure(){
    console.log("figure rotation");
    if(!borderIsHitted) {
        switch (figureType) {
            case "I":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [0, 0, 0, 0],
                            [1, 1, 1, 1],
                            [0, 0, 0, 0],
                            [0, 0, 0, 0]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [0, 0, 1, 0],
                            [0, 0, 1, 0],
                            [0, 0, 1, 0],
                            [0, 0, 1, 0]
                        ];
                        figurePosition = 3;
                        break;
                    case 3:
                        figureArray = [
                            [0, 0, 0, 0],
                            [0, 0, 0, 0],
                            [1, 1, 1, 1],
                            [0, 0, 0, 0]
                        ];
                        figurePosition = 4;
                        break;
                    case 4:
                        figureArray = [
                            [0, 1, 0, 0],
                            [0, 1, 0, 0],
                            [0, 1, 0, 0],
                            [0, 1, 0, 0]
                        ];
                        figurePosition = 1;
                        break;
                }
            break;
            case "J":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [0, 0, 0],
                            [1, 0, 0],
                            [1, 1, 1]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [1, 1, 0],
                            [1, 0, 0],
                            [1, 0, 0]
                        ];
                        figurePosition = 3;
                        break;
                    case 3:
                        figureArray = [
                            [1, 1, 1],
                            [0, 0, 1],
                            [0, 0, 0]
                        ];
                        figurePosition = 4;
                        break;
                    case 4:
                        figureArray = [
                            [0, 0, 1],
                            [0, 0, 1],
                            [0, 1, 1]
                        ];
                        figurePosition = 1;
                        break;
                }
            break;
            case "L":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [1, 1, 1],
                            [1, 0, 0],
                            [0, 0, 0]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [0, 1, 1],
                            [0, 0, 1],
                            [0, 0, 1]
                        ];
                        figurePosition = 3;
                        break;
                    case 3:
                        figureArray = [
                            [0, 0, 0],
                            [0, 0, 1],
                            [1, 1, 1]
                        ];
                        figurePosition = 4;
                        break;
                    case 4:
                        figureArray = [
                            [1, 0, 0],
                            [1, 0, 0],
                            [1, 1, 0]
                        ];
                        figurePosition = 1;
                        break;
                }
            break;
            case "S":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [1, 0, 0],
                            [1, 1, 0],
                            [0, 1, 0]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [0, 1, 1],
                            [1, 1, 0],
                            [0, 0, 0]
                        ];
                        figurePosition = 1;
                        break;
                }
            break;
            case "T":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [0, 0, 1],
                            [0, 1, 1],
                            [0, 0, 1]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [0, 0, 0],
                            [0, 1, 0],
                            [1, 1, 1]
                        ];
                        figurePosition = 3;
                        break;
                    case 3:
                        figureArray = [
                            [1, 0, 0],
                            [1, 1, 0],
                            [1, 0, 0]
                        ];
                        figurePosition = 4;
                        break;
                    case 4:
                        figureArray = [
                            [1, 1, 1],
                            [0, 1, 0],
                            [0, 0, 0]
                        ];
                        figurePosition = 1;
                        break;
                }
            break;
            case "Z":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [0, 1, 0],
                            [1, 1, 0],
                            [1, 0, 0]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [1, 1, 0],
                            [0, 1, 1],
                            [0, 0, 0]
                        ];
                        figurePosition = 1;
                        break;
                }
                break;
        }
        putFigureToGameField();
        refreshGameField();
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
        detectIfMovementRightIsAllowed();
        if(/*valueX < COLUMN-2*/movementRightIsAllowed) {
            valueX += 1;
            for (var row = 0; row < figureArray.length; row++) {
                for (var column = 0; column < figureArray.length; column++) {
                    gameArray[row][column + valueX] = figureArray[row][column];
                    gameArray[row][ valueX- 1] = 0;
               }
            }
        }
        console.log("figure array " +figureArray);

    detectIfRotationIsAllowed();

    refreshGameField();
    //console.log(gameArray);
}

function moveFigureLeft(){
    detectIfMovementLeftIsAllowed();
    if(/*valueX >= 0*/movementLeftIsAllowed) {
        valueX -= 1;
        for (var row = 0; row < figureArray.length; row++) {
            //console.log(figureArray[row]);
            for (var column = 0; column < figureArray.length; column++) {
                //console.log("column "+figureArray[row][column]);
                gameArray[row][column + valueX] = figureArray[row][column];
                gameArray[row][column + valueX + 1] = 0;

            }
        }
        refreshGameField();
    }

    detectIfRotationIsAllowed();

    //console.log(gameArray);
}

function detectIfRotationIsAllowed(){
    if(valueX < 0 || (valueX > COLUMN-1-(figureArray.length-1))){
        borderIsHitted = true;
        console.log("we hit the border");
    }
    else{
        borderIsHitted = false;
        console.log("we don't touch the border");
    }
}

function detectIfMovementLeftIsAllowed(){
    for (var row = 0; row < figureArray.length; row++) {
        if(gameArray[row][0] == 1){
            movementLeftIsAllowed = false;
            console.log("movement is not allowed");
            break;
        }
        else{
            movementLeftIsAllowed = true;
        }
    }
    console.log(gameArray[column]);
}

function detectIfMovementRightIsAllowed(){
    for (var row = 0; row < figureArray.length; row++) {
        if(gameArray[row][COLUMN-1] == 1){
            movementRightIsAllowed = false;
            console.log("movement is not allowed");
            break;
        }
        else{
            movementRightIsAllowed = true;
        }
    }
    console.log(gameArray[column]);
}