/**
 * Created by oleksiy.konkin on 5/29/2014.
 */

var currObject = new TetrisObject();

function TetrisObject(current_tag){
    this.current_tag = current_tag;
    this.previous_tag = "";
    function moveObject(){
        ;
    }
};

//var tetrisObject =

function generateTable(){
    var myTableDiv = document.getElementById("table");
    var table = document.createElement('TABLE');

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var row=0; row<20; row++){
        var tr = document.createElement('TR');
        tableBody.appendChild(tr);

        for (var column=0; column<10; column++){
            var td = document.createElement('TD');
            td.id = "td_"+row+"_"+column;
            //td.appendChild(document.createTextNode(row + "," + column));
            tr.appendChild(td);
        }
    }
    myTableDiv.appendChild(table);
    detectTableCoordinates();
    <!-- this function starts the game with the very first figure -->
    //startMovement();
}


//this function draws the test cell
function generateFiguresField(){
    var myTableDiv = document.getElementById("figure");
    var table = document.createElement('TABLE');

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var row=0; row<4; row++){
        var tr = document.createElement('TR');
        tableBody.appendChild(tr);

        for (var column=0; column<4; column++){
            var td = document.createElement('TD');
            td.id = "td_"+row+"_"+column;
            //td.appendChild(document.createTextNode(row + "," + column));
            tr.appendChild(td);
        }
    }
    myTableDiv.appendChild(table);
    detectTableCoordinates();
    //startMovement();
}


function detectTableCoordinates(){
    var tbl = document.getElementsByTagName("table")[0];
    var cls = tbl.getElementsByTagName("td");

    function alertRowCell(e){
        var cell = e.target || window.event.srcElement;
        document.getElementById("row").innerHTML = cell.parentNode.rowIndex;
        document.getElementById("column").innerHTML = cell.cellIndex;
        document.getElementById("td_tag").innerHTML = this.id;
    }

    for ( var i = 0; i < cls.length; i++ ) {
        if ( cls[i].addEventListener ) {
            cls[i].addEventListener("click", alertRowCell, false);
        } else if ( cls[i].attachEvent ) {
            cls[i].attachEvent("onclick", alertRowCell);
        }
    }
}

function leftArrowPressed() {

    var aTag = currObject.current_tag;
    var aRow = parseInt(aTag.split("_")[1]);
    var aColumn = parseInt(aTag.split("_")[2]);

    if (aColumn > 0) {
        aColumn -= 1;
        var newTag = "td_" + aRow + "_" + aColumn;

        currObject.previous_tag = aTag;
        currObject.current_tag = newTag;
        var previousObject = document.getElementById(aTag);
        previousObject.bgColor = "white";
        var newObject = document.getElementById(newTag);
        newObject.bgColor = "red";
    }
}

function rightArrowPressed() {
    var aTag = currObject.current_tag;
    var aRow = parseInt(aTag.split("_")[1]);
    var aColumn = parseInt(aTag.split("_")[2]);

    if (aColumn < 9) {
        aColumn += 1;
        var newTag = "td_" + aRow + "_" + aColumn;

        currObject.previous_tag = aTag;
        currObject.current_tag = newTag;
        var previousObject = document.getElementById(aTag);
        previousObject.bgColor = "white";
        var newObject = document.getElementById(newTag);
        newObject.bgColor = "red";
    }
}

document.onkeydown = function(evt) {
    evt = evt || window.event;
    switch (evt.keyCode) {
        case 37:
            leftArrowPressed();
            break;
        case 39:
            rightArrowPressed();
            break;
    }
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
    //return 5;
}

function generateObject(){
    var tag_name = "td_0"+"_"+getRandomInt(0,9);
    var tmpObject = document.getElementById(tag_name);
    tmpObject.bgColor = "red";

    currObject.current_tag = tag_name;
}

var intervalID;
var aRow;


function startMovement(){
    generateObject();
    intervalID = setInterval(testMovement, 1000);
}

function testMovement(){
    //for (var row = 1; row <20; row++ ) {
        var aTag = currObject.current_tag;
        aRow = parseInt(aTag.split("_")[1]);
        if(aRow < 19) {
            var aColumn = parseInt(aTag.split("_")[2]);
            var tmpObject = document.getElementById(aTag);
            //tmpObject.bgColor = 'white';
            aRow += 1;
            var newTag = "td_" + aRow + "_" + aColumn;
            //console.log(newTag);

            var nextObject = document.getElementById(newTag);

            if (nextObject.bgColor == "red") {
                console.log("bgColor " + nextObject.bgColor);
                clearInterval(intervalID);

                //generate and start new object
                startMovement();
            }
            else {
                currObject.previous_tag = aTag;
                currObject.current_tag = newTag;
                var tmpObject1 = document.getElementById(newTag);
                tmpObject.bgColor = 'white';
                tmpObject1.bgColor = "red";
                console.log(aRow);
            }
        }
        else{
            clearInterval(intervalID);
            startMovement();
        }
    //}
}

/*
Вот алгоритм поворота матрицы на 90 градусов по часовой стрелке. а-исходная матрица, b -"повернутая".
    Код:


for i:=1 to 4 do
    for j:=1 to 4 do
    b[i,j]:=a[n-j+1,i];
*/

var GameField = function (aRow, aColumn){
    this.row = aRow;
    this.column = aColumn;
    var gameArray = [];
    while(gameArray.push([]) < aRow);
    for (var row=0; row < gameArray.length; row++){
        for (var col=0; col < gameArray.length; col++)
            gameArray[row].push(0);
    }
    console.log(gameArray);
}

GameField.prototype.getRowCount = function(){ return this.row; };
GameField.prototype.getColumnCount = function(){ return this.column; };

var RandomFigure = function (){
    this.position;
    this.letter = "";
    this.figureArray = [];
    this.x=0
    this.y=0

    function getRandomInt(min, max) {
        //return Math.floor(Math.random() * (max - min + 1)) + min;
        // return I
        return 1;
    }

    function defineFigureType(aNum){
        switch (aNum) {
            // letter I
            case 1:
                this.figureArray = [[0, 1, 0, 0],
                                    [0, 1, 0, 0],
                                    [0, 1, 0, 0],
                                    [0, 1, 0, 0]];
                this.letter = "I";
                this.position = 1;
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

    function rotateFigure() {
        switch (this.letter) {
            case "I":
                if (this.position == 1) {
                    this.figureArray = [
                        [0, 0, 0, 0],
                        [1, 1, 1, 1],
                        [0, 0, 0, 0],
                        [0, 0, 0, 0]
                    ];
                }
                else if (this.position == 2) {
                    this.figureArray = [
                        [0, 0, 1, 0],
                        [0, 0, 1, 0],
                        [0, 0, 1, 0],
                        [0, 0, 1, 0]
                    ];
                }
                else if (this.position == 3) {
                    this.figureArray = [
                        [0, 0, 0, 0],
                        [0, 0, 0, 0],
                        [1, 1, 1, 1],
                        [0, 0, 0, 0]
                    ];
                }
                else if (this.position == 4) {
                    this.figureArray = [
                        [0, 0, 1, 0],
                        [0, 0, 1, 0],
                        [0, 0, 1, 0],
                        [0, 0, 1, 0]
                    ];
                    break;
                }
        }
    }

    this.figure = getRandomInt(1,7);
    defineFigureType(this.figure);
    console.log(this.letter);
    console.log(this.figureArray);
}

/*
var GameController = function(){
    //drawGameField: function (IGameField){
    function drawGameField (IGameField){
        this.myTableDiv = document.getElementById("figure");
        this.table = document.createElement('TABLE');
        this.tableBody = document.createElement('TBODY');
        this.table.appendChild(this.tableBody);
        //for (var row=0; row<4; row++){
        for (var row=0; row< IGameField.getRowCount; row++){
            var tr = document.createElement('TR');
            tableBody.appendChild(tr);
            //for (var column=0; column<4; column++){
            for (var column=0; column< IGameField.getColumnCount; column++){
                var td = document.createElement('TD');
                td.id = "td_"+row+"_"+column;
                tr.appendChild(td);
            }
        }
        //this.myTableDiv.appendChild(this.table);
    }
}

GameController.drawGameField(GameField);
*/


var gameArray = [];
var figureArray = [];
var figureType;
var figurePosition = 1;
var valueX;
var valueY;

function initGameField(aRow, aColumn){
    this.row = aRow;
    this.column = aColumn;
    //var gameArray = [];
    if(gameArray.length == 0) {
        while (gameArray.push([]) < aRow);
        for (var row = 0; row < gameArray.length; row++) {
            for (var col = 0; col < gameArray.length; col++)
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

        for (var column=0; column<gameArray.length; column++){
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
            gameArray[row][column] = figureArray[row][column]
        }
    }
}

function refreshGameField(){
    for (var row = 0; row < gameArray.length; row++) {
        //console.log(figureArray[row]);
        for (var column = 0; column < gameArray.length; column++) {
            //console.log("column "+figureArray[row][column]);
            if (gameArray[row][column] != 0){
                //TODO - copy contents of the figure array to game array?
                //TODO - html grid should be repainted with the cells marked in red if array contains 1
                var tagThatShouldBePainted = "td_" + row + "_" + column;
                var gameCell = document.getElementById(tagThatShouldBePainted);
                gameCell.bgColor = 'red';
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
    initGameField(8,8);
    //console.log("init game array " + gameArray);
    drawGameField();
    generateRandomFigure();
    //console.log("figure array "+ figureArray);
    putFigureToGameField();
    //console.log("game array " + gameArray);
    refreshGameField();

}
