package com.bridgelabz.objectOriented;

/**
 * This class initializes the deck in a sorted order and randomly shuffles the deck  of cards
 * to generate the list of cards each of the 4 players is having
 * 
 * @author Sunidhi Haldar
 * @created 2019-12-09
 * @version 13.0.1
 */

public class CardsSorting extends CDeckOfCards {
	
	// Constructor to initialize the deck during object creation
    public CardsSorting() {
    	for(int i = 0; i < RANKS.length; i++) {
    		for(int j = 0; j < SUITS.length; j++) {
    			deck[SUITS.length * i + j] = RANKS[i] + " --> " + SUITS[j]; 
    		}
    	}
    }
    
    // This method shuffles the cards by picking up each strating from !st index replcing old card's data with new data
    public void shuffleCard() {
    	for(int i = 0; i < deck.length; i++) {
	    	int randomCard = i + (int)(Math.random() * (numberOfCards - i));
	    	String temp = deck[randomCard];
	    	deck[randomCard] = deck[i];
	    	deck[i] = temp;
	    }
    }
    
    // Prints all the cards received by each of the 4 players
    public void display() {
    	System.out.println("Toatl number of cards: " + deck.length);
    	int player = 1;
    	for(int i = 0; i < deck.length; i++) {
    		if(i % 13 == 0)
    			System.out.println("\nPlayer: " + player++ + "\n-----------------------");
    		System.out.println(deck[i]);
    	}
    }

	public static void main(String[] args) {
		CardsSorting cardSort = new CardsSorting();
		cardSort.shuffleCard();
		cardSort.display();
	}

}