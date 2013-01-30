package com.globallogic.javase;

import java.io.*;
import java.util.*;

public class PrimeNumbers{
		private Integer inputNumber = 0;
		
		public PrimeNumbers(){
			Scanner in = new Scanner(System.in); 
			System.out.println("Prime Numbers calculator is started");
			System.out.println("Please enter the number: ");
			Integer inputNumber = Integer.valueOf(in.nextLine());			
		}
		
		public PrimeNumbers(Integer inpValue){
			inputNumber = inpValue;
		}
		
		public void printNumber(){
			System.out.println("inputNumber is : " + inputNumber.toString());
		}

		public void doCalculation(){
			int[] primeNumbers = new int[inputNumber];
			System.out.println("array : " + Arrays.toString(primeNumbers));
			int primeNumbersCount = 0;
				for (int numerator = inputNumber; numerator > 1; numerator--){
					System.out.println("Current number is : " + numerator);
					int numberOfDividers = 0;
					for (int divider = numerator; divider >= 1; divider--)
					if (( numerator % divider ) == 0)
						numberOfDividers+=1;
					if(numberOfDividers<=2){
						System.out.println("Prime number : " + numerator);
						primeNumbers[primeNumbersCount] = numerator;
						primeNumbersCount++;
					}
				}
			int[] resultArray = Arrays.copyOf(primeNumbers,primeNumbersCount++);
			Arrays.sort(resultArray);
			System.out.println("array : " + Arrays.toString(resultArray));
		}
}