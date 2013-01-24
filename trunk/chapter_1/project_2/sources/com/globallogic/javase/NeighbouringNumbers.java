package com.globallogic.javase;

import java.io.*;
import java.util.*;

public class NeighbouringNumbers{
		String[] stringArray;
		int[] integerArray;
		
		public NeighbouringNumbers(String inputString){
			stringArray = inputString.replaceAll(" ", ",").split(",");
			integerArray = new int[stringArray.length];
		}

		public void DoCalculation(){
			List<int[]> outputResultsStorage = new ArrayList<int[]>();
			for (int i = 0; i < stringArray.length; i++)
				integerArray[i] = Integer.parseInt(stringArray[i]);
		
			System.out.println("integer array that was initialized by values: " + Arrays.toString(integerArray));
			for (int n = 0; n < integerArray.length; n++){
				System.out.println("current value: " + integerArray[n]);
				Integer distanceCounter = 0;
				for (int m = n+1; m < integerArray.length; m++){
					distanceCounter++;
					System.out.println("current value of m : " + integerArray[m]);
					if( integerArray[m] == (integerArray[n]+1)){
						System.out.println("index of the first element : " + n);
						System.out.println("number of steps : " + distanceCounter );
						System.out.println("one value was found : " + " "+ integerArray[n] +" "+integerArray[m]);
						outputResultsStorage.add(new int[] { n, distanceCounter, integerArray[n], integerArray[m]});
					}
				}
			}
	
			Integer counter = 0;
			Integer indexOfOutputValue = 0;
			Integer numberOfSteps = outputResultsStorage.get(0)[1];
			for (int[] row : outputResultsStorage) {
				if(row[1] < numberOfSteps){
					System.out.println("Row = " + row[1]);
					numberOfSteps = row[1];
					indexOfOutputValue = counter;
				}
				counter++;
			}
			
			System.out.println("index : " + indexOfOutputValue);
			System.out.println("result value is : " + Arrays.toString(outputResultsStorage.get(indexOfOutputValue)));
			System.out.println("index of first element : " + outputResultsStorage.get(indexOfOutputValue)[0]);
			System.out.println("number of steps between elements : " + outputResultsStorage.get(indexOfOutputValue)[1]);
			System.out.println("value of the first element : " + outputResultsStorage.get(indexOfOutputValue)[2]);
			System.out.println("value of the second element : " + outputResultsStorage.get(indexOfOutputValue)[3]);
		}
}