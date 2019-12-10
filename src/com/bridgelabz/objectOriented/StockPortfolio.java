package com.bridgelabz.objectOriented;

import java.util.ArrayList;

public class StockPortfolio {
	
	static int numberOfStock;
	static ArrayList<Stock> stockList;
	
	public StockPortfolio() {
		StockPortfolio.stockList = new ArrayList<Stock>();
	}

	public int numberOfStock() {
		return numberOfStock;
	}
	
	public int findStock(String stockName) {
		for(int i = 0; i < stockList.size(); i++) {
			Stock fetchedStock = StockPortfolio.stockList.get(i);
			if(fetchedStock.getStockName().equals(stockName))
				return i;
		}
		return -1;
     }
	
	public int findStock(Stock stock) {
		return StockPortfolio.stockList.indexOf(stock);
	}
	
	public boolean addNewStock(Stock stock) {
		if(findStock(stock.getStockName()) >= 0) {
			System.out.println("Stock already exists");
			return false;
		}
		stockList.add(stock);
		return true;
	}
	
	public static void valueOfTotalStocks() {
		if(stockList.isEmpty())
			return;
		long eachValue = 0;
		for(int i = 0; i < stockList.size(); i++) {
			long value = stockList.get(i).getStockPrice();
			eachValue += value;
		}
		System.out.println(eachValue);
	}
	
	public static void valueOfEachStock() {
		if(stockList.isEmpty())
			return;
		long total = 0;
		for(int i = 0; i < numberOfStock; i++) {
			for(int j = 0; j < stockList.size(); j++) {
				long individualValue = stockList.get(i).getStockPrice();
				total += individualValue;
			}
		}
		System.out.println(total);
		
	}
	
	public void display() {
		System.out.println("StockName " + "StockPrice " + "NumberOfShares " + "TotalStockPrice");
		for(int i = 0; i < stockList.size(); i++)
			System.out.println(stockList.get(i).toString());
	}
	
}
