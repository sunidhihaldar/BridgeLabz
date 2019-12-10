package com.bridgelabz.core;

import com.bridgelabz.util.Utility;

/**
 * A program to print the prime factors
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class PrimeFactor {
    
	// @param number denotes the number uptill which the prime factors have to be declared
	public static void main(String[] args) {
		System.out.println("Enter a number:");
		int number = Utility.SCANNER.nextInt();
		primeFactors(number);
		}
	
	/**
	 * primeFactors() method prints the prime factors uptill number
	 */
	public static void primeFactors(int number) {
		
		// Prints the number of 2s that divides number
		while(number % 2 == 0) {
			System.out.println(2 +" ");
			number = number / 2;
		}
		
		// number has to be odd hence i = 3
		for(int i = 3; i <= Math.sqrt(number); i = i + 2) {
			while(number % i == 0) {
				System.out.println(i +" ");
				number = number / i;
			}
		}
		if(number > 2) {
			System.out.println(number);
		}
	}
}
