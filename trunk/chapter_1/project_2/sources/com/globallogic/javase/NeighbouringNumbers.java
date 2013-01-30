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

		public void doCalculation(){
			List<int[]> outputResultsStorage = new ArrayList<int[]>();
			for (int i = 0; i < stringArray.length; i++)
				integerArray[i] = Integer.parseInt(stringArray[i]);

			System.out.println("The class received array : " + Arrays.toString(integerArray));	
				
			for (int n = 0; n < integerArray.length; n++){
				Integer distanceCounter = 0;
				for (int m = n+1; m < integerArray.length; m++){
					distanceCounter++;
					if( integerArray[m] == (integerArray[n]+1)){
					/*
						System.out.println("index of the first element : " + n);
						System.out.println("number of steps : " + distanceCounter );
						System.out.println("one value was found : " + " "+ integerArray[n] +" "+integerArray[m]);
					*/
						outputResultsStorage.add(new int[] { n, distanceCounter, integerArray[n], integerArray[m]});
					}
				}
			}
	
			Integer counter = 0;
			Integer indexOfOutputValue = 0;
			Integer numberOfSteps = outputResultsStorage.get(0)[1];
			for (int[] row : outputResultsStorage) {
				if(row[1] < numberOfSteps){
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