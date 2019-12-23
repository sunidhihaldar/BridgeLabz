package com.bridgelabz.objectOriented.StockSystem.ServiceImplementation;

import com.bridgelabz.dataStructure.*;
import com.bridgelabz.objectOriented.StockSystem.Model.Stock;

/**
 * This class keeps all the transaction records of share holder company and share symbol transaction record.
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.13
 * @version 13.0.1
 */

public class Transaction {

	public static Queue<String> transactionDateTime = new Queue<String>();

	public static Stack<String> transactionSymbol = new Stack<String>();
		
	public static ImplementingLinkedList<Stock> linkedListOperation = new ImplementingLinkedList<Stock>();

	//prints the transaction details of the company and customer.
	public static void displayTimeRecord() {
		transactionDateTime.print();
	}
	
	//print the transaction symbol of the company of on going transaction.
	public static void displaySymbolRecord() {
		transactionSymbol.print();
	}

    //print the symbol of company listed with the stock market
	public static void displayCompanyNames() {
		for(int i = 0; i < linkedListOperation.length(); i++) {
			Stock getIndex = linkedListOperation.getDataFromIndex(i);
			System.out.println(i+1 +". Name : " + getIndex.getName() + ", Symbol : " + getIndex.getSymbol());
		}
	}	

}
