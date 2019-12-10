package com.bridgelabz.logical;

import com.bridgelabz.util.Utility;

/**
 * A program to simulate a gambler who starts with $stake and places $1 bets until he/she goes broke or reach $goal 
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class Gambler {
	
	/**
	 * @param stake is the amount the gambler starts playing with
	 * @param goal is the amount the gambler aims to win
	 * @param trials is the number of times he wishes to play
	 */

	public static void main(String[] args) {
		System.out.println("Amount on $stake");
		int stake = Utility.SCANNER.nextInt();
		System.out.println("Amount on $goal");
		int goal = Utility.SCANNER.nextInt();
		System.out.println("Enter the number of trials"); 
		int trials = Utility.SCANNER.nextInt();
		gamblingImplementation(stake,goal,trials);
		}
	
	/**
	 * gamblingImplementation() method defines the number of wins and bets he/she has made 
	 * @param bet is the number of times he/she places his/her bets
	 * @param win is the number of times he/she wins
	 * @param cash is the amount he/she palces at stake
	 */
	
	public static void gamblingImplementation(int stake, int goal,int trials) {
		int bet = 0, win = 0;
		for(int i = 1; i <= trials; i++) {
			int cash = stake;
			while(cash >= 0 && cash <= goal) {
				bet++;
				if(Math.random() >= 0.5) {
					cash++;
				}
				else {
					cash--;
				}
				if(cash == goal) {
					win++;
				}
			}
		}
		System.out.println("Number of wins:" + win);
		System.out.println("Percentage of wins:" + (int)(100 * win / trials));
		System.out.println("Average bet:" + bet / trials);
	}

}
