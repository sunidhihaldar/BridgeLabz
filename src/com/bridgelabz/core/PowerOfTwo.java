package com.bridgelabz.core;

import com.bridgelabz.util.Utility;

/**
 * A program to find the values for the power of 2
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println("Enter the power of 2");
		int power = Utility.SCANNER.nextInt();
		double result = Utility.powerOfTwo(power);
		if(power >= 1 && power <= 31) {
			System.out.println("2 ^ " + power + " = " + result);
			if(Utility.isLeapYear((int)result) == true)
				System.out.println(result + " is a leap year");
			else
				System.out.println(result + " is not a leap year");
		}
		else
			System.out.println("Invalid power");
		
	}
}