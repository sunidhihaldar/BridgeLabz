package com.bridgelabz.objectOriented.StockSystem.ServiceImplementation;

import java.util.ArrayList;

import com.bridgelabz.objectOriented.StockSystem.Model.Stock;
import com.bridgelabz.objectOriented.StockSystem.Service.ICompanyServices;

/**
 * This class has the functionality of add a new share, remove a share, find a
 * share from the list, print short hand representation of the list, print
 * in detail data present in the list.
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.11
 * @version 13.0.1
 */

public class CompanyOperation extends Transaction implements ICompanyServices {
	
		public static ArrayList<Stock> companyShareList;

		/**
		 * Constructor to initialize generic type ArrayList.
		 */
		public CompanyOperation() {
			companyShareList = new ArrayList<Stock>();
		}

		/**
		 * Getter method to get arrayList
		 * 
		 */
		@Override
		public ArrayList<Stock> getCompanyShareList() {
			return companyShareList;
		}

		/**
		 * takes Share class type input as input parameter and checks whether it is
		 * present or not. if not present then add the share to the Company's list.
		 */
		@Override
		public boolean AddShare(Stock newShare) {
			if (findShare(newShare.getSymbol()) >= 0) {
				System.out.println("Share already exist.");
				return false;
			}
			companyShareList.add(newShare);
			// queue operation
			transactionDateTime.enqueue(newShare.getDateTime());
			// linkedList operation
			linkedListOperation.insert(newShare);
			return true;
		}

		/**
		 * Overloaded method of findShare takes symbol as input parameter it matches
		 * with all the Share present in the list. if matches it returns the index value
		 * of the contact which is greater than equals to zero.
		 * 
		 * @param symbol as input parameter to check.
		 * @return integer value
		 */
		private int findShare(String symbol) {
			for (int i = 0; i < companyShareList.size(); i++) {
				Stock fetchedShare = companyShareList.get(i);
				if (fetchedShare.getSymbol().equals(symbol)) {
					return i;
				}
			}
			return -1;
		}

		/**
		 * This function takes Share as input parameter and checks whether it is Present
		 * or not, if found then successfully delete the Share else reply with a message
		 * that Share not exist.
		 * 
		 */
		@Override
		public boolean removeShare(Stock share) {
			int foundPosition = findShare(share.getSymbol());
			if (foundPosition < 0) {
				System.out.println(share.getSymbol() + " not found");
				return false;
			}
			companyShareList.remove(foundPosition);
			// queue operation
			transactionDateTime.enqueue(findShare(foundPosition));
			// linkedList operation
			linkedListOperation.delete(foundPosition);
			System.out.println("Share of comapany " + share.getName() + " successfully removed.");
			return true;
		}

		/**
		 * takes index position as input parameter and returns share time of that
		 * position
		 * 
		 * @param indexPosition as Integer input parameter
		 * @return Share Class type data.
		 */
		private String findShare(int indexPosition) {
			return companyShareList.get(indexPosition).getDateTime();
		}

		/**
		 * Takes symbol as input parameter and matches with all index of list. If found
		 * then return the particular class.
		 * 
		 */
		@Override
		public Stock SearchShare(String symbol) {
			int position = findShare(symbol);
			if (position >= 0) {
				return companyShareList.get(position);
			}
			return null;
		}

		/**
		 * Display only the Symbol and Quantity of all the stocks present in the list by
		 * iterating through the loop.
		 */
		@Override
		public void displayShortList() {
			System.out.println("Symbol\t  \tQuantity");
			for (int i = 0; i < companyShareList.size(); i++) {
				Stock getShareIndex = companyShareList.get(i);
				System.out.println(getShareIndex.getSymbol() + "\t->\t" + getShareIndex.getQuantity());
			}
		}

		/**
		 * Prints in detail list giving all informations of the stock iterating through
		 * the loop.
		 */
		@Override
		public void displayFullList() {
			System.out.println("Symbol\t  \tQuantity");
			for (int i = 0; i < companyShareList.size(); i++) {
				Stock getShareIndex = companyShareList.get(i);
				System.out.println("Name : " + getShareIndex.getName() + ", Symbol : " + getShareIndex.getSymbol()
						+ ", price :" + getShareIndex.getPrice() + ", quantity : " + getShareIndex.getQuantity());

			}
		}
		
}
