package com.bridgelabz.objectOriented;

/**
 * This program has the functionality of contact details like first name, last name, mobile number,
 * address and email id with  getter methods for each and a constructor to initialiize the class
 *  
 * @author Sunidhi Haldar
 * @created 2019-12-02
 * @version 13.0.1
 */

public class Contact {

	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String address;
	private String emailId;
	
	/**
	 * A constructor to initialize the class
	 * @param firstName is String input parameter
	 * @param lastName is String input parameter
	 * @param mobileNumber is long input parameter
	 * @param address is String input parameter
	 * @param emailId is String input parameter
	 */
	
	public Contact(String firstName, String lastName, long mobileNumber,String address, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.emailId = emailId;
	}
	
	/**
	 * getter method for first name
	 * @return String data as first name
	 */

	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * getter method for last name
	 * @return String data
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * getter method for mobile number
	 * @return long data
	 */

	public long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * getter method for address
	 * @return String data
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * getter method for email id
	 * @return String data
	 */

	public String getEmailId() {
		return emailId;
	}

	/**
	 * createContact() method takes first name, last name, mobile number, address, email id
	 * as input parameter and returns the new Class type static object
	 * 
	 * @param firstName as String input parameter
	 * @param lastName as String input parameter
	 * @param mobileNumber as long input parameter
	 * @param address as String input parameter
	 * @param emailId as String input parameter
	 * @return Class type new Contact
	 */
	
	public static Contact createContact(String firstName, String lastName, long mobileNumber,String address, String emailId) {
		return new Contact(firstName, lastName, mobileNumber, address, emailId);
	}
	
	// prints first name and last name together
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
