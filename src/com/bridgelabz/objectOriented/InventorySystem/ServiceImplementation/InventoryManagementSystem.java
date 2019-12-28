package com.bridgelabz.objectOriented.InventorySystem.ServiceImplementation;

import com.bridgelabz.objectOriented.InventorySystem.Model.Inventory;
import com.bridgelabz.objectOriented.InventorySystem.Service.IInventoryManagement;
//import com.bridgelabz.util.JsonUtil;
import com.bridgelabz.util.Utility;

/**
 * This class provides the implementation of addition, deletion and updation operations
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.09
 * @version 13.0.1
 */

public class InventoryManagementSystem {
	
	String inventoryName;
	static IInventoryManagement inventory = new InventoryOperations("Admin");
	static final String INVENTORY_PATH = "inventory.json";
	
	/**
	 * Constructor to initialize and set the inventory name 
	 * @param inventoryName as input parameter
	 */
	
	public InventoryManagementSystem(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	/**
	 * getter method to get inventory name
	 * @return String value
	 */
	
	public String getInventoryName() {
		return inventoryName;
	}

	/**
	 * setter method to set the inventory name
	 * @param inventoryName of String type as input parameter
	 */
	
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	
	public static void printInstructions() {
		System.out.println("Options are:");
		System.out.println("\t1. switch from inventory\n" + "\t2. add a new product\n" 
		                + "\t3. update an existing product\n" + "\t4. remove an existing product\n"
				        + "\t5. Search for a product in the inventory\n" + "\t6. Print all details of product\n"
		                + "\t7. Print instructions\n" + "\t8. Quit");
	}
	
	/**
	 * This method takes inputs such as name, weight and price of the item and creates
	 * a new Class type object and calls the addNewItem() method by using object reference
	 */
	
	public static void addNewProductToInventory() {
		System.out.println("Enter the name");
		String name = Utility.SCANNER.next();
		System.out.println("Enter the weight");
		int weight = Utility.intInput();
		System.out.println("Enter the price");
		double price = Utility.SCANNER. nextDouble();
		
		Inventory newItem = Inventory.createInventory(name, weight, price);
		if(inventory.addNewItem(newItem))
			System.out.println("Item " + newItem.getName() + " added");
		else
			System.out.println("Item " + newItem.getName() + " already present in inventory");
		Utility.writeDataToFile(inventory.writeDataToJson(), INVENTORY_PATH);
	}

	/**
	 * This method takes the existing name of the product and searches for the product name
	 * by using object reference, if the product exists it asks the user to enter updated values
	 * of weight and price of the existing product. It creates a new Class type object 
	 * and uses updateInventory() method from reference type and updates the object
	 */
	
	public static void updateExistingProductInInventory() {
		System.out.println("Enter the name of the product you want to modify");
		String oldProductName = Utility.SCANNER.next();
		Inventory existingProductInInventory = inventory.searchInInventory(oldProductName);
		if(existingProductInInventory == null) {
			System.out.println(oldProductName + " not found in inventory");
			return;
		}
		System.out.println("Enter the weight");
		int weight = Utility.intInput();
		System.out.println("Enter the price");
		double price = Utility.SCANNER.nextDouble();
		Inventory updatedProductInInventory = Inventory.createInventory(oldProductName, weight, price);
		if(inventory.updateInventory(existingProductInInventory, updatedProductInInventory))
			System.out.println("Item updated in inventory");
		else
			System.out.println("Item not updated in inventory");
		Utility.writeDataToFile(inventory.writeDataToJson(), INVENTORY_PATH);
	}
	
	/**
	 * This method takes user input of the name of the product the user wants to delete. It searches
	 * for the product using object reference, if the product exists it deletes the product from
	 * the inventory
	 */
	
	public static void deleteProductFromInventory() {
		System.out.println("Enter the name of item you want to delete");
		String deleteProductName = Utility.SCANNER.next();
		Inventory existingProductInInventory = inventory.searchInInventory(deleteProductName);
		if(existingProductInInventory == null) {
			System.out.println(deleteProductName + " not found in inventory");
			return;
		}
		if(inventory.removeItem(existingProductInInventory))
			System.out.println(existingProductInInventory.getName() + " deleted");
		else
			System.out.println("Not deleted");
		Utility.writeDataToFile(inventory.writeDataToJson(), INVENTORY_PATH);
	}
	
	/**
	 * Takes the product name as the user input the user wants to search for and searches for
	 * the product using object reference, if the product is found then prints the details
	 * of the object
	 */

	public static void searchProductFromInventory() {
		System.out.println("Enter the product name you want to search");
		String productName = Utility.SCANNER.next();
		Inventory existingProduct = inventory.searchInInventory(productName);
		if(existingProduct == null) {
			System.out.println(productName + " not found in inventory");
			return;
		}
		System.out.println("name = " + existingProduct.getName() + "\nweight = " + existingProduct.getWeight()
		                 + "\nprice = " +existingProduct.getPrice());
	}
	
	// Prints all the data present in the inventory
	public static void printInventory() {
		inventory.printInventory();
	}
	
	/**
	 * Method to perform actions associated with the cases
	 * @param isQuit of Boolean type as input parameter
	 * @return Boolean value
	 */
	public static boolean inventoryChoies(boolean isQuit) {
		printInstructions();
		boolean switchFromInventory = false;
		
		while(!switchFromInventory || isQuit) {
			System.out.println("Enter choice: [enter 7 to print instructions]");
			int choice = Utility.intInput();
			
			switch(choice) {
			case 1:
				switchFromInventory = true;
				isQuit = false;
				System.out.println("Thank you");
				break;
			case 2:
				addNewProductToInventory();
				//Utility.writeToFile(writeDataToJson(), "");
				break;
			case 3:
				updateExistingProductInInventory();
				//Utility.writeToFile(writeDataToJson(), "");
				break;
			case 4:
				deleteProductFromInventory();
				//Utility.writeToFile(writeDataToJson(), "");
				break;
			case 5:
				searchProductFromInventory();
				break;
			case 6:
				printInventory();
				break;
			case 7:
				printInstructions();
				break;
			case 8:
				switchFromInventory = true;
				isQuit = true;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		return true;
	}
	
}
