package com.bridgelabz.objectOriented;

public interface AddressBookInterface {

	String getAddressBookName();
	
	void setAddressBookName(String addressBookName);
	
	boolean addingContact(Contact contact);
	
	boolean updatingContact(Contact oldContact, Contact newContact);
	
	String searchContact(Contact contact);
	
	Contact searchContact(String firstName);
	
	boolean deletingContact(Contact contact);
	
	void printingContactDetails();
	
	void printFullName();

	String writeDataToJson();
	
}
