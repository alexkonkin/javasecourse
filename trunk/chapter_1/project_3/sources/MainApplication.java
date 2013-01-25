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

	System.out.println("--==< program stopped >==--");
 }
}









