package com.bridgelabz.algorithm;

import com.bridgelabz.util.Array;
import com.bridgelabz.util.Sorting;

/**
 * A program to implement Bubble Sort
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */
public class BubbleSort {
	
	/**
	 * @param array contains all the array elements
	 */

	public static void main(String[] args) {
		int[] array = {10,30,70,90,100,73,47,45,32,23,10,15};
		Array.print1DArray(array);
		System.out.println("Bubble Sort");
		Sorting.bubbleSort(array);
		Array.print1DArray(array);
	}
	
}