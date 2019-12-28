package com.bridgelabz.objectOriented.InventorySystem.Service;

import java.util.ArrayList;

import com.bridgelabz.objectOriented.InventorySystem.Model.Inventory;

public interface IInventoryOpsMethods {

	public int calculateTotalWeight(ArrayList<Inventory> inventoryList);
	
	public double calculateTotalPrice(ArrayList<Inventory> inventoryList);
	
	public void displayInventory(ArrayList<Inventory> inventoryList);
	
}
