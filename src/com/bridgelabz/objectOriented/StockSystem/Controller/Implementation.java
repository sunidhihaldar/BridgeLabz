package com.bridgelabz.objectOriented.StockSystem.Controller;

import com.bridgelabz.objectOriented.StockSystem.ServiceImplementation.Operation;
import com.bridgelabz.objectOriented.StockSystem.ServiceImplementation.Transaction;
import com.bridgelabz.util.Utility;

/**
 * This class has the all implementation of all trading operation between
 * customer and Company.
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.16
 * @version 13.0.1
 */

public class Implementation {

	public static void main(String[] args) {
		Operation implimentation = new Operation();

		boolean isQuitApplication = false;
		while (!isQuitApplication) {
			System.out.println("Enter action :\n1-> login as company. 2-> login as customer. "
					+ "3-> Quit application.\n4-> display dateTime transaction. 5-> display share symbol transaction. "
					+ "6-> listed company.");
			int action = Utility.intInput();
			switch (action) {
			case 1:
				implimentation.companyOperation(isQuitApplication);
				break;
			case 2:
				implimentation.customerOperation(isQuitApplication);
				break;
            case 3:
				isQuitApplication = true;
				break;
			case 4:
				System.out.println("Recent date time of Transactions");
				Transaction.displayTimeRecord();
				break;
			case 5:
				System.out.println("Recent Symbol transactions.");
			    Transaction.displaySymbolRecord();
				break;
			case 6:
				System.out.println("Company listed on market :");
				Transaction.displayCompanyNames();
				break;
            default:
				System.out.println("Please read instructions!");
			}
		}
	}

}
