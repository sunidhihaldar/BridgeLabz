package com.bridgelabz.core;

import com.bridgelabz.util.Utility;

/**
 * A program to check if a 4-digit number is leap year or not
 * @param year takes the user input for the year the user wants to check for
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class LeapYear {

	public static void main(String[] args) {
		System.out.println("Enter year");
		int year=Utility.SCANNER.nextInt();
		if(Utility.isLeapYear(year) == true) 
			System.out.println(year + " is a leap year");
		else
			System.out.println(year + " is not a leap year");

	}
}