import java.io.*;
import java.util.*;
import com.globallogic.javase.*;


public class MainApplication{
	public static void main(String[] args) {
	System.out.println("--==< program started >==--");
	
	Scanner in = new Scanner(System.in);
	System.out.println("Input first string : ");
	String firstString = String.valueOf(in.nextLine());
	System.out.println("Input second string : ");
	String secondString = String.valueOf(in.nextLine());
	
	Anagram varAnagram = new Anagram (firstString,secondString);
	varAnagram.DoCalculation();
	//firstString = firstString.replaceAll(" ", "").toLowerCase();
	//secondString = secondString.replaceAll(" ", "").toLowerCase();
	//System.out.println("Input first string : " + firstString);
	//System.out.println("Input second string : " + secondString);
		
	//LetterKeeper lc = new LetterKeeper('a',1);
    //LetterKeeper[] letterKeeper = new LetterKeeper[4]; 
	
	//Anagram varAnagram = new Anagram(firstString, secondString);
	//varAnagram.DoCalculation();

	System.out.println("--==< program stopped >==--");
 }
}









