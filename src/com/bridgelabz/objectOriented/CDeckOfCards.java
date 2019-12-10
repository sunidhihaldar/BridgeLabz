package com.bridgelabz.objectOriented;

import java.util.Random;

/**
 * This class shuffles the deck of cards and assigns 9 cards each randomly to 4 players
 * 
 * @author Sunidhi Haldar
 * @created 2019-12-09
 * @version 13.0.1
 */

public class CDeckOfCards {

	int[][] cards;
	static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int numberOfCards = SUITS.length * RANKS.length;
	String[] deck = new String[numberOfCards];

	public CDeckOfCards() {
		cards = new int[4][13];
	}

	/**
	 * This method shuffles and assigns each player 9 cards
	 * @param playerNumber as input parameter
	 */
	
	public void assignCards(int playerNumber) {
		for (int i = 0; i < 9; i++) {
			shuffle(playerNumber);
		}
	}

	/**
	 * This methosd randomly generates suit and rank and recursively calls the function
	 * unless 0 is found in the 2D array, if not found then assign the card to next player
	 * @param playerNumber as input parameter
	 */
	
	public void shuffle(int playerNumber) {
		Random random = new Random();
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		if (cards[suit][rank] != 0)
			shuffle(playerNumber);
		else
			cards[suit][rank] = playerNumber;
	}

	// Prints the cards of each player
	public void print(int playerNumber) {
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				if (cards[suit][rank] == playerNumber)
					System.out.println(SUITS[suit] + " --> " + RANKS[rank]);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CDeckOfCards cd = new CDeckOfCards();
		System.out.println("Total number of cards " + cd.numberOfCards);
		for (int playerNumber = 1; playerNumber <= 4; playerNumber++) {
			cd.assignCards(playerNumber);
			System.out.println("Player" + playerNumber + "\n-------------------\n");
			cd.print(playerNumber);
		}
	}
}