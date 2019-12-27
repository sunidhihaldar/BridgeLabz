package com.bridgelabz.objectOriented.InventorySystem.ServiceImplementation;

import java.util.ArrayList;

import com.bridgelabz.objectOriented.InventorySystem.Model.Inventory;
import com.bridgelabz.objectOriented.InventorySystem.Service.InventoryManagement;
import com.bridgelabz.objectOriented.InventorySystem.Service.InventoryOpsMethods;
import com.bridgelabz.util.JsonUtil;

/**
 * This program provies funtionalities like adding new item to the inventory, updating an item
 * in the inventory, searching for an item in the inventory and removing an item from the 
 * inventory. Also provides methods to calculate total weight and total price
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.09
 * @version 13.0.1
 */

public class InventoryOperations implements InventoryOpsMethods, InventoryManagement {

	String inventoryName;
	private static ArrayList<Inventory> inventoryList;
	/**
	 * Constructor to initialize Array list and set the inventory name
	 * @param name as input parameter
	 */
	
	public InventoryOperations(String name) {
		this.inventoryName = name;
		inventoryList = new ArrayList<Inventory>();
	}
	
	public static ArrayList<Inventory> getInventoryList() {
		return inventoryList;
	}

	/**
	 * getter method to get the inventory name
	 * @return String data
	 */
	
	public String getInventoryName() {
		return inventoryName;
	}

	/**
	 * setter method to set inventory name
	 * @param inventoryName as String input
	 */
	
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	
	/**
	 * Displays the total weight of the objects in the inventory
	 * @return Integer value
	 */
	
	@Override
	public int calculateTotalWeight(ArrayList<Inventory> inventoryList) {
		int totalWeight = 0;
		for(int i = 0; i < inventoryList.size(); i++) {
			int individualWeight = inventoryList.get(i).getWeight();
			totalWeight += individualWeight;
		}
		return totalWeight;
	}
	
	/**
	 * Displays the total price of the objects in the inventory
	 * @return douuble value
	 */
	
	@Override
	public double calculateTotalPrice(ArrayList<Inventory> inventoryList) {
		double totalPrice = 0;
		for(int i = 0; i < inventoryList.size(); i++) {
			double individualPrice = inventoryList.get(i).getPrice();
			totalPrice += individualPrice;
		}
		return totalPrice;
	}
	/**
	 * Displays all the data present in the inventory
	 * @return toString value 
	 */
	
	@Override
	public void displayInventory(ArrayList<Inventory> inventoryList) {
		for(int i = 0; i < inventoryList.size(); i++) {
			System.out.println((i + 1) + ". " + inventoryList.get(i).toString());
		}
	}
	
	/**
	 * Takes new item of Class type as input parameter and hecks whether if it is present in the
	 * inventory Array List, if not present adds to the inventory
	 * @param newItem of Class type as input parameter
	 * @return Boolean value
	 */
	
	public boolean addNewItem(Inventory newItem) {
		if(findInInventory(newItem.getName()) >= 0) {
			System.out.println("Item already in the list");
			return false;
		}
		inventoryList.add(newItem);
		return true;
	}
	
	/**
	 * Takes inventory Class type item as input parameter and returns the index position
	 * of inventory
	 * @param inventoryItem of Class type as input parameter
	 * @returnInteger value
	 */
	
	public int findInInventory(Inventory inventoryItem) {
		return inventoryList.indexOf(inventoryItem);
	}
	
	/**
	 * If name matches with the inventory object's name then returns the index position of that object
	 * @param name of String type as input parameter
	 * @return integer value
	 */
	
	public int findInInventory(String name) {
		for(int i = 0; i < inventoryList.size(); i++) {
			Inventory fetchedItem = inventoryList.get(i);
			if(fetchedItem.getName().contentEquals(name))
				return i;
		}
		return -1;
	}
	
	/**
	 * Takes product name as input parameter and searches for the index position by calling
	 * findInInventory(), if the index position is positive returns the complete class in that position
	 * else returns null
	 * @param productName of String type as input parameter 
	 * @return Inventory Class type
	 */
	
	public Inventory searchInInventory(String productName) {
		int position = findInInventory(productName);
		if(position >= 0)
			return inventoryList.get(position);
		return null;
	}
	
	/**
	 * Takes item name as input paameter and checks if it is present in the inventory Array List,
	 * if present then removes the item from the inventory.
	 * @param itemName of Class type as input prameter
	 * @return Boolean value
	 */
	
	public boolean removeItem(Inventory itemName) {
		int findPosition = findInInventory(itemName);
		if(findPosition < 0) {
			System.out.println(itemName.getName() + " was not found");
			return false;
		}
		inventoryList.remove(findPosition);
		System.out.println(itemName.getName() + " is deleted");
		return true;
	}
	
	/**
	 * Takes old item and new item of Class type as input parameters and checks if present in the inventory
	 * Array list, if present updates the old item with new item at the old item's index value and return a boolean value
	 * @param oldItem of Class type as input parameter
	 * @param newItem of Class type as input parameter
	 * @return Boolean value
	 */
	
	public boolean updateInventory(Inventory oldItem, Inventory newItem) {
		int findPosition = findInInventory(oldItem);
		if(findPosition < 0) 
			System.out.println(oldItem.getName() + " does not exist");
		inventoryList.set(findPosition, newItem);
		System.out.println(oldItem.getName() + " updated");
		return true;
	}

	/**
	 * If the list is not empty then prints item in the inventory in the form of toString()
	 * method defined in Inventory class.
	 */
	
	@Override
	public void printInventory() {
		if(inventoryList.isEmpty())
			System.out.println("Inventory is empty");
		for(int i = 0; i < inventoryList.size(); i++)
			System.out.println((i + 1) + ". " + inventoryList.get(i).toString());
	}
	
	@Override
	public String writeDataToJson() {
		String inventoryManagement = JsonUtil.convertJavaToJson(inventoryList);
		return inventoryManagement;
	}
	
}
