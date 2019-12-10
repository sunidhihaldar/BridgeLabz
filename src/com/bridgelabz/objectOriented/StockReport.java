package com.bridgelabz.objectOriented;

import com.bridgelabz.util.Utility;

public class StockReport {
	static StockPortfolio myStock = new StockPortfolio();

	public static void addNewStock() {
		System.out.println("Enter the stock name");
		String stockName = Utility.SCANNER.next();
		System.out.println("Enter the stock price");
		long stockPrice = Utility.longInput();
		System.out.println("Enter the stock number of  shares");
		int stockNumberOfShares = Utility.intInput();
		Stock newStock = Stock.createStock(stockName, stockPrice, stockNumberOfShares);
		if(myStock.addNewStock(newStock))
			System.out.println("Stock name added");
		else
			System.out.println("Stock name exists");
	}
	
	public static void main(String[] args) {
		
	//	String path = "C:\\Users\\SONY\\eclipse-workspace\\Fellowships\\Files\\Stock.json";
	//	String outputPath = "C:\\Users\\SONY\\eclipse-workspace\\Fellowships\\Files\\StockOutput.json";
		
		
		System.out.println("Stock Account Management");
		System.out.println("------------------------");
		System.out.println();
		System.out.println("The options:");
		System.out.println("1. Add new stock \n2. Print sum of each stock \n3. Print sum of all stocks \n4. Display all details \n5. Quit");
		boolean quit = false;
		while(!quit) {
			System.out.println("Choose an option:");
			int choice = Utility.intInput();
			switch(choice) {
			case 1:
				addNewStock();
				break;
			case 2:
				StockPortfolio.valueOfEachStock();
				break;
			case 3:
				StockPortfolio.valueOfTotalStocks();
			case 4:
				myStock.display();
				break;
			case 5:
				quit = true;
            	System.out.println("Thank You");
            	break;
			default:
				System.out.println("Invalid option");
			}
		}

	}

}
