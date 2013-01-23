import java.io.*;
import java.util.*;
import com.globallogic.javase.*;


public class MainApplication{
	public static void main(String[] args) {
	System.out.println("--==< program started >==--");
	Scanner in = new Scanner(System.in);
	Integer inputNumber = Integer.valueOf(in.nextLine());
	
    PrimeNumbers primeNumbers = new PrimeNumbers(inputNumber);
	primeNumbers.DoCalculation();
	
	System.out.println("--==< program stopped >==--");

//======================
 }
}









