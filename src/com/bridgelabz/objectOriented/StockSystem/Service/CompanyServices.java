package com.bridgelabz.objectOriented.StockSystem.Service;

import java.util.ArrayList;

import com.bridgelabz.objectOriented.StockSystem.Model.Stock;

/**
 * This interface has the unimplemented methods of Company Service
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.12
 * @version 13.0.1
 */

public interface CompanyServices {

	/**
	* Getter method to get arrayList 
	* @return ArrayList of <Share> type
	*/
	ArrayList<Stock> getCompanyShareList();

		/**
		 * add a new Share 
		 * @param newShare of class type as input parameter.
		 * @return Boolean value
		 */
	boolean AddShare(Stock newShare);

		/**
		 * remove a Share
		 * @param share as class type input parameter
		 * @return boolean value
		 */
	boolean removeShare(Stock share);

		/**
		 * Search a share 
		 * @param symbol as String input parameter.
		 * @return <Share> Class type input parameter.
		 */
	Stock SearchShare(String symbol);

		/**
		 * Display only the Symbol and Quantity of all the stocks present in the list by
		 * iterating through the loop.
		 */
	void displayShortList();

		/**
		 * Prints in detail list giving all informations of the stock iterating through
		 * the loop.
		 */
	void displayFullList();

}
