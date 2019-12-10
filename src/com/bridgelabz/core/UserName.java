package com.bridgelabz.core;

import com.bridgelabz.util.Utility;

/**
 * A program to take username as input
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class UserName {

	public static void main(String[] args) {
	    printUsername();
	}
	
	/**
	 * Prints the string with username
	 * @param length is used for the user to input the length of the string 
	 */
	
	public static void printUsername() {
		System.out.println("Enter the username");
		String username = Utility.SCANNER.nextLine();
		int length = username.length();
		if(length > 3) {
			System.out.println("Hello "+username+", How are you?");
		}
		else {
			System.out.println("Invalid username");
		}
	}

}
