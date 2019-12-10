package com.bridgelabz.logical;

import com.bridgelabz.util.Utility;
import java.util.Random;

/**
 * A program to print coupon number
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class CouponNumber {

	public static void main(String[] args) {
		System.out.println("Enter the length of coupon");
		int length = Utility.SCANNER.nextInt();
        randomNumberGeneration(length);
		}
	
	/**
	 * @param length is used to store the user input value of the coupon length
	 * randomNumberGeneration() method is used for generating unique coupon number
	 * @param string contains all the elements that a coupon number is made of
	 * @param coupon stores the final result
	 */
	public static void randomNumberGeneration(int length) {
		String string = "0123456789";
		char[] character = string.toCharArray();
		StringBuilder stringbuilder = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < length; i++) {
			char result = character[random.nextInt(character.length)];
			stringbuilder.append(result);
		}
		String coupon = stringbuilder.toString();
		System.out.println("Coupon number --> " + coupon);
	}
}