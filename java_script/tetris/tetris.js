/**
 * Created by oleksiy.konkin on 7/9/2014.
 */
var gameArray = [];
var figureArray = [];
var figureType;
var figurePosition = 1;
var valueX;
var valueY;
var ROW=8;
var COLUMN=12;
var borderIsHitted=false;
var movementLeftIsAllowed=true;
var movementRightIsAllowed=true;
var movementDownIsAllowed=true;
var nextRowIsEmpty=true;

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

    //TODO uncomment random generation when issue with Z letter is solved
    //var aNum = getRandomInt(1,7);
    var aNum = 5;

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
    console.log("testFigureGeneration");
    console.log("----- initial coordinates -----");
    console.log("valueX "+valueX);
    console.log("valueY "+valueY);
    console.log("-------------------------------");
}

function moveFigureRight(){
    console.log("moveFigureRight");
    console.log("-------------------------");
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
    console.log("valueX "+valueX);
    console.log("valueY "+valueY);
}

function moveFigureLeft(){
    console.log("moveFigureLeft");
    console.log("-------------------------");

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
    console.log("valueX "+valueX);
    console.log("valueY "+valueY);
}

function detectIfRotationIsAllowed(){
    console.log("detectIfRotationIsAllowed");
    console.log("-------------------------");
    //console.log("valueX > COLUMN-1-(figureArray.length-1)"+(valueX > COLUMN-1-(figureArray.length-1)));
    //console.log("valueY > ROW-1-(figureArray.length-1)"+(valueY > ROW-1-(figureArray.length-1)));
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
    //console.log(gameArray[column]);
}

function detectIfMovementRightIsAllowed(){
    for (var row = 0; row < figureArray.length; row++) {
        //console.log("detectIfMovementRightIsAllowed row + valueY"+ (row + valueY));
        //console.log("detectIfMovementRightIsAllowed (COLUMN-1)" + (COLUMN-1));
        if(gameArray[row + valueY][COLUMN-1] == 1){
            movementRightIsAllowed = false;
            console.log("movement is not allowed");
            break;
        }
        else{
            movementRightIsAllowed = true;
        }
    }
    //console.log(gameArray[column]);
}

function placeFigureDown(){
    detectIfMovementDownIsAllowed();
    detectIfRotationIsAllowed();
    console.log("placeFigureDown()");
    console.log("-------------------------");
    if(movementDownIsAllowed){

        valueY += 1;
        for (var row = 0; row < figureArray.length; row++) {
            for (var column = 0; column < figureArray.length; column++) {
                //                if(gameArray[row + valueY][column + valueX]!=2 && figureArray[row][column]==0)
                //we have not touched the bottom

                //gameArray[valueY - 1][column + valueX] = 0;
                if((valueY+figureArray.length)<= ROW) {
                    //this is not the bottom of the page so we don't need any extra conditions
                    gameArray[valueY - 1][column + valueX] = 0;
                    gameArray[row + valueY][column + valueX] = figureArray[row][column];
                }
                if((valueY+figureArray.length) > ROW) {
                    gameArray[valueY - 1][column + valueX] = 0;
                    //attempt to skip copying empty value to 2
                    if(figureArray[row][column]==1) {
                        gameArray[row + valueY][column + valueX] = figureArray[row][column];
                    }
                }
                //we have touched the bottom

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
        if((valueY+figureArray.length)>=ROW ){
            console.log("valueY+figureArray.length)>=ROW");
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
                    // we have touched the bottom with the side that is filled with 1, we have to overwrite it with 2
                    console.log("562: if (figureArray[row][column] == 0): movement down is not allowed");
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
            //break;
        }


    if((valueY+figureArray.length)< ROW ){
        console.log("valueY+figureArray.length)<ROW");
        console.log("------------------------------");
        console.log("we have not touched the bottom of the game field");
        console.log("valueX "+valueX);
        console.log("valueY "+valueY);
        //check if the next row is occupied with the figure
        nextRowIsEmpty=true;
        for (var row = figureArray.length; row > 0; row--) {
            for (var column = 0; column < figureArray.length; column++) {
                if(gameArray[valueY + row][column + valueX] == 2){
                    //mark this element as the placed on the flor
                    console.log("inetrnal cycle "+gameArray[valueY + row][column + valueX]);
                    //console.log("");
                    nextRowIsEmpty = false;
                }
            }
            break;
        }

        if(nextRowIsEmpty == false){
            console.log("---===< we have not touched the border, next row is not empty - let's check if we can move >===---");
            //we have to check if the meaning values in the figure don't collide with the bottom,
            // if we collide - don't move, if no we can move, but we should not overwrite the bottom values
            for (var row = figureArray.length-1; row > 0; row--) {
                for (var column = 0; column < figureArray.length; column++) {
                    //valueY + row +1 - I want to check the row which is under the very first row of my figure
                    if((gameArray[valueY + row +1][column + valueX] == 2 && figureArray[row][column]==0) ||
                       (gameArray[valueY + row +1][column + valueX] == 0 && figureArray[row][column]==1) ||
                       (gameArray[valueY + row +1][column + valueX] == 0 && figureArray[row][column]==0) ||
                        //this check is strange because it is related to test inside figure's body, maybe this should be improved
                        (gameArray[valueY + row +1][column + valueX] == 1 && figureArray[row][column]==1)){
                        //let's try to detect if we can move down
                        //gameArray[valueY + row][column + valueX] = 2;
                        console.log("movement down is allowed we should not collide with the bottom elements");
                        //console.log("gameArray[valueY + row][column + valueX]"+gameArray[valueY + row][column + valueX]);
                        movementDownIsAllowed = true;
                    }
                    else{
                        movementDownIsAllowed = false;
                    }
                }
            }


            if(movementDownIsAllowed == true){
                console.log("let's try to move down on one position");
                valueY += 1;

                for (var row = 0; row < figureArray.length; row++) {
                    for (var column = 0; column < figureArray.length; column++) {
                        gameArray[valueY - 1][column + valueX] = 0;
                        if(gameArray[row + valueY ][column + valueX]==0 || gameArray[row + valueY ][column + valueX]==1) {
                            gameArray[row + valueY][column + valueX] = figureArray[row][column];
                        }
                        else{
                            console.log(gameArray[row + valueY][column + valueX]);
                        }
                }



                /*
                for (var row = figureArray.length-1; row > 0; row--) {
                    for (var column = 0; column < figureArray.length; column++) {
                        //we should not overwrite non empty cells
                        //gameArray[valueY - 1][column + valueX] = 0;
                        //if(gameArray[row + valueY][column + valueX] != 2){

                        //bottom not empty , fiture row is empty, we should not overwrite this value
                        if((gameArray[row + valueY][column + valueX] == 2) && (figureArray[row][column] ==0 )){

                            //gameArray[row + valueY][column + valueX] = figureArray[row][column];
                            console.log("do nothing we should not overwrite 2 with 0");
                        }

                        if((gameArray[row + valueY][column + valueX] == 0) && (figureArray[row][column] ==0 )){

                            //gameArray[row + valueY][column + valueX] = figureArray[row][column];
                            console.log("do nothing we should not overwrite 0 with 0");
                        }

                        if((gameArray[row + valueY][column + valueX] == 0) && (figureArray[row][column] == 1 )){

                            console.log("move value in game array 1 position down and 0->1")
                            gameArray[row + valueY][column + valueX] = figureArray[row][column];

                        }
                        //clear one string above figure
                        gameArray[valueY -1][column + valueX] = 0;



                    }
                 */
                    dumpGameField();
                }
                refreshGameField();
            }



            movementDownIsAllowed = false;
        }
        else{
            movementDownIsAllowed = true;
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