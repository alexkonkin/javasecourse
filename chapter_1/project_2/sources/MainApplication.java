import java.io.*;
import java.util.*;
import com.globallogic.javase.*;


public class MainApplication{
	public static void main(String[] args) {
	System.out.println("--==< program started >==--");
	
	Scanner in = new Scanner(System.in);
	String inputString = String.valueOf(in.nextLine());
	
	NeighbouringNumbers neighbouringNumbers = new NeighbouringNumbers(inputString);
	neighbouringNumbers.doCalculation();

	System.out.println("--==< program stopped >==--");
 }
}









