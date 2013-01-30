package com.globallogic.javase;

import java.io.*;
import java.util.*;

public class Anagram{
	String firstString;
	String secondString;
	
	public Anagram(String inputFirstString,String inputSecondString){
			firstString = inputFirstString.replaceAll(" ", "").toLowerCase();
			secondString = inputSecondString.replaceAll(" ", "").toLowerCase();
	}
	
	public void doCalculation(){
		System.out.println("Input first string : " + firstString);
		System.out.println("Input second string : " + secondString);
			
		if(firstString.length() != secondString.length()){
			System.out.println("The two strings has different size, \nthey did not fit under the anagram condition");
		}else{
			System.out.println("The size of strings is equal, let's chech the set of letters : " + firstString.length());
			char[] charArrFirstString = firstString.toCharArray();
			char[] charArrSecondString = secondString.toCharArray();
			Arrays.sort(charArrFirstString);
			Arrays.sort(charArrSecondString);
			String s1 = new String(charArrFirstString);
			String s2 = new String(charArrSecondString);
			System.out.println("The set of letters related to the first string  : "+s1);
			System.out.println("The set of letters related to the second string : "+s2);
			if(s1.equals(s2))
				System.out.println("Two strings that have been passed are anagrams");
			else
				System.out.println("The two strings that have been passed are not anagrams, \nthey have different set of letters");
			}
	}
}
