package com.bridgelabz.algorithm;

import com.bridgelabz.util.Array;
import com.bridgelabz.util.Sorting;
import com.bridgelabz.util.Utility;

/**
 * A program to read in integers and sort them in order using Insertion Sort
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class InsertionSort {
	
	/**
	 * @param length stores the number of elements in the array
	 * @param array stores the array elements
	 */

	public static void main(String[] args) {
		String[] array = Utility.readFile("C:\\Users\\SONY\\Desktop\\hello.txt").split(",");
		String[] array1 = Sorting.insertionSort(array);
		Array.print1DArray(array);
		System.out.println("Insertion Sort");
		Array.print1DArray(array1);
		}
}