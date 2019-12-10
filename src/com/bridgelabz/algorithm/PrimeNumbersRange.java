package com.bridgelabz.algorithm;

import com.bridgelabz.util.Utility;

/**
 * A program to find the prime numbers in the range of 1-1000
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class PrimeNumbersRange {

	public static void main(String[] args) {
		System.out.println("Enter the lower limit of the range:");
		int lowerLimit = Utility.intInput();
		System.out.println("Enter the upper limit of the range:");
		int upperLimit = Utility.intInput();
		Utility.SCANNER.close();
		for(int number = lowerLimit; number <= upperLimit; number++) {
			if(Utility.isPrime(number)) {
				System.out.println(number);
			}
		}
	}

}
