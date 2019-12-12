package com.bridgelabz.dataStructure;

import com.bridgelabz.dataStructure.Queue;
import com.bridgelabz.util.Utility;

/**
 * This program performs operations like depositing money, withdrawal and printing number of 
 * people in the queue. Firstly it asks the user to fill all details and asks to fill the
 * account number.
 * 
 * @author Sunidhi Haldar
 * created: 2019-12-01
 */

public class BankExecution {
	static Queue<String> queue = new Queue<String>();
	static boolean isQuitApp = false;

	/**
	 * This method takes account number as input parameter and performs operations inside
	 * switch block according to user input
	 * @param accountNumber of String type as input parameter
	 */
	
	public static void bankOperations(String accountNumber) {
		BankAccount myAccount = new BankAccount(accountNumber);
		boolean isTransactionComplete = false;
		while(!isTransactionComplete) {
			System.out.println();
			System.out.println("Banking cash counter");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Number of people in the queue");
			System.out.println("4. Exit");
			System.out.println();
			System.out.println("Enter your choice:");
			int choice = Utility.intInput();
			switch(choice) {
			case 1: System.out.println("Enter the amount you want to deposit");
			        myAccount.deposit(Utility.SCANNER.nextDouble());
			        break;
			case 2: System.out.println("Enter amount you want to withdraw ");
			        myAccount.withdrawAmount(Utility.SCANNER.nextDouble());
			        break;
			case 3: System.out.println("People in the queue is: ");
			        queue.dequeue();
			        isTransactionComplete = true;
			        break;
			case 4: isTransactionComplete = true;
			        isQuitApp = true;
			        System.out.println("Closed");
			        break;
			default: System.out.println("You have entered a wrong choice");
			        break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Number of people int the queue:");
		int length = Utility.intInput();
		System.out.println("Enter customer name");
		for(int i = 0; i < length ; i++) {
			String customerName = Utility.stringInput();
			queue.enqueue(customerName);
		}
		System.out.println("Number of people in the queue:");
		queue.print();
		int queueLength = queue.size();
		while(queueLength > 0 && !isQuitApp) {
			System.out.println("Enter account number");
			String accountNumber = Utility.SCANNER.next();
			bankOperations(accountNumber);
			System.out.println("Remaining people in the queue");
			queue.print();
		}
	}
	
}
