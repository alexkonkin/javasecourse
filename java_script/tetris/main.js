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
            td.appendChild(document.createTextNode(row + "," + column));
            tr.appendChild(td);
        }
    }
    myTableDiv.appendChild(table);
    detectTableCoordinates();
    generateObject();
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
