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
var movementDownIsAllowed=true;

// http://www.hunlock.com/blogs/Mastering_Javascript_Arrays#filter

function initGameField(aRow, aColumn){
    this.row = aRow;
    this.column = aColumn;

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
            tr.appendChild(td);
        }
    }
    myTableDiv.appendChild(table);

    increaseSizeOfTheGameFieldInTwoExtraRows ();
}

generateRandomFigure = function () {
    function getRandomInt(min, max) {
         return Math.floor(Math.random() * (max - min + 1)) + min;
         return I
    }

    var aNum = getRandomInt(1,7);

    var borderIsHitted=false;
    var movementLeftIsAllowed=true;
    var movementRightIsAllowed=true;
    var movementDownIsAllowed=true;

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
    else{
        console.log("rotation is not allowed");
    }
}

function putFigureToGameField(){
    for (var row = 0; row < figureArray.length; row++) {
        for (var column = 0; column < figureArray.length; column++) {
            gameArray[row + valueY][column + valueX] = figureArray[row][column]
        }
    }
}

function refreshGameField(){
    for (var row = 0; row < /*gameArray.length*/ROW ; row++) {
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
    initGameField(ROW,COLUMN);
    console.log("init game array " + gameArray);

    drawGameField();

    generateRandomFigure();
    putFigureToGameField();
    refreshGameField();

}

function moveFigureRight(){
        detectIfMovementRightIsAllowed();
        if(movementRightIsAllowed) {
            valueX += 1;
            for (var row = 0; row < figureArray.length; row++) {
                for (var column = 0; column < figureArray.length; column++) {
                    gameArray[row + valueY][column + valueX] = figureArray[row][column];
                    gameArray[row + valueY][ valueX- 1] = 0;
               }
            }
        }
        console.log("figure array " +figureArray);

    detectIfRotationIsAllowed();

    refreshGameField();
}

function moveFigureLeft(){
    detectIfMovementLeftIsAllowed();
    if(movementLeftIsAllowed) {
        valueX -= 1;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                gameArray[row + valueY][column + valueX] = figureArray[row][column];
                gameArray[row + valueY][column + valueX + 1] = 0;

            }
        }
        refreshGameField();
    }
    detectIfRotationIsAllowed();
}

function detectIfRotationIsAllowed(){
    if(valueX < 0 || (valueX > COLUMN-1-(figureArray.length-1)) || (valueY > ROW-1-(figureArray.length-1))){
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
        if(gameArray[row + valueY][0] == 1){
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
    /*
    for (var row = 0; row < figureArray.length; row++) {
        if(gameArray[row+valueY][COLUMN-1] == 1){
            movementRightIsAllowed = false;
            console.log("gameArray["+ (row+valueY)+"]["+(COLUMN-1)+"] "+gameArray[row+valueY][COLUMN-1]);
            console.log("right movement is not allowed");
            break;
        }
        else{
            movementRightIsAllowed = true;
            console.log("gameArray["+ (row+valueY)+"]["+(COLUMN-1)+"] "+gameArray[row+valueY][COLUMN-1]);
            console.log("movement right is allowed");
        }
    }
    console.log(gameArray[column]);
    */
    for (var row = 0; row < figureArray.length; row++) {
        if(gameArray[row+valueY][valueX+figureArray.length-1] == 1){
            movementRightIsAllowed = false;
            console.log("gameArray["+ (row+valueY)+"]["+(valueX+figureArray.length-1)+"] "+figureArray[row+valueY][valueX+figureArray.length-1]);
            console.log("right movement is not allowed");
            break;
        }
        else{
            movementRightIsAllowed = true;
            console.log("gameArray["+ (row+valueY)+"]["+(valueX+figureArray.length-1)+"] "+figureArray[row+valueY][valueX+figureArray.length-1]);
            console.log("movement right is allowed");
        }
    }
    console.log(gameArray[column]);

}

function placeFigureDown(){
    detectIfMovementDownIsAllowed();
    detectIfRotationIsAllowed();
    if(movementDownIsAllowed){
        valueY += 1;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                gameArray[valueY - 1][column + valueX] = 0;
                gameArray[row + valueY][column + valueX] = figureArray[row][column];
            }
        }
        refreshGameField();
    }
}

function increaseSizeOfTheGameFieldInTwoExtraRows (){
    var tmpArray = [];
    for (var column = 0; column < COLUMN; column++) {
        tmpArray.push(0);
    }
    gameArray.push(tmpArray);
    gameArray.push(tmpArray);
}

function detectIfMovementDownIsAllowed(){
    for (var column = 0; column < figureArray.length; column++) {
        if(gameArray[ROW-1][column + valueX] == 1){
            movementDownIsAllowed = false;
            console.log("movement down is not allowed");
            break;
        }
        else{
            movementDownIsAllowed = true;
        }
    }
}

function test(){
    generateRandomFigure();
    putFigureToGameField();
    refreshGameField();
}