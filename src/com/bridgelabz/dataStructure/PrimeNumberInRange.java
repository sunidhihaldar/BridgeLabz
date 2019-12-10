package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Array;
import com.bridgelabz.util.Utility;

/**
 * This program checks the data if it is prime or not . If prime the add the data in a group
 * of 100 elements till it reaches user defined range data. If the number is prime then prints
 * the data in 2D array
 *  
 * @author Sunidhi Haldar
 * created: 2019-11-28    modified:
 */

public class PrimeNumberInRange {
	static int[][] array = new int[10][100];
	
	/**
	 * If prime then adds the data ina group of 100 elements till it reaches user defined
	 * range data
	 *   
	 * @param start as integer value
	 * @param end as integer value
	 * @return integer array of numbers
	 */
	
	public static int[][] findPrimeNumber(int start, int end) {
		while(start <= end) {
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i].length; j++) {
					if(Utility.isPrime(start))
						array[i][j] = start;
					start++;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int start = 1;
		int end = 1000;
		findPrimeNumber(start,end);
		Array.print2DArray(array);
	}
}
