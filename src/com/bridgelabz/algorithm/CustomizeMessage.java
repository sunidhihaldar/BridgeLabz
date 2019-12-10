package com.bridgelabz.algorithm;

import com.bridgelabz.util.Utility;

/**
 * A program to customize a specific message
 * @author Sunidhi Haldar
 * @created 20.11.19
 * @version 13.0.1
 */

public class CustomizeMessage {
    
	// string stores the specific message in it
	public static void main(String[] args) {
	//	String string = "Hello <<name>>. We have your <<full name>> in our system. \nYour contact number is 91-xxxxxxxxxx. \nPlease, let us know in case of any clarification. \nThank you BridgeLabz 01/01/2016";
	UserDetails userDetails = new UserDetails();
	System.out.println("Enter your first name");
	userDetails.setFirstName(Utility.SCANNER.nextLine());
	System.out.println("Enter your last name");
	userDetails.setLastName(Utility.SCANNER.nextLine());
	System.out.println("Enter mobile number");
	userDetails.setMobileNumber(Utility.SCANNER.nextLine());
	System.out.println("Enter date");
	userDetails.setDate(Utility.getFormatedDate(Utility.printDate(Utility.SCANNER.nextLine())));
	
	
	}
	
}