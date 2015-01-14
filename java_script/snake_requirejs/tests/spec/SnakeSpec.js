/**
 * Created by oleksiy.konkin on 1/14/2015.
 */
define(
    [
        "Classes/Snake"
    ],
    function( Snake ){

// Describe the test suite for this module.
   describe( "Snake module", function(){
       var aSnake;
       var initialBodyLength = 3;


       beforeEach(function () {
        aSnake = new Snake();
       });

    describe("when Snake is initialized:", function () {
        it("it should have 3 segments in its body", function () {
            expect(aSnake.getBodyLength()).toEqual(initialBodyLength);
        });

    });
   }//describe
   );
   }
);