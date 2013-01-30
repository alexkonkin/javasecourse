import java.io.*;
import java.util.*;
import com.globallogic.javase.*;


public class MainApplication{
	public static void main(String[] args) {
	System.out.println("--==< program started >==--\n");
	Scanner in = new Scanner(System.in);
	System.out.println("Input the Date (for example 10 October 2010) : ");
	String inputDate = String.valueOf(in.nextLine());
	
	CalendarSeeker varCalendarSeeker = new CalendarSeeker (inputDate);
	varCalendarSeeker.doCalculation();

	System.out.println("\n--==< program stopped >==--");
 }
}









