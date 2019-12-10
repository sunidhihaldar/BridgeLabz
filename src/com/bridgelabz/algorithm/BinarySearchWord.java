package com.bridgelabz.algorithm;

import java.util.Arrays;

import com.bridgelabz.util.Array;
import com.bridgelabz.util.Searching;
import com.bridgelabz.util.Utility;

/**
 * A program to read in a list of words and apply Binary Search
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class BinarySearchWord {

	public static void main(String[] args) {
		String[] array = Utility.readFile("C:\\Users\\SONY\\Desktop\\hello.txt").split(",");
		Array.print1DArray(array);
		System.out.println("Enter the string you want to search");
		String searching = Utility.SCANNER.nextLine();
		Arrays.sort(array);
		System.out.println("Sorted array:");
		Array.print1DArray(array);
		int position = Searching.linearSearch(array, searching);
		if(position >= 0)
			System.out.println("Found at " + position + " position");
		else
			System.out.println("Not available");
	}
}
