package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Utility;

/**
 * Takes an array checks for prime number and all prime numbers are added to an array and
 * each of the numbers are checked with its next number checked for anagram condition if found anagram
 * then it prints the numbers which are anagram
 *  
 * @author Sunidhi Haldar
 * @created 2019-11-29
 * @version 13.0.1
 */

public class PrimeNumberAnagramInRange {
	
	/**
	 * Takes 1D array as input and checks for anagram conditions if satisfied then
	 * transfer all elements to 2D array and then displays them.
	 * 
	 * @param inputArray as input 1D array
	 */
	
	public static void anagramChecker(int[] inputArray) {
		int[] temporaryArray = new int[inputArray.length];
		for(int k = 0; k < inputArray.length; k++) {
			for(int j = k + 1; j < inputArray.length; j++) {
				if(Utility.isAnagram(inputArray[k], inputArray[j]) && (inputArray[k] != 0 && inputArray[j] != 0)) {
					// transfers all elements to temporary 1D array
					temporaryArray[k] = inputArray[k];
				}
			}
		}
		
		// prints 2D array
		int x = 0;
		int[][] twoDArray = new int[10][100];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 100; j++) {
				twoDArray[i][j] = temporaryArray[x];
				x++;
				if(twoDArray[i][j] != 0)
					System.out.print(twoDArray[i][j] +"\t");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int array[] = new int[1000];
		int number = 0;
		// logic to check prime numbers
		for(int i = 0; i < array.length; i++) {
			if(Utility.isPrime(number))
				array[i] = number;
			number++;
		}
		System.out.println("Numbers that are prime and anagram:");
		anagramChecker(array);

	}

}
