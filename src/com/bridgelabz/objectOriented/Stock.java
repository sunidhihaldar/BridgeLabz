package com.bridgelabz.objectOriented;

public class Stock {

	private String stockName;
	private long stockPrice;
	private int stockNumberOfShares;
	
	public Stock(String stockName, long stockPrice, int stockNumberOfShares) {
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockNumberOfShares = stockNumberOfShares;
		}

	public String getStockName() {
		return stockName;
	}

	public long getStockPrice() {
		return stockPrice;
	}

	public int getStockNumberOfShares() {
		return stockNumberOfShares;
	}
 
	public static Stock createStock(String stockName, long stockPrice, int stockNumberOfShares) {
		return new Stock(stockName, stockPrice, stockNumberOfShares);
	}
	
	@Override
	public String toString() {
		return this.stockName + "\t\t" + this.stockPrice + "\t\t" + this.stockNumberOfShares + "\t\t" + (stockPrice * stockNumberOfShares) + "\t\t" + "\n";
	}
	
}
