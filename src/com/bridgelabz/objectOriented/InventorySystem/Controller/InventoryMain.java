package com.bridgelabz.objectOriented.InventorySystem.Controller;

import com.bridgelabz.objectOriented.InventorySystem.ServiceImplementation.InventoryManagementSystem;
//import java.util.ArrayList;
//import com.bridgelabz.util.JsonUtil;
import com.bridgelabz.util.Utility;

/**
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.09
 * @version 13.0.1
 */

public class InventoryMain {
	
	String managerName;
	//static ArrayList<InventoryManagementSystem> inMangSys = new ArrayList<InventoryManagementSystem>();
	static InventoryManagementSystem inMangSystem = new InventoryManagementSystem("manager");
	
	/**
	 * getter method to get manager name
	 * @return String value
	 */
	
	public String getManagerName() {
		return managerName;
	}

	/**
	 * setter method to set manager name
	 * @param managerName as input parameter of String type
	 */
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

    public static void printInstructions() {
    	System.out.println("Options are:");
    	System.out.println("1. operate rice inventory" + "\t2. operate wheat inventory"
    	                 + "\t3. operate pulses inventory" + "\n4. print instructions" 
    			         + "\t5. quit");
    }

   // public static void riceInventory() {
    //	inMangSys.add(e);
    //}
    
//    public static String writeDataToJson() {
//    	String inventoryManagement = JsonUtil.convertJavaToJson(InventoryManagementSystem.);
//    	return inventoryManagement;
//    }
//    
	public static void main(String[] args) {
		System.out.println("Enter name of manager");
		String managerName = Utility.SCANNER.next();
		System.out.println("Welcome " + managerName + " to inventory");
		System.out.println("Enter the name of the inventory");
		String inventoryName = Utility.SCANNER.next();
		inMangSystem.setInventoryName(inventoryName);
		System.out.println(inMangSystem.getInventoryName() + " Inventory");
		System.out.println("----------------------------------------------");
		printInstructions();
		boolean isQuit = false;
		
		while(!isQuit) {
			System.out.println("Enter choice:");
			int choice = Utility.intInput();
			switch(choice) {
			case 1:
				System.out.println("Welcome to rice inventory");
				InventoryManagementSystem.inventoryChoies(isQuit);
				//Utility.writeToFile(writeDataToJson(), "");
				break;
			case 2:
				System.out.println("Welcome to wheat inventory");
				InventoryManagementSystem.inventoryChoies(isQuit);
				break;
			case 3:
				System.out.println("Welcome to pulses inventory");
				InventoryManagementSystem.inventoryChoies(isQuit);
				break;
			case 4:
				printInstructions();
				break;
			case 5:
				isQuit = true;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}