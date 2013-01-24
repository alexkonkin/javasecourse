import java.io.*;
import java.util.*;
import com.globallogic.javase.*;


public class MainApplication{
	public static void main(String[] args) {
	System.out.println("--==< program started >==--");
	
	Scanner in = new Scanner(System.in);
	String inputString = String.valueOf(in.nextLine());
	System.out.println("result line is : " + inputString);
	
	NeighbouringNumbers neighbouringNumbers = new NeighbouringNumbers(inputString);
	neighbouringNumbers.DoCalculation();

	System.out.println("--==< program stopped >==--");
 }
}









