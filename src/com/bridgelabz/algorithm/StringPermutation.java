package com.bridgelabz.algorithm;

import com.bridgelabz.util.Utility;

/**
 * A program to perform permutations on strings
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class StringPermutation {

	public static void main(String[] args) {
		System.out.println("Enter the string");
		String string = Utility.SCANNER.next();
		printPermutations(string, " ");
	}
	
	/** 
	 * @param string stores the user input
	 * printPermuations() method is used to print the different permutations of the string
	 */
	public static void printPermutations(String string, String answer) {
			if(string.length() == 0) {
				System.out.println(answer +" ");
				return;
			}
			for(int i = 0; i < string.length(); i++) {
				char character = string.charAt(i);
				String result = string.substring(0, i) + string.substring(i + 1);
				printPermutations(result, answer + character);
			}
	}
}
