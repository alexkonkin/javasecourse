/**
 * Created by oleksiy.konkin on 7/9/2014.
 */
var gameArray = [];
var figureArray = [];
var figureType;
var figurePosition = 1;
var valueX;
var valueY;

//These adjustments define a size of the game field
var ROW=20;
//var ROW=6;
var COLUMN=12;
//var COLUMN=6;

var borderIsHitted=false;
var movementLeftIsAllowed=true;
var movementRightIsAllowed=true;
var movementDownIsAllowed=true;
var figureIsPlasedDown=false;
var nextRowIsEmpty=true;
var transformOneToTwo=false;
var oneRowIsFull=-1;
var collectedRowsCounter=0;
var letterCounter = new LetterCounter();
var gameIsPaused = false;
var intervalID;
var gameIsOver = false;


// http://www.hunlock.com/blogs/Mastering_Javascript_Arrays#filter
// http://wiki.jetbrains.net/intellij/Debugging_JavaScript_locally_in_Firefox_with_WebStorm_and_PhpStorm

//console log to html page
//http://jsfiddle.net/arunpjohny/mGDet/
//http://stackoverflow.com/questions/20256760/javascript-console-log-to-html

//jasmine framework
//https://www.youtube.com/watch?v=9xkfgprKTmY

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
    }

    //TODO uncomment random generation when issue with Z letter is solved
    var aNum = getRandomInt(1,7);
    //TODO issue with Z and S (6 and 4) figures one extra segment is added if this figure touches the bottom of the game field
    //TODO in the condition below could be defined numbers between 1 and 7 to debug one particular element of the game
    //var aNum = 5;

    borderIsHitted=false;
    movementLeftIsAllowed=true;
    movementRightIsAllowed=true;
    movementDownIsAllowed=true;
    figureIsPlasedDown=false;

    switch (aNum) {
        // letter I
        case 1:
            figureArray = [
                [0, 1, 0],
                [0, 1, 0],
                [0, 1, 0]
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
            break;
        // letter Z
        case 7:
            figureArray = [
                [1, 1],
                [1, 1]
            ];
            figureType = "O";
            figurePosition = 1;
            valueX = 0;
            valueY = 0;
            break;
    }
    console.log("figure type is "+figureType);
    letterCounter.incLetterCounterAndUpdateGUI(figureType.toString());
};

function rotateFigure(){
    console.log("figure rotation");
    if(!borderIsHitted) {
        switch (figureType) {
            case "I":
                switch (figurePosition) {
                    case 1:
                        figureArray = [
                            [0, 0, 0],
                            [1, 1, 1],
                            [0, 0, 0]
                        ];
                        figurePosition = 2;
                        break;
                    case 2:
                        figureArray = [
                            [0, 1, 0],
                            [0, 1, 0],
                            [0, 1, 0]
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
    refreshGuiRowCounter();
}

function testFigureGeneration() {
    console.log("testFigureGeneration()");
    initGameField(ROW,COLUMN);
    drawGameField();
}

function moveFigureRight(){
    console.log("moveFigureRight");
    if(figureIsPlasedDown == false) {
        detectIfMovementRightIsAllowed();
    }

        if(movementRightIsAllowed) {
            valueX += 1;
            for (var row = 0; row < figureArray.length; row++) {
                for (var column = 0; column < figureArray.length; column++) {
                    //TODO new right
                    if(gameArray[row + valueY][column + valueX] !=2) {
                        gameArray[row + valueY][column + valueX] = figureArray[row][column];
                        if(gameArray[row + valueY][ valueX- 1]!=2) {
                            gameArray[row + valueY][ valueX - 1] = 0;
                        }
                    }
                }
            }
        }
    detectIfRotationIsAllowed();
    refreshGameField();
}

function moveFigureLeft(){
    console.log("moveFigureLeft");
    console.log("-------------------------");

    if(figureIsPlasedDown == false) {
        detectIfMovementLeftIsAllowed();
    }
    if(movementLeftIsAllowed) {
        valueX -= 1;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                if(gameArray[row + valueY][column + valueX] !=2) {
                    gameArray[row + valueY][column + valueX] = figureArray[row][column];
                    if(gameArray[row + valueY][column + valueX + 1] != 2) {
                        gameArray[row + valueY][column + valueX + 1] = 0;
                    }
                }
            }
        }
        refreshGameField();
    }
    detectIfRotationIsAllowed();
    console.log("valueX "+valueX);
    console.log("valueY "+valueY);
    dumpGameField();
}

function detectIfRotationIsAllowed(){
    console.log("detectIfRotationIsAllowed");
    console.log("-------------------------");
    if(valueX < 0 || valueX > COLUMN-1-(figureArray.length-1) || valueY > ROW-1-(figureArray.length-1)){
        borderIsHitted = true;
        console.log("detectIfRotationIsAllowed: we hit the border");
    }
    else{
        //now we have to check if a part of the bottom surface is present in the scope of our figure
        borderIsHitted = false;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                if(gameArray[row + valueY][column + valueX] == 2) {
                    borderIsHitted = true;
                    console.log("detectIfRotationIsAllowed: we hit the border");
                }
            }
        }
    }
}

function detectIfMovementLeftIsAllowed(){
    if(valueX > /*figureArray.length-1*/0){
        console.log("---===< detectIfMovementRightIsAllowed valueX < COLUMN - figureArray.length:  >===---");
        movementLeftIsAllowed = false;
        //column = 0;
        var abort = false;
        for (var row = 0; row < figureArray.length && abort != true; row++) {
            //TODO we scan only two first columns of the figure
            for(var column = 0; column < figureArray.length-1 && abort != true; column++) {
                if ((gameArray[valueY + row][column + valueX - 1] == 2 && gameArray[valueY + row][column + valueX] == 0) ||
                    (gameArray[valueY + row][column + valueX - 1] == 0 && gameArray[valueY + row][column + valueX] == 1) ||
                    (gameArray[valueY + row][column + valueX - 1] == 0 && gameArray[valueY + row][column + valueX] == 0) ||
                    //this check is strange because it is related to test inside figure's body, maybe this should be improved
                    (gameArray[valueY + row][column + valueX - 1] == 1 && gameArray[valueY + row][column + valueX] == 1) ||
                    (gameArray[valueY + row][column + valueX - 1] == 0 && gameArray[valueY + row][column + valueX] == 2) ||
                    (gameArray[valueY + row][column + valueX - 1] == 2 && gameArray[valueY + row][column + valueX] == 2)||
                    //we check the internal part of the figure
                    (gameArray[valueY + row][column + valueX - 1] == 1 && gameArray[valueY + row][column + valueX] == 0)){
                    //let's try to detect if we can move down
                    //gameArray[valueY + row][column + valueX] = 2;
                    console.log("movement down is allowed we should not collide with the bottom elements");
                    //console.log("gameArray[valueY + row][column + valueX]"+gameArray[valueY + row][column + valueX]);
                    movementLeftIsAllowed = true;
                }
                else {
                    //for example gameArray[valueY + row][column + valueX + 1] == 2 && gameArray[valueY + row][column + valueX] == 2)
                    console.log("MOVEMENT LEFT IS PROHIBITED!");
                    movementLeftIsAllowed = false;
                    abort = true;
                    //break;
                }
            }
        }

    }
    else {
        //this is a left border condition
        movementLeftIsAllowed = false;
            for (row = 0; row < figureArray.length; row++) {
                if (gameArray[row + valueY][0] == 1) {
                    movementLeftIsAllowed = false;
                    console.log("movement is not allowed");
                    break;
                }
                else {
                    movementLeftIsAllowed = true;
                }

            }
    }

    dumpGameField();
}

function detectIfMovementRightIsAllowed(){
    var column;
    if (valueX < COLUMN - figureArray.length) {
        console.log("---===< detectIfMovementRightIsAllowed valueX < COLUMN - figureArray.length:  >===---");
        movementRightIsAllowed = false;
        column = figureArray.length - 1;
        for (var row = 0; row < figureArray.length; row++) {
            if ((gameArray[valueY + row][column + valueX + 1] == 2 && gameArray[valueY + row][column + valueX] == 0) ||
                (gameArray[valueY + row][column + valueX + 1] == 0 && gameArray[valueY + row][column + valueX] == 1) ||
                (gameArray[valueY + row][column + valueX + 1] == 0 && gameArray[valueY + row][column + valueX] == 0) ||
                //this check is strange because it is related to test inside figure's body, maybe this should be improved
                (gameArray[valueY + row][column + valueX + 1] == 1 && gameArray[valueY + row][column + valueX] == 1) ||
                (gameArray[valueY + row][column + valueX + 1] == 0 && gameArray[valueY + row][column + valueX] == 2)) {
                //let's try to detect if we can move down
                //gameArray[valueY + row][column + valueX] = 2;
                console.log("movement down is allowed we should not collide with the bottom elements");
                //console.log("gameArray[valueY + row][column + valueX]"+gameArray[valueY + row][column + valueX]);
                movementRightIsAllowed = true;
            }
            else {
                //for example gameArray[valueY + row][column + valueX + 1] == 2 && gameArray[valueY + row][column + valueX] == 2)
                movementRightIsAllowed = false;
                break;
            }
        }

    }
    else {
        //this is a right border condition
        movementRightIsAllowed = false;
        for (row = 0; row < figureArray.length; row++) {
            if (gameArray[row + valueY][COLUMN - 1] == 1) {
                movementRightIsAllowed = false;
                console.log("movement is not allowed");
                break;
            }
            else {
                movementRightIsAllowed = true;
            }
        }
    }
    dumpGameField();
}

function placeFigureDown(){
    if(figureIsPlasedDown == false) {
        detectIfMovementDownIsAllowed();
        detectIfRotationIsAllowed();
    }

    console.log("placeFigureDown()");
    console.log("-------------------------");

    if(transformOneToTwo){
        console.log("we should start transformation");
        transformFigureToBottomSurface();
    }

    //check if the figure that we have been placed to the bottom of the game field managed to
    //fill the gap and created the full line, in such case we can remove it from the game surface
    //var theLineIsFull = testIfOneFullLineIsPresentInTheGameField();
    if(/*theLineIsFull*/testIfOneFullLineIsPresentInTheGameField() > 0){
        console.log("we have one full line in the game surface, we can remove this like and increase our score");
        scanGameSurfaceAndRemoveFullRow();
        dumpGameField();
    }

    if(movementDownIsAllowed && (gameIsPaused == false)&& (gameIsOver == false)){

        valueY += 1;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                if((valueY+figureArray.length)<= ROW) {
                    console.log("---===<(valueY+figureArray.length)<= ROW)  clearing one row above>===---");
                    gameArray[valueY - 1][column + valueX] = 0;
                    //we should not override 2 with 0
                    if(gameArray[row + valueY][column + valueX]!=2) {
                        gameArray[row + valueY][column + valueX] = figureArray[row][column];
                    }
                }
                if((valueY+figureArray.length) > ROW) {
                    gameArray[valueY - 1][column + valueX] = 0;
                    //attempt to skip copying empty value to 2
                    if(figureArray[row][column]==1) {
                        //try to reset the 1 in the previous position
                        if(row>0) {
                            if (figureArray[row - 1][column] == 0) {
                                console.log("we should set the the cell above to 0");
                                console.log("---===< (valueY+figureArray.length) > ROW  clearing one row above>===---");
                                gameArray[row + valueY -1][column + valueX] = 0;
                            }
                        }
                        gameArray[row + valueY][column + valueX] = figureArray[row][column];
                    }
                }
            }
        }
        refreshGameField();
    }
    console.log("valueX "+valueX);
    console.log("valueY "+valueY);
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
    //this part is dedicated to detect the very bottom of the game field
    //for (var column = 0; column < figureArray.length; column++) {
    console.log("should we start transformation of 1 to 2 " + testIfFigureShouldBeTransformedToSurface());
    //TODO maybe here we can organize a cycle and not the simple condition
    if(testIfFigureShouldBeTransformedToSurface()){
        movementDownIsAllowed = false;
    }
    else {
        if ((valueY + figureArray.length) >= ROW) {
            console.log("valueY+figureArray.length)>=ROW");
            console.log("we should check if we can move the figure inside its own array down");
            row = figureArray.length - 1;
            for (var column = 0; column <= figureArray.length - 1; column++) {
                if (figureArray[row][column] == 0) {
                    if (figureArray[row - 1][column] == 1) {
                        if (valueY + (row - 1) < ROW - 1) {
                            console.log("movement down is still allowed row " + row + "column " + column);
                            movementDownIsAllowed = true;
                            console.log("movement down is allowed I will try to copy elements inside array");
                        }
                        else {
                            movementDownIsAllowed = false;
                            transformOneToTwo = true;
                        }
                    }
                }
                else {
                    // we have touched the bottom with the side that is filled with 1, we have to overwrite it with 2
                    movementDownIsAllowed = false;
                    transformOneToTwo = true;
                }
            }
            //break;
        }

        if ((valueY + figureArray.length) < ROW) {
            console.log("valueY+figureArray.length)<ROW");
            console.log("------------------------------");
            console.log("we have not touched the bottom of the game field");
            console.log("valueX " + valueX);
            console.log("valueY " + valueY);
            //check if the next row is occupied with the figure
            nextRowIsEmpty = true;
            for ( row = figureArray.length; row > 0; row--) {
                for ( column = 0; column < figureArray.length; column++) {
                    if (gameArray[valueY + row][column + valueX] == 2) {
                        //mark this element as the placed on the flor
                        console.log("inetrnal cycle " + gameArray[valueY + row][column + valueX]);
                        //console.log("");
                        nextRowIsEmpty = false;
                    }
                }
                break;
            }

            if (nextRowIsEmpty == false) {
                console.log("---===< we have not touched the border, next row is not empty - let's check if we can move >===---");
                //we have to check if the meaning values in the figure don't collide with the bottom,
                // if we collide - don't move, if no we can move, but we should not overwrite the bottom values
                for (var row = figureArray.length - 1; row > 0; row--) {
                    for ( column = 0; column < figureArray.length; column++) {
                        //valueY + row +1 - I want to check the row which is under the very first row of my figure
                        if ((gameArray[valueY + row + 1][column + valueX] == 2 && figureArray[row][column] == 0) ||
                            (gameArray[valueY + row + 1][column + valueX] == 0 && figureArray[row][column] == 1) ||
                            (gameArray[valueY + row + 1][column + valueX] == 0 && figureArray[row][column] == 0) ||
                            //this check is strange because it is related to test inside figure's body, maybe this should be improved
                            (gameArray[valueY + row + 1][column + valueX] == 1 && figureArray[row][column] == 1)) {
                            //let's try to detect if we can move down
                            //gameArray[valueY + row][column + valueX] = 2;
                            console.log("movement down is allowed we should not collide with the bottom elements");
                            //console.log("gameArray[valueY + row][column + valueX]"+gameArray[valueY + row][column + valueX]);
                            movementDownIsAllowed = true;
                        }
                        else {
                            //one extra condition check for I item, if it hits right border with its row of 1-s the very right column is out of the border
                            //so we should not check the very right row, it is not visible in the game field
                            if(gameArray[valueY + row + 1][column + valueX] != undefined ) {
                                movementDownIsAllowed = false;
                            }
                        }
                    }
                }


                if (movementDownIsAllowed == true) {
                    console.log("let's try to move down on one position");
                    valueY += 1;

                    for ( row = 0; row < figureArray.length; row++) {
                        for ( column = 0; column < figureArray.length; column++) {
                            //we should not clear the field if it is occupied with the figure that has been already
                            //attached to the bottom of the game field, we need just to slide down
                            if(gameArray[valueY - 1][column + valueX] != 2) {
                                gameArray[valueY - 1][column + valueX] = 0;
                            }
                            if (gameArray[row + valueY ][column + valueX] == 0 || gameArray[row + valueY ][column + valueX] == 1) {
                                gameArray[row + valueY][column + valueX] = figureArray[row][column];
                            }
                            else {
                                console.log(gameArray[row + valueY][column + valueX]);
                            }
                        }
                        dumpGameField();
                    }
                    refreshGameField();
                }


                movementDownIsAllowed = false;
            }
            else {
                movementDownIsAllowed = true;
            }

        }
    }//testIfFigureShouldBeTransformedToSurface
}

function testIfFigureShouldBeTransformedToSurface(){
    transformOneToTwo=false;
    for (var row = 0; row < figureArray.length; row++) {
        for (var column = 0; column < figureArray.length; column++) {
            //we collide with another figure
            if(gameArray[row + valueY ][column + valueX]==1 && gameArray[row + valueY +1][column + valueX]==2) {
                console.log("we should start transformation process");
                transformOneToTwo = true;
                return transformOneToTwo;
            }
            else{
                console.log("the figure is still ok");
            }
            //we collide with the bottom of the game field
            if(gameArray[row + valueY ][column + valueX]==1 && gameArray[row + valueY +1][column + valueX]==2) {
                console.log("we should start transformation process");
                transformOneToTwo = true;
                return transformOneToTwo;
            }
        }
        dumpGameField();
    }
    return transformOneToTwo;
}

function transformFigureToBottomSurface(){
    console.log("---===< transform figure to the bottom surface >===---");
    for (var row = 0; row < figureArray.length; row++) {
        for (var column = 0; column < figureArray.length; column++) {
            if(gameArray[row + valueY ][column + valueX]==1) {
                gameArray[row + valueY][column + valueX] = 2;
            }
        }
    }
    //we attached the figure to the bottom surface of the game field, now
    //we should disconnect from the current figure
    valueX = 0;
    valueY = 0;
    movementLeftIsAllowed=false;
    movementRightIsAllowed=false;
    movementDownIsAllowed=false;
    figureIsPlasedDown=true;
    console.log("valueX "+valueX);
    console.log("valueY "+valueY);
    console.log("movementLeftIsAllowed " + movementLeftIsAllowed);
    console.log("movementRightIsAllowed " + movementRightIsAllowed);
    console.log("movementDownIsAllowed " + movementDownIsAllowed);

    dumpGameField();
    //we have finished with the current figure, now we need to generate a new one
    generateNewFigureAndPlaceItToTheGameField();
    startMovement();
}

function testIfOneFullLineIsPresentInTheGameField(){
    for (var row = ROW-1; row > 0; row--) {
        //we have to reset the counter for each separate row
        var fullCellsCounter = 0;
        for (var column = 0; column < COLUMN; column++) {
            if(gameArray[row][column]==2){
                fullCellsCounter+=1;
            }
        }
        if (fullCellsCounter == COLUMN){
            break;
        }
    }
    if(fullCellsCounter == COLUMN){
        oneRowIsFull = row;
    }
    else{
        oneRowIsFull = -1;
    }
    return oneRowIsFull;
}

function scanGameSurfaceAndRemoveFullRow(){
    console.log(" ---===< scanGameSurfaceEndRemoveFullRow() >===--- ");
    for (var row = oneRowIsFull; row > 0; row--) {
        //we have to reset the counter for each separate row
        for (var column = 0; column < COLUMN; column++) {
            if(gameArray[row][column]==2){
                gameArray[row][column] = gameArray[row-1][column];
            }
        }
    }
    scoreOneFullRow();
}

function scoreOneFullRow(){
    collectedRowsCounter += 1;
}

function refreshGuiRowCounter(){
    document.getElementById("collected_rows").innerHTML = collectedRowsCounter.toString();
}

function dumpGameField(){
    console.log("-------------------------");
    var oneRow;
    for (var row = 0; row <= ROW - 1; row++) {
        oneRow = "";
        for (var column = 0; column <= COLUMN - 1; column++) {
            oneRow += gameArray[row][column] + " ";
        }
        console.log(oneRow);
    }
    console.log("--------------------------");
}


function generateNewFigureAndPlaceItToTheGameField(){
    generateRandomFigure();
    putFigureToGameField();
    refreshGameField();
}


/*
* LetterTableGenerator
* This class should process everything that is related to statistics table
* */

function getName(){
    var result;
    return result = this.letter;
}

function initLetterArray(aRow, aColumn){
    this.row = aRow;
    this.column = aColumn;

    while (this.sampleArray.push([]) < aRow);

    for (var row = 0; row < this.sampleArray.length; row++) {
            for (var col = 0; col < aColumn; col++)
                this.sampleArray[row].push(0);
    }
}

function drawLetterArray(letterTag){
    var myTableDiv = document.getElementById(letterTag);
    var table = document.createElement('TABLE');

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var row=0; row < this.sampleArray.length; row++){
        var tr = document.createElement('TR');
        tableBody.appendChild(tr);

        for (var column=0; column < this.sampleArray[row].length; column++){
            var td = document.createElement('TD');
            td.id = "td_"+row+"_"+column;
            tr.appendChild(td);
            if(this.sampleArray[row][column] == 1){
                td.bgColor = 'red';
            }
        }
    }
    myTableDiv.appendChild(table);


}

function placeFigureToLetterArray(){
    switch (this.getName()) {
        // letter I
        case "I":
            this.sampleArray = [
                [0, 1, 0],
                [0, 1, 0],
                [0, 1, 0]
            ];
            break;
        // letter J
        case "J":
            this.sampleArray = [
                [0, 0, 1],
                [0, 0, 1],
                [0, 1, 1]
            ];
            break;
        // letter L
        case "L":
            this.sampleArray = [
                [1, 0, 0],
                [1, 0, 0],
                [1, 1, 0]
            ];
            break;
        // letter S
        case "S":
            this.sampleArray = [
                [0, 1, 1],
                [1, 1, 0],
                [0, 0, 0]
            ];
            break;
        // letter T
        case "T":
            this.sampleArray = [
                [1, 1, 1],
                [0, 1, 0],
                [0, 0, 0]
            ];
            break;
        // letter Z
        case "Z":
            this.sampleArray = [
                [1, 1, 0],
                [0, 1, 1],
                [0, 0, 0]
            ];
            break;
        // letter O
        case "O":
            this.sampleArray = [
                [1, 1, 0],
                [1, 1, 0],
                [0, 0, 0]
            ];
            break;
    }
}

function LetterTableGenerator(letter) {
    this.letter = letter;
    this.row = 0;
    this.column = 0;
    this.getName = getName;
    this.sampleArray = [];
    this.initLetterArray = initLetterArray;
    this.drawLetterArray = drawLetterArray;
    this.placeFigureToLetterArray = placeFigureToLetterArray;
}

function incLetterCounterAndUpdateGUI(aLetter){
    this.letterCounters[aLetter]+=1;
    document.getElementById(aLetter.toString().toLowerCase()+"_cnt").innerHTML = this.letterCounters[aLetter];
    console.log(this.letterCounters[aLetter]);
}

function LetterCounter(){
    //this.aLetter = aLetter;
    this.letterCounters = {'I': 0,
                           'J': 0,
                           'L': 0,
                           'O': 0,
                           'S': 0,
                           'T': 0,
                           'Z': 0
                          };
    this.incLetterCounterAndUpdateGUI = incLetterCounterAndUpdateGUI;
}

function generateStatisticsTable(){
    var tagsArray = ["I",
                     "J",
                     "L",
                     "O",
                     "S",
                     "T",
                     "Z"];
    //var letter;
    var letter;
    for (var letterCnt = 0; letterCnt < tagsArray.length; letterCnt++) {
        letter = new LetterTableGenerator(tagsArray[letterCnt]);
        letter.initLetterArray(3, 3);
        letter.placeFigureToLetterArray();
        letter.drawLetterArray(tagsArray[letterCnt].toLowerCase() + "_div");
    }
}

function startMovement(){
    if(checkIfGameIsOver() == false) {
        clearInterval(intervalID);
        intervalID = setInterval(placeFigureDown, 1000);
    }
    else{
        clearInterval(intervalID);
        document.getElementById("gameIsOver_message").style.display = "block";
    }
}

function startGame(){
    if(checkIfGameIsOver() == false){
        generateNewFigureAndPlaceItToTheGameField();
        startMovement();
    }
    else{
        gameIsOver = false;
        document.getElementById("gameIsOver_message").style.display = "none";
        //we need to clear our game field before pace new figure in it

        for (var row = 0; row < ROW; row++) {
            for (var column = 0; column < COLUMN; column++) {
                gameArray[row][column] = 0;
            }
        }
        generateNewFigureAndPlaceItToTheGameField();
        refreshGameField();
        startMovement();
    }
}

function dropFigureDown(){
    clearInterval(intervalID);
    intervalID = setInterval(placeFigureDown, 100);
}

function pauseGameContinueGame(){
    if (gameIsPaused == false){
        gameIsPaused = true;
        document.getElementById("pause_button").innerHTML = "continue game";
        document.getElementById("pause").style.display = "block";
    }
    else{
        gameIsPaused = false;
        document.getElementById("pause_button").innerHTML = "pause game";
        document.getElementById("pause").style.display = "none";
    }

}

function checkIfGameIsOver(){
    for (var column = 0; column < COLUMN; column++) {
        if(gameArray[3][column] == 2){
            gameIsOver = true;
        }
    }
    return gameIsOver;
}