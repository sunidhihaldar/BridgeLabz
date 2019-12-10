package com.bridgelabz.core;

import com.bridgelabz.util.Utility;

/**
 * A program to print the nth harmonic number
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class Harmonic {
	public static void main(String[] args) {
         System.out.println("Enter nth term");
         int number=Utility.SCANNER.nextInt();
         if(number != 0) {
         double value = printHarmonic(number);
         System.out.println("Harmonic Value : " + value);
         }
         else {
        	 System.out.println("Not valid");
         }
	}
	
	/**
	 * @param number is taken as the nth term for harmonic number
	 * @param harmonic is used to store the harmonic values
	 * @return
	 */
	public static double printHarmonic(int number) {
		double harmonic = 1;
		for(int i=2; i <= number; i++) {
			harmonic += (double) 1 / i;
		}		
		return harmonic;	
	}

}
