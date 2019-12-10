package com.bridgelabz.dataStructure;

import com.bridgelabz.dataStructure.Queue;

/**
 * This program has the functionalities of bank to deposit amount and withdraw amount from the
 * bank by passing the paramter of account number in the constructor
 * 
 * @author Sunidhi Haldar
 * created 2019-12-01
 * @version 13.0.1
 */

public class BankAccount {
	String accountNumber;
	double balance = 0.0;
	Queue<Double> transactions;
	
	/**
	 * Takes account number as user input of the String type, passed through constructor
	 * during object creation
	 * 
	 * @param accountNumber of String type
	 */
	
	public BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
		this .transactions = new Queue<Double>();
	}
	
	/**
	 * getter method to get account number
	 * @return Account number of string type
	 */
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Takes the amount to be deposited as user input and the amount should be greater than zero
	 * 
	 * @param amount as double parameter
	 */
	
	public void deposit(double amount) {
		if(amount < 0)
			System.out.println("Invalid amount");
		else if(amount == 0)
			System.out.println("Invalid amount");
		else {
			transactions.enqueue(amount);
			this.balance += amount;
			System.out.println("Rupees " + amount + " got deposited \ncurrent balance: " + this.balance);
			System.out.println("All transactions are:");
			transactions.print();
		}
	}
	
	/**
	 * Takes amount to withdraw as user input. The withdrawal balance should be less than
	 * the available balance and greater than zero
	 * 
	 * @param amount as double parameter
	 */
	
	public void withdrawAmount(double amount) {
		if(amount > balance)
			System.out.println("withdrawal not possible \ncurrent balance: " + this .balance);
		else {
			double withdrawalAmount = -amount;
			if(withdrawalAmount < 0) {
				transactions.enqueue(withdrawalAmount);
				this.balance += withdrawalAmount;
				System.out.println("Rupees " + amount + " got withdrawed \ncurrent balance: " + this.balance);
				System.out.println("All transactions are:");
				transactions.print();
			}
			else {
				System.out.println("Cannot withdraw the given amount \ncurrent balance: " + this.balance);
			}
		}
	}
	
}
