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
var surfaceIsNotEmpty=false;

// http://www.hunlock.com/blogs/Mastering_Javascript_Arrays#filter
// http://wiki.jetbrains.net/intellij/Debugging_JavaScript_locally_in_Firefox_with_WebStorm_and_PhpStorm

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
        console.log("movement right is allowed : " + movementRightIsAllowed);
        //if(movementRightIsAllowed) {
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
    console.log("valueX "+valueX);
    console.log("valueX > COLUMN-1-(figureArray.length-1)"+(valueX > COLUMN-1-(figureArray.length-1)));
    console.log("valueY > ROW-1-(figureArray.length-1)"+(valueY > ROW-1-(figureArray.length-1)));
    if(valueX < 0 || valueX > COLUMN-1-(figureArray.length-1) || valueY > ROW-1-(figureArray.length-1)){
        borderIsHitted = true;
        console.log("detectIfRotationIsAllowed: we hit the border");
    }
    else{
        borderIsHitted = false;
        console.log("detectIfRotationIsAllowed: we don't touch the border");
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
    for (var row = 0; row < figureArray.length; row++) {
        console.log("detectIfMovementRightIsAllowed row + valueY"+ (row + valueY));
        console.log("detectIfMovementRightIsAllowed (COLUMN-1)" + (COLUMN-1));
        if(gameArray[row + valueY][COLUMN-1] == 1){
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
    dumpGameField();
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
        console.log("---===< detectIfMovementDownIsAllowed >===---");
        console.log("valueY -1 "+ (valueY-1));
        console.log("column + valueX "+(column + valueX));


        if((valueY+figureArray.length)>=ROW ){
            console.log("we should check if we can move the figure inside its own array down");
            row = figureArray.length-1;
            for (var column = 0; column <= figureArray.length-1; column++) {
                if (figureArray[row][column] == 0){
                    if(figureArray[row-1][column]==1){
                        if(valueY+(row-1) < ROW-1){
                            console.log("movement down is still allowed row " + row + "column "+column);
                            movementDownIsAllowed = true;
                            console.log("movement down is allowed I will try to copy elements inside array");
                        }
                        else
                        {
                            movementDownIsAllowed = false;
                            console.log ("556: if(valueY+(row-1) < ROW-1): movement down is not allowed");
                            for (var row = 0; row < figureArray.length; row++) {
                                for (var column = 0; column < figureArray.length; column++) {
                                    if(gameArray[valueY + row][column + valueX] == 1){
                                        //mark this element as the placed on the flor
                                        gameArray[valueY + row][column + valueX] = 2;
                                        console.log("gameArray[valueY + row][column + valueX]"+gameArray[valueY + row][column + valueX]);
                                    }
                                }
                            }
                            console.log(gameArray);
                        }
                    }
                }
                else{
                    movementDownIsAllowed = false;

                    console.log("562: if (figureArray[row][column] == 0): movement down is not allowed");
                    for (var row = 0; row < figureArray.length; row++) {
                        for (var column = 0; column < figureArray.length; column++) {
                            if(gameArray[valueY + row][column + valueX] == 1){
                                //mark this element as the placed on the flor
                                gameArray[valueY + row][column + valueX] = 2;
                            }
                        }
                    }
                    console.log(gameArray);
                }
            }

            break;
        }
        else{
            //at this point we should check if we have any figures between our figure and the bottom of the game field
            //check if we move down with the surface that is filled with 1-s or which is empty
            for (var column = 0; column < figureArray.length; column++) {
                if(figureArray[figureArray.length-1][column] == 1){
                        surfaceIsNotEmpty=true;
                 }
            }

            

            if(surfaceIsNotEmpty){
                //we should check if we have



            }
            else {
            //TODO important don't forget that this is only the location where we allow movement down
                movementDownIsAllowed = true;
            }
            console.log("movement down is allowed but we need to check for the neigboring objects");
        }
    }
}

function dumpGameField(){
    console.log("-------------------------");
    for (var row = 0; row <= ROW-1; row++) {
        oneRow = "";
        for (var column = 0; column <= COLUMN-1; column++) {
            oneRow+= gameArray[row][column]+" ";
        }
        console.log(oneRow);
    }
    console.log("--------------------------");
}

function test(){
    generateRandomFigure();
    putFigureToGameField();
    refreshGameField();
}