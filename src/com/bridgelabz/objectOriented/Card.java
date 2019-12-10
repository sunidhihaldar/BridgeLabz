package com.bridgelabz.objectOriented;

/**
 * This class has properties like rank and suit of a deck of cards along with getter methods.
 * 
 * @author Sunidhi Haldar
 * @created 2019-12-09
 * @version 13.0.1
 */

public class Card {

	private String suit;
	private String rank;
	
	/**
	 * Constructor initializes during object creation
	 * @param suit as input parameter
	 * @param rank as input parameter
	 */
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * getter method to get suit value
	 * @return String value
	 */
	
	public String getSuit() {
		return suit;
	}

	/**
	 * getter method to get rank value
	 * @return String value
	 */
	
	public String getRank() {
		return rank;
	}

}
