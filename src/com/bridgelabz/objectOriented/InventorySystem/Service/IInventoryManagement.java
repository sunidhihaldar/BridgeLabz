package com.bridgelabz.objectOriented.InventorySystem.Service;

import com.bridgelabz.objectOriented.InventorySystem.Model.Inventory;

public interface IInventoryManagement {

	public boolean addNewItem(Inventory newItem);
	
	public Inventory searchInInventory(String productName);
	
	public boolean removeItem(Inventory itemName);
	
	public boolean updateInventory(Inventory oldItem, Inventory newItem);

	public void printInventory();
	
	String writeDataToJson();
	
}
