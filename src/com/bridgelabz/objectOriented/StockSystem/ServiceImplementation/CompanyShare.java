package com.bridgelabz.objectOriented.StockSystem.ServiceImplementation;

import com.bridgelabz.objectOriented.StockSystem.Model.Stock;
import com.bridgelabz.objectOriented.StockSystem.Service.ICompanyServices;
import com.bridgelabz.util.Utility;

/**
 * This class has the functionality of add a newShare , remove a share if the
 * company don't want to keep in the market. also some functionality like
 * display short hand representation of the share, Complete information of the
 * share.
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.13
 * @version 13.0.1
 */

public class CompanyShare extends Transaction {
	
	private static ICompanyServices companyOperation = new CompanyOperation();

	/**
	* Allows the user to give input of Company name, Company Symbol, Price and
	* Quantity then it creates new Object of share and checks the necessary
	* conditions create a new Share for company. After successful creation of new
	*/
	
	public void addNewShare() {
		System.out.println("Enter the company Name :");
		String companyName = Utility.SCANNER.next();
		Utility.SCANNER.nextLine();
		System.out.println("Enter the company Symbol :");
		String companySymbol = Utility.SCANNER.next();
		System.out.println("Enter the share price :");
		double sharePrice = Utility.SCANNER.nextDouble();
		System.out.println("Enter the share Quantity :");
		int shareQuantity = Utility.intInput();
		Stock newShare = Stock.createShare(companyName, companySymbol, sharePrice, shareQuantity);
		if(companyOperation.AddShare(newShare)) {
			System.out.println("Share of " + newShare.getSymbol() + " company added sucessfully.");
		}
		else {
			System.out.println("Cannot add " + newShare.getName() + "'s company's share");
		}
		// record of transaction symbol
		transactionSymbol.push(newShare.getSymbol() + " : Co-add");
		// record of transaction date time
		transactionDateTime.enqueue("Co-add : " + newShare.getDateTime());
		}

		/**
		 * Allows the user to give input of Company Symbol on the basis of symbol it
		 * search whether the share is present or not. if present then delete it from
		 * the list.
		 */
	public void removeShare() {
		System.out.println("Enter share symbol :");
		String symbol = Utility.SCANNER.next();
		Stock existingShare = companyOperation.SearchShare(symbol);
		if (existingShare == null) {
			System.out.println("Share not found.");
		    return;
		}
		if (companyOperation.removeShare(existingShare)) {
			System.out.println("Share of " + existingShare.getSymbol() + " deleted");
		}
		else {
			System.out.println("Error deleting record.");
		}
		// record of transaction symbol
		transactionDateTime.enqueue("Removed : " + existingShare.getDateTime());
		// record of transaction time
		transactionSymbol.push(existingShare.getSymbol() + " : removed");
	}

	//It prints only the short hand representation of the list
	public void displayShortSharesList() {
		System.out.println("All shares of the companies :");
		companyOperation.displayShortList();
	}

	//prints inDetail List of the data present in the list
	public void displayIndetailShareList() {
		System.out.println("All shares of the companies :");
		companyOperation.displayFullList();
	}

}