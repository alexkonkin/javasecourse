/**
 * Created by oleksiy.konkin on 10/31/2014.
 */

/*
  Useful links

 http://codepen.io/jweden/pen/Irmil

 http://bittersweetryan.github.io/jasmine-presentation/#slide-70



 */

describe("GameField", function() {
    var gameField;
    var aRow = 20;
    var aColumn = 10;
    var aGameFieldTag = "game_field";

    beforeEach(function() {
        gameField = new GameField();
    });

    function setUpHTMLFixture() {
        //jasmine.getFixtures.fixturesPath = "spec/javascripts/fixtures";
        jasmine.getFixtures.fixturesPath = "./";
        loadFixtures('snake.html');

    }

    /*
    it("should be able to play a Song", function() {
        player.play(song);
        expect(player.currentlyPlayingSong).toEqual(song);

        //demonstrates use of custom matcher
        expect(player).toBePlaying(song);
    });
    */

    describe("when GameField is initialized with Columns and Rows", function() {
        beforeEach(function() {
            gameField.initGameField(aRow, aColumn);
        });

        it("should contain the correct number of rows", function() {
            expect(gameField.getNumberOfRows()).toEqual(aRow);
        });

        it("should contain the correct number of columns", function() {
            expect(gameField.getNumberOfColumns()).toEqual(aColumn);
        });

    });

    //TODO I don't understand how to implement this test

    describe("when GameField tries to find the tag to which it should bind itself", function() {
        beforeEach(function() {
            gameField.initGameField(aRow, aColumn);
        });

        it("should find this tag", function() {
            setUpHTMLFixture();
            expect(gameField.getGameFieldTag(aGameFieldTag)).toBeInDOM();
        });
    });




});
