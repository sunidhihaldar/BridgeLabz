package com.bridgelabz.objectOriented;

import com.bridgelabz.util.JsonUtil;

import com.bridgelabz.util.Utility;

/**
 * This program is the main implementation of the address book and has functionalities like
 * adding new contact, updating existing contact, deleting old contact.
 *   
 * @author Sunidhi Haldar
 * @created 2019-12-02
 * @version 13.0.1
 */

public class AddressBook {

	static AddressBookOperations myAddressBook = new AddressBookOperations("admin");
	
	/**
	 * Allows user to enter first name, last name, mobile number, address and email id and
	 * create a new contact by using the Contact Class type static method
	 */
	
	public static void addNewContact() {
		System.out.println("Enter first name");
		String firstName = Utility.SCANNER.next();
		System.out.println("Enter last name");
		String lastName = Utility.SCANNER.next();
		System.out.println("Enter phone number");
		long mobileNumber = Utility.longInput();
		System.out.println("Enter address");
		String address = Utility.SCANNER.next();
		System.out.println("Enter email id");
		String emailId = Utility.SCANNER.next();
		
		Contact newContact = Contact.createContact(firstName, lastName, mobileNumber, address, emailId);
	    if(myAddressBook.addNewContact(newContact))
	    	System.out.println("New contact: " + firstName + " added");
	    else
	    	System.out.println("Contact: " + firstName + " already exists");
	}
	
	/**
	 * this method takes first name as the user input and searches for the contact in the contact list
	 * if present it asks the user to fill the new details of the user
	 */
	
	public static void updateContact() {
		System.out.println("Enter existing contact first name");
		String existigContactFirstName = Utility.SCANNER.next();
		Contact existingContactInRecord = myAddressBook.searchContact(existigContactFirstName);
		if(existingContactInRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		String firstName = existingContactInRecord.getFirstName();
		String lastName = existingContactInRecord.getLastName();
		System.out.println("Enter phone number");
		long mobileNumber = Utility.longInput();
		System.out.println("Enter address");
		String address = Utility.SCANNER.next();
		System.out.println("Enter email id");
		String emailId = Utility.SCANNER.next();
		
		Contact newContact = Contact.createContact(firstName, lastName, mobileNumber, address, emailId);
	    if(myAddressBook.updateContact(existingContactInRecord, newContact))
	    	System.out.println("Contact updated");
	    else
	    	System.out.println("Contact updating error");
	}
	
	/**
	 * this method take first name as the user input. If contact not found dispalys a message
	 * if contact is present it deletes the particular contact 
	 */
	
	public static void deleteContact() {
		System.out.println("Enter first name of contact you want to delete");
		String existigContactFirstName = Utility.SCANNER.next();
		Contact existingContactInRecord = myAddressBook.searchContact(existigContactFirstName);
		if(existingContactInRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		
		if(myAddressBook.deleteContact(existingContactInRecord))
	    	System.out.println("Contact deleted");
	    else
	    	System.out.println("Contact error deleting");
	}
	
	/**
	 * This method takes first name as the user input and if the name matches 
	 * all details of the user are displayed
	 */
	
	public static void searchDetailsOfContact() {
		System.out.println("Enter first name of contact you want to search");
		String contactFirstName = Utility.SCANNER.next();
		Contact existingContactInRecord = myAddressBook.searchContact(contactFirstName);
		if(existingContactInRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println("First Name: " + existingContactInRecord.getFirstName() +
				"\nLast Name: " + existingContactInRecord.getLastName() + 
				"\nMobibe Number: " + existingContactInRecord.getMobileNumber() + 
				"\nAddress:" + existingContactInRecord.getAddress() + 
				"\nEmail Id: " + existingContactInRecord.getEmailId());
	}
	
	public static String writeDataToJson() {
		String addressBook = JsonUtil.convertJavaToJson(myAddressBook.addressBook);
		return addressBook;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the name of the address book");
		String addressBookName = Utility.SCANNER.next();
		myAddressBook.setAddressBookName(addressBookName);
		System.out.println("Welcome to the address book " + myAddressBook.getAddressBookName());
		System.out.println("-----------------------------------------------");
		System.out.println("Options:");
		System.out.println("1. Add new contact \n2. Update existing contact \n3. Remove existing contact"
				+ "\n4. Search for a contact \n5. Print all details of the address book "
				+ "\n6. Print contact full names \n7. Quit the application");
	    boolean quit = false;
	    while(!quit) {
	    	System.out.println("Choose an option:");
            int choice = Utility.intInput();
            switch(choice) {
            case 1: 
            	addNewContact();
            	Utility.writeToFile(writeDataToJson(), "C:\\Users\\SONY\\eclipse-workspace\\Fellowships\\src\\com\\bridgelabz\\objectOriented\\AddressBook.json");
                break;
            case 2: 
            	updateContact();
            	Utility.writeToFile(writeDataToJson(), "C:\\Users\\SONY\\eclipse-workspace\\Fellowships\\src\\com\\bridgelabz\\objectOriented\\AddressBook.json");
                break;
            case 3:
            	deleteContact();
            	Utility.writeToFile(writeDataToJson(), "C:\\Users\\SONY\\eclipse-workspace\\Fellowships\\src\\com\\bridgelabz\\objectOriented\\AddressBook.json");
            	break;
            case 4:
            	searchDetailsOfContact();	
            	break;
            case 5:
            	myAddressBook.printDetailsOFContact();
            	break;
            case 6:
            	myAddressBook.printFullName();
            	break;
            case 7:
            	quit = true;
            	System.out.println("Thank You");
            	break;
            default:
            	System.out.println("Invalid option");
            	break;
            }
	    }
	}	
	
}
