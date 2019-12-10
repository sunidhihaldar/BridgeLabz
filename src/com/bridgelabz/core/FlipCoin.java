package com.bridgelabz.core;

import com.bridgelabz.util.Utility;

/**
 * A program to flip a coin and find the percentage of heads and tails
 * @param times is used for the user to input the number of times the coin should be flipped
 * @param result is used to declare the outcome of Math.random() function
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class FlipCoin {

	public static void main(String[] args) {
		System.out.println("Enter the number of times to flip a coin");
		int times = Utility.SCANNER.nextInt();
		int heads = 0;
		int tails = 0;
		for(int i = 0; i <= times; i++) {
			double result = Math.random();		
			if(result < 0.5) {
				tails++;
			}
			else
				heads++;
		}	
		System.out.println("Percentage of heads vs tails=" +(float)(heads/times)*100+ "%");
		System.out.println("Percentage of heads vs tails=" +(float)(tails/times)*100+ "%");

	}
}