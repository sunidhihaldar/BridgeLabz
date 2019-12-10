package com.bridgelabz.objectOriented;

/**
 * This class provides properties like name, weight and price along with getter and setter methods
 * and a toString method for printing the data
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.08
 * @version 13.0.1
 */

public class Inventory {

	String name;
	int weight;
	double price;
	
	/**
	 * Constructor assigns the value during object creation
	 * 
	 * @param name as String input parameter
	 * @param weight as integer input parameter
	 * @param price as double input parameter
	 */
	
	public Inventory(String name, int weight, double price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	/**
	 * getter method returns String data
	 * @return string data
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * setter method which sets the name by taking name as input parameter
	 * @param name as String type input parameter
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter method returns integer data
	 * @return integer data
	 */
	
	public int getWeight() {
		return weight;
	}

	/**
	 * setter method which sets the weight by taking weight as input parameter
	 * @param weight as integer type input parameter
	 */
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * getter method returns double data
	 * @return double data
	 */
	
	public double getPrice() {
		return price;
	}

	/**
	 * setter method which sets the price by taking price as input parameter
	 * @param price as double type input parameter
	 */
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Takes the input parameter given in the method and return the object whenever we need to create
	 * an object
	 * @param name as String type input parameter
	 * @param weight as integer type input parameter
	 * @param price as double type input parameter
	 * @return new Class type object
	 */
	
	public static Inventory createInventory(String name, int weight, double price) {
		return new Inventory(name, weight, price);
	}
	
	// prints the data of the class
	public String toString() {
		return "name:" + this.name + " weight:" + this.weight + " price:" + this.price;
	}
	
}
