package com.bridgelabz.objectOriented.AddressBookOps.ServiceImplementation;

import java.util.ArrayList;

import com.bridgelabz.objectOriented.AddressBookOps.Model.Contact;
import com.bridgelabz.objectOriented.AddressBookOps.Service.IAddressBook;
import com.bridgelabz.util.JsonUtil;

/**
 * This class has an array list which stores the data of the address book.
 * Includes functionalities like find the contact from the list on basis of the
 * first name, to add new contact, update an existing contact, search for a
 * contact based on first name, printing details of contact list.
 * 
 * @author Sunidhi Haldar
 * @created 2019-12-02
 * @version 13.0.1
 */

public class AddressBookOperations implements IAddressBook {

	String addressBookName;
	ArrayList<Contact> addressBookList;

	/**
	 * constructor to initialize array list and assign name of address book
	 * 
	 * @param addressBookName as input parameter
	 */

	public AddressBookOperations(String addressBookName) {
		this.addressBookName = addressBookName;
		this.addressBookList = new ArrayList<Contact>();
	}

	/**
	 * getter method to return name of address book
	 * 
	 * @return name of address book
	 */

	@Override
	public String getAddressBookName() {
		return addressBookName;
	}

	/**
	 * setter method allows the user to set the name of the address book
	 * 
	 * @param addressBookName as String data
	 */

	@Override
	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	/**
	 * This method takes first name as input parameter and checks if it matches with
	 * contacts present in the list. If it matches, returns the index value of the
	 * contact which is greater than or equal to zero
	 * 
	 * @param firstName as input parameter to check
	 * @return integer value
	 */

	public int findContact(String firstName) {
		for (int i = 0; i < addressBookList.size(); i++) {
			Contact fetchedContact = this.addressBookList.get(i);
			if (fetchedContact.getFirstName().equals(firstName))
				return i;
		}
		return -1;
	}

	/**
	 * This method takes contact as parameter and returns the index value of the
	 * entry contact. If exist in the list value greater than equal to zero else
	 * returns negative value
	 * 
	 * @param contact as Class type data
	 * @return integer value
	 */

	public int findContact(Contact contact) {
		return this.addressBookList.indexOf(contact);
	}

	/**
	 * this method takes class type input parameter and checks if it exists if
	 * exists then add new contact to the list
	 * 
	 * @param contact class type as input parameter
	 * @return boolean data
	 */

	@Override
	public boolean addingContact(Contact contact) {
		if (findContact(contact.getFirstName()) >= 0) {
			System.out.println("Contact already exists");
			return false;
		} else {
			addressBookList.add(contact);
			return true;
		}
	}

	/**
	 * This method takes old contact nad new contact as Class type input parameter
	 * and checks for position. If position found the it replaces new contact
	 * details in the place of old contact.
	 * 
	 * @param oldContact as Class type input parameter
	 * @param newContact as Class type input parameter
	 * @return Boolean value
	 */

	@Override
	public boolean updatingContact(Contact oldContact, Contact newContact) {
		int findPosition = findContact(oldContact);
		if (findPosition < 0)
			System.out.println(oldContact.toString() + " does not exist");
		this.addressBookList.set(findPosition, newContact);
		System.out.println(oldContact.getFirstName() + " updated");
		return true;
	}

	/**
	 * This method checks if contact is present in the list if present displays the
	 * full name of the contact if not not present returns null
	 * 
	 * @param contact as Class type input parameter
	 * @return String value
	 */

	@Override
	public String searchContact(Contact contact) {
		if (findContact(contact) >= 0)
			return contact.toString();
		return null;
	}

	/**
	 * This method takes first name as input parameter and checks the index position
	 * of contact
	 * 
	 * @param firstName as String input parameter
	 * @return Contact Class type
	 */

	@Override
	public Contact searchContact(String firstName) {
		int position = findContact(firstName);
		if (position >= 0)
			return this.addressBookList.get(position);
		return null;
	}

	/**
	 * This method takes Contact as input parameter and checks if present in the
	 * list
	 * 
	 * @param contact as Class type input parameter
	 * @return boolean value
	 */

	@Override
	public boolean deletingContact(Contact contact) {
		int findPosition = findContact(contact);
		if (findPosition < 0) {
			System.out.println(contact.toString() + " was not found");
			return false;
		}
		this.addressBookList.remove(findPosition);
		System.out.println(contact.toString() + " is deleted");
		return true;
	}

	/** 
	* prints all details of the contact like first name, last name, mobile number, address and email id
	*/
	@Override
	public void printingContactDetails() {
		System.out.println("Contact list:");
//		for (int i = 0; i < addressBookList.size(); i++) {
//			System.out.println((i + 1) + ". First Name: " + addressBookList.get(i).getFirstName() + "\nLast Name: "
//					+ addressBookList.get(i).getLastName() + "\nMobibe Number: "
//					+ addressBookList.get(i).getMobileNumber() + "\nAddress:" + addressBookList.get(i).getAddress()
//					+ "\nEmail Id: " + addressBookList.get(i).getEmailId());
//		}
		int contactCount = 0;
		addressBookList.forEach(contact -> System.out.println((contactCount + 1) + ". First Name: "
				+ contact.getFirstName() + "\nLast Name: " + contact.getLastName()
				+ "\nMobibe Number: " + contact.getMobileNumber() + "\nAddress:"
				+ contact.getAddress() + "\nEmail Id: " + contact.getEmailId()));
	}

	// prints the full name of the user as the first and the last name
	@Override
	public void printFullName() {
		System.out.println("Contact list");
		for (int i = 0; i < addressBookList.size(); i++)
			System.out.println((i + 1) + ". " + addressBookList.get(i).toString());
	}

	@Override
	public String writeDataToJson() {
		String addressBookJson = JsonUtil.convertJavaToJson(addressBookList);
		return addressBookJson;
	}

}
