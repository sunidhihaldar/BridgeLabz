package com.bridgelabz.objectOriented.AddressBookOps.Service;

import com.bridgelabz.objectOriented.AddressBookOps.Model.Contact;

/**
 * This interface has the following methods 
 * @author Sunidhi Haldar
 * @created 2019-12-12
 * @version 13.0.1
 */

public interface AddressBookInterface {

	//to get address book name
	String getAddressBookName();
	
	//to assign address book name
	void setAddressBookName(String addressBookName);
	
	// to add new contact
	boolean addingContact(Contact contact);
	
	//to update new contact
	boolean updatingContact(Contact oldContact, Contact newContact);
	
	//to search for a contact
	String searchContact(Contact contact);
	
	//to search for the first name from the contact list
	Contact searchContact(String firstName);
	
	//to delete a contact
	boolean deletingContact(Contact contact);
	
	//to print the contact details
	void printingContactDetails();
	
	//to print the full name only
	void printFullName();

	//to write the data to json file
	String writeDataToJson();
	
}
