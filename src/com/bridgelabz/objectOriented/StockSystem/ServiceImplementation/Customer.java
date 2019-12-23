package com.bridgelabz.objectOriented.StockSystem.ServiceImplementation;

import com.bridgelabz.objectOriented.StockSystem.Model.Stock;
import com.bridgelabz.objectOriented.StockSystem.Service.CompanyServices;
import com.bridgelabz.objectOriented.StockSystem.Service.CustomerServices;
import com.bridgelabz.util.*;
import java.util.ArrayList;

/**
 * This class gives the customer to do actions like purchasing a share from the market where
 * the stocks were given by the companies, also operations like sell a share and display all
 * information of the stocks present in the customer list.
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.12
 * @version 13.0.1
 */

public class Customer extends Transaction implements CustomerServices {

	public static ArrayList<Stock> customerShareList;

    //Constructor to initialize the arrayList
	public Customer() {
		customerShareList = new ArrayList<Stock>();
	}

	//Object of ComapanyOperation class to access functions of that class
	private CompanyServices companyOperation = new CompanyOperation();

	/**
	* This function ask the Customer user to enter the share which he want to purchase also
	* the quantity of share he want to buy. If the share of the particular company is listed
	* in the share market then the customer can purchase that share.
	*/
	
	@Override
	public void buyShare() {
			System.out.println("Enter Share symbol :");
			String inputSymbol = Utility.SCANNER.next();
			Stock foundShare = findShare(CompanyOperation.companyShareList, inputSymbol);
			if (foundShare == null) {
				System.out.println(inputSymbol + " share not found in found.");
				return;
			}

			int foundPosition = findShare(companyOperation.getCompanyShareList(), foundShare);
			if (foundPosition < 0) {
				System.out.println("company Share " + foundShare.getSymbol() + " was not found.");
				return;
			}
			else {
				System.out.println("Enter Quantity you want to buy :");
				int quantity = Utility.intInput();

				if (foundShare.getQuantity() < quantity) {
					System.out.println("Opps! availabe quantity : " + foundShare.getQuantity());
					return;
				}
				int updatedQuantity = foundShare.getQuantity() - quantity;
				String name = foundShare.getName();
				String symbol = foundShare.getSymbol();
				double price = foundShare.getPrice();
				String dateTime = foundShare.getDateTime();
				Stock UpdatedShare = Stock.createShare(name, symbol, price, updatedQuantity, dateTime);
				CompanyOperation.companyShareList.set(foundPosition, UpdatedShare);
				Stock customerPurchase = Stock.createShare(name, symbol, price, quantity, dateTime);
				if (customerShareList.add(customerPurchase)) {
					// transaction record
					transactionDateTime.enqueue("Co-buy : " + customerPurchase.getDateTime());
					// record of transaction symbol
					transactionSymbol.push(customerPurchase.getSymbol() + " : Co-buy");
					System.out.println("Thank you for purchasing " + customerPurchase.getSymbol() + " Share.");
				} else {
					System.out.println("Error purchasing share.");

				}
			}

		}

		/**
		 * This function takes <Share> List and A share class type input parameter
		 * iterate through the loop If matches then it returns index position of the
		 * <Share> from the list else returns negative value.
		 * 
		 * @param list  as List parameter as input parameter
		 * @param share as Class type Input parameter.
		 * @return Integer Value.
		 */
		private int findShare(ArrayList<Stock> list, Stock share) {
			for (int i = 0; i < list.size(); i++) {
				String shareSymbol = list.get(i).getSymbol();
				if (share.getSymbol().equals(shareSymbol)) {
					return i;
				}
			}
			return -1;
		}

		/**
		 * This function takes Symbol and List type reference as input parameter and
		 * iterate through the loop If Input symbol matches with the Symbol data present
		 * in the list then it returns the index position of that matching parameter.
		 * 
		 * @param list   as List parameter as input parameter
		 * @param symbol as String type input parameter
		 * @return <Share> generic Class type.
		 */
		private Stock findShare(ArrayList<Stock> list, String symbol) {
			for (int i = 0; i < list.size(); i++) {
				if (symbol.equals(list.get(i).getSymbol())) {
					return list.get(i);
				}
			}
			return null;
		}

		/**
		 * Display only the Symbol and Quantity of all the stocks present in the list of
		 * Customers by iterating through the loop.
		 */
		@Override
		public void displayCustomerPortfolio() {
			System.out.println("Symbol\t  \tQuantity");
			for (int i = 0; i < customerShareList.size(); i++) {
				Stock getShareIndex = customerShareList.get(i);
				System.out.println(getShareIndex.getSymbol() + "\t->\t" + getShareIndex.getQuantity());
			}
		}

		/**
		 * This function asks the customer to enter the symbol of the stock which he
		 * wants to sell, if the stock present in the list then all information of the
		 * stock is collected and checks whether that stock is present or not in the
		 * Company list.
		 */
		@Override
		public void sellShare() {
			System.out.println("Enter Share sysmbol :");
			String inputSymbol = Utility.SCANNER.next();
			Stock foundShareInCompany = findShare(CompanyOperation.companyShareList, inputSymbol);
			if (foundShareInCompany == null) {
				System.out.println(inputSymbol + " share not found in company.");
				return;
			}
			int foundCompanyPosition = findShare(companyOperation.getCompanyShareList(), foundShareInCompany);
			if (foundCompanyPosition < 0) {
				System.out.println("company Share " + foundShareInCompany.getSymbol() + " was not found.");
				return;
			}
			// searching existing share
			Stock foundShareInCustomer = findShare(customerShareList, inputSymbol);
			if (foundShareInCustomer == null) {
				System.out.println(inputSymbol + " share not found in found");
				return;
			}
			int foundCustomerPosition = findShare(customerShareList, foundShareInCustomer);
			if (foundCustomerPosition < 0) {
				System.out.println("customer Share " + foundShareInCustomer.getSymbol() + " was not found.");
				return;
			}

			System.out.println("Enter Quantity you want to sell :");
			int quantity = Utility.intInput();
			int updatedCompanyQuantity = foundShareInCompany.getQuantity() + quantity;
			int updatedCustomerQuantity = foundShareInCustomer.getQuantity() - quantity;
			String name = foundShareInCompany.getName();
			String symbol = foundShareInCompany.getSymbol();
			double price = foundShareInCompany.getPrice();
			String dateTime = foundShareInCompany.getDateTime();
			Stock UpdatedCustomerShare = Stock.createShare(name, symbol, price, updatedCustomerQuantity, dateTime);
			Stock UpdatedCompanyShare = Stock.createShare(name, symbol, price, updatedCompanyQuantity, dateTime);

			if (foundShareInCustomer.getQuantity() < quantity) {
				System.out.println("Opps! availabe quantity : " + foundShareInCustomer.getQuantity());
			} else if (foundShareInCustomer.getQuantity() == quantity) {
				CompanyOperation.companyShareList.set(foundCompanyPosition, UpdatedCompanyShare);
				customerShareList.remove(foundCustomerPosition);
				System.out.println("all quantity of share " + foundShareInCompany.getSymbol() + " sold.");
			} else {
				CompanyOperation.companyShareList.set(foundCompanyPosition, UpdatedCompanyShare);
				customerShareList.set(foundCustomerPosition, UpdatedCustomerShare);
				System.out.println("Sold quantity " + quantity + " remaining quantity " + UpdatedCustomerShare.getQuantity());
			}
			// record of transaction
			transactionDateTime.enqueue("Cu-sell : " + UpdatedCustomerShare.getDateTime());
			// record of transaction symbol
			transactionSymbol.push(UpdatedCustomerShare.getSymbol() + " : Co-sell");
		}

}
