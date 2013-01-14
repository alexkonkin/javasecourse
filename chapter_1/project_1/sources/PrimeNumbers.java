import java.io.*;
import java.util.*;

public class PrimeNumbers{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 
	System.out.println("Prime Numbers calculator is started");
	System.out.println("Please enter the number: ");
	Integer inputNumber = Integer.valueOf(in.nextLine());
	int[] primeNumbers = new int[inputNumber];
	Arrays.fill(primeNumbers,0);
	System.out.println("array : " + Arrays.toString(primeNumbers));
	int primeNumbersCount = 0;
	
	for (int numerator = inputNumber; numerator > 1; numerator--)
	{
		System.out.println("Current number is : " + numerator);
		int numberOfDividers = 0;
		for (int divider = numerator; divider >= 1; divider--)
			if (( numerator % divider ) == 0)
				numberOfDividers+=1;
		if(numberOfDividers<=2)
		{
			System.out.println("Prime number : " + numerator);
			primeNumbers[primeNumbersCount] = numerator;
			primeNumbersCount++;
			
		}
	}
	int[] resultArray = Arrays.copyOf(primeNumbers,primeNumbersCount++);
	Arrays.sort(resultArray);
	System.out.println("array : " + Arrays.toString(resultArray));
    //System.out.println("you entered the value : " + inputNumber);
 }
}









