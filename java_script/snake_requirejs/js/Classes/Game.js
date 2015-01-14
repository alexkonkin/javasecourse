/**
 * Created by oleksiy.konkin on 12/30/2014.
 */
define('Classes/Game', ['Classes/GameField', 'Classes/Snake', 'Classes/GameController'], function (GameField, Snake, GameController) {
    var ROWS=10;
    var COLUMNS=10;

    var aGameField = new GameField();
    var aSnake = new Snake();
    var aGameController = new GameController(500, aGameField);

    var Game = function() {};

    Game.prototype.initGame = function (){
        aGameField = new GameField();
        aSnake = new Snake();
        aSnake.setNumberOfLives(3);
        aSnake.setGrowSpeed(2);
        aGameField.initGameField(ROWS,COLUMNS);
        aGameField.drawGameField("game_field");
        aGameField.putSnakeToGameField(aSnake);
        aGameController.putNewMealToGameField(aGameField);
        aGameField.refreshGameField();
        aGameController.updateCounters(aSnake, "lifes_count", "items_count", "body_count");
        this.bindEvents();
        this.bindKeys();
    }

    Game.prototype.bindEvents = function(){
         document.getElementById('start_button').addEventListener('click', function(){
            this.startGame();
         }, false);
        document.getElementById('pause_button').addEventListener('click', function(){
            aGameController.setResetPause('Game is paused','pause game','continue game',aSnake, aGameField);
         }, false);
    }

    Game.prototype.bindKeys = function(){
        document.onkeyup = function(e) {
            switch (e.keyCode) {
                case 37:
                    console.log("rightToLeft");
                    aSnake.setCurrentDirection("rightToLeft");
                    break;
                case 38:
                    aSnake.setCurrentDirection("bottomToTop");
                    break;
                case 39:
                    aSnake.setCurrentDirection("leftToRight");
                    break;
                case 40:
                    aSnake.setCurrentDirection("topToBottom");
                    break;
                case 19:
                    // Pause button is clicked
                    aGameController.setResetPause("Game is paused","pause game","continue game",aSnake, aGameField);
                    break;
            }
        };
    }

    Game.prototype.startGame = function(){
        //aGameField.dumpGameField();

        if(aGameController.gameIsOver == false && aGameController.gameIsFinished == false){
            aGameController.gameIsStarted = false;
            aGameController.startMovement(aSnake, aGameField);
        }
        else if (aGameController.gameIsOver == true || aGameController.gameIsFinished == true){
            document.getElementById("game_message").style.display = "none";
            aGameController.gameIsOver = false;
            aGameController.gameIsFinished = false;
            aGameController.gameIsStarted = false;
            aGameField.clearGameField();
            aSnake = new Snake();
            aSnake.setNumberOfLives(3);
            aSnake.setGrowSpeed(2);
            aGameController.startMovement(aSnake,aGameField);
            aGameController.refreshGameInterface(aSnake);
        }
    }


    return new Game;
});