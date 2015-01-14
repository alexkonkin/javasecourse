/**
 * Created by oleksiy.konkin on 12/26/2014.
 */
define('Classes/Snake',['Classes/GameField'], function (GameField) {

function Snake(){

    this.movementDirection = {"leftToRight":"leftToRight", "bottomToTop":"bottomToTop", "topToBottom":"topToBottom", "rightToLeft":"rightToLeft"};
    this.snakeBody = [];
    this.directionOfMovement = this.movementDirection.leftToRight;
    this.movementIsAllowed = true;
    this.numberOfLives = 0;
    this.numberOfEatenItems = 0;
    this.growSpeed = 0;


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
    /*
    Snake.movementDirection = {"leftToRight":"leftToRight", "bottomToTop":"bottomToTop", "topToBottom":"topToBottom", "rightToLeft":"rightToLeft"};
    Snake.snakeBody = [];
    Snake.directionOfMovement = this.movementDirection.leftToRight;
    Snake.movementIsAllowed = true;
    Snake.numberOfLives = 0;
    Snake.numberOfEatenItems = 0;
    Snake.growSpeed = 0;
    */

/*
Snake.create = function(){

    this.movementDirection = {"leftToRight":"leftToRight", "bottomToTop":"bottomToTop", "topToBottom":"topToBottom", "rightToLeft":"rightToLeft"};
    this.snakeBody = [];
    this.directionOfMovement = this.movementDirection.leftToRight;
    this.movementIsAllowed = true;
    this.numberOfLives = 0;
    this.numberOfEatenItems = 0;
    this.growSpeed = 0;


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
    return result;

}
*/

Snake.prototype = {

    /*constructor: Snake,*/

getMovementIsAllowed : function(){
    return this.movementIsAllowed;
},

setMovementIsAllowed : function(aValue){
    return this.movementIsAllowed = aValue;
},


getCurrentDirection : function(){
    return this.directionOfMovement;
},

getNumberOfLives : function(){
    return this.numberOfLives;
},

setNumberOfLives : function(aNumberOfLives){
    this.numberOfLives = aNumberOfLives;
},

takeOneLife : function(){
    this.numberOfLives -= 1;
},

eatOneItem : function(){
    this.numberOfEatenItems += 1;
},

getNumberOfEatenItems : function(){
    return this.numberOfEatenItems;
},

setCurrentDirection : function(aDirection){
    switch (aDirection) {
        case "leftToRight":
            if(this.directionOfMovement == this.movementDirection.rightToLeft){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                this.setMovementIsAllowed(true);
                console.log(this.directionOfMovement);
            }
            break;
        case "rightToLeft":
            if(this.directionOfMovement == this.movementDirection.leftToRight){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
                this.setMovementIsAllowed(true);
            }
            break;
        case "bottomToTop":
            if(this.directionOfMovement == this.movementDirection.topToBottom){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
                this.setMovementIsAllowed(true);
            }
            break;
        case "topToBottom":
            if(this.directionOfMovement == this.movementDirection.bottomToTop){
                console.log("such movement is prohibited");
                this.setMovementIsAllowed(false);
            }
            else {
                this.directionOfMovement = aDirection;
                console.log(this.directionOfMovement);
                this.setMovementIsAllowed(true);
            }
            break;
    }
},


getBodyLength : function(){
    return this.snakeBody.length;
},

doOneStepUpward : function(){
    console.log("Snake.prototype.doOneStepDown");
    console.log(this.getCurrentDirection());
    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][0] -= 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
},

doOneStepLeft : function(){
    console.log("Snake.prototype.doOneStepLeft");
    console.log(this.getCurrentDirection());


    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;
    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][1] -= 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
},

doOneStepRight : function(){
    console.log("Snake.prototype.doOneStepRight");
    console.log(this.getCurrentDirection());
    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][1] += 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
},

doOneStepDown : function(){
    console.log("Snake.prototype.doOneStepDown");
    console.log(this.getCurrentDirection());


    //we should save the initial position
    var currentValueHorizontal = 0;
    var currentValueVertical = 0;
    var tmpHorizontal = 0;
    var tmpVertical = 0;

    if(this.getMovementIsAllowed()) {
        for (var body = 0; body < this.getBodyLength(); body++) {
            if (body == 0) {
                tmpHorizontal = this.snakeBody[body][0];
                tmpVertical = this.snakeBody[body][1];
                this.snakeBody[body][0] += 1;
            }
            else {
                currentValueHorizontal = this.snakeBody[body][0];
                currentValueVertical = this.snakeBody[body][1];

                this.snakeBody[body][0] = tmpHorizontal;
                this.snakeBody[body][1] = tmpVertical;

                tmpHorizontal = currentValueHorizontal;
                tmpVertical = currentValueVertical;
            }
        }
    }
},

getCurrentPosition : function(){
    return this.snakeBody[0];
},

increaseBodyLength : function(){
    var tail = this.snakeBody.slice(-1)[0];
    var firstSegment = this.snakeBody.slice(-2)[0];
    this.snakeBody.push([]);

    if(tail[0] == firstSegment[0]){
        // horizontal segment stable vertical should be corrected
        this.snakeBody[this.snakeBody.length-1][0] = tail[0];
        if(tail[1] < firstSegment[1]){
            this.snakeBody[this.snakeBody.length-1][1] = tail[1]-1;
        }
        else{
            this.snakeBody[this.snakeBody.length-1][1] = tail[1]+1;
        }
    }else{
        // vertical segment is stable horizontal should be corrected
        this.snakeBody[this.snakeBody.length-1][1] = tail[1];
        if(tail[0] < firstSegment[0]){
            this.snakeBody[this.snakeBody.length-1][0] = tail[0]-1;
        }
        else{
            this.snakeBody[this.snakeBody.length-1][0] = tail[0]+1;
        }
    }
},

ifMealIsPresentEatIt : function(GameField){
    var aSnakeHead = this.getCurrentPosition();
    switch(this.getCurrentDirection()){
        case "leftToRight":
            if(GameField.getValue(aSnakeHead[0],(aSnakeHead[1]+1)) == 2){
                GameField.setValue(aSnakeHead[0],(aSnakeHead[1]+1),0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
        case "rightToLeft":
            if(GameField.getValue(aSnakeHead[0],(aSnakeHead[1]-1)) == 2){
                GameField.setValue(aSnakeHead[0],(aSnakeHead[1]-1),0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
        case "bottomToTop":
            if(GameField.getValue((aSnakeHead[0]-1),aSnakeHead[1]) == 2){
                GameField.setValue((aSnakeHead[0]-1),aSnakeHead[1],0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
        case "topToBottom":
            if(GameField.getValue((aSnakeHead[0]+1),aSnakeHead[1]) == 2){
                GameField.setValue((aSnakeHead[0]+1),aSnakeHead[1],0);
                this.eatOneItem();
                return true;
            }
            else{
                return false;
            }
            break;
    }
},

setGrowSpeed : function(aGrowSpeed){
    this.growSpeed = aGrowSpeed;
},

getGrowSpeed : function(){
    return this.growSpeed;
}};

    return Snake;
});