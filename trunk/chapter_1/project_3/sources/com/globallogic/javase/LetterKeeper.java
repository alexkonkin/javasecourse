package com.globallogic.javase;

public class LetterKeeper {
	public char nameOfLetter;
	public Integer letterCount;
	
	public LetterKeeper(){
		nameOfLetter = ' ';
		letterCount = 0;
	}
	
	public LetterKeeper(char inputChar, Integer inputCount){
		nameOfLetter = inputChar;
		letterCount = inputCount;
	}
}

