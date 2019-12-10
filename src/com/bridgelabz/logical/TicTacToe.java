package com.bridgelabz.logical; 

import com.bridgelabz.util.Utility;

/**
 * A program to play Tic Tac Toe
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class TicTacToe {
	public static int row, column;
	public static char[][] board = new char[3][3];
	public static char turn = 'X';

	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}
		play();
	}
	public static void play() {
		boolean playing = true;
		printBoard();
		while(playing) {
			System.out.println("Enetr the row and column");
			row = Utility.SCANNER.nextInt() - 1;
			column = Utility.SCANNER.nextInt() - 1;	
			board[row][column] = turn;
			if(gameOver(row, column)) {
				playing = false;
				System.out.println("Game over! Player " +turn+ " wins!");
			}
			printBoard();
			if(turn == 'X') 
				turn = '0';
			else 
				turn = 'X';
			}
	}
	
	// printBoard() method give sthe structure of the board
    public static void printBoard() {
    	for(int i = 0; i < 3; i++) {
    		System.out.println();
    		for(int j = 0; j < 3; j++) {
    			if(j == 0)
    				System.out.print("| ");
    			System.out.print(board[i][j] + " | ");
    		}
    	}
    	System.out.println();
    }
    
    // gameOver() method defines the conditions when the user wins 
    public static boolean gameOver(int rowMove, int columnMove) {
    	// Checking perpendicularly
    	if(board[0][columnMove] == board[1][columnMove] && board[0][columnMove] == board[1][columnMove])
    		return true;
    	if(board[rowMove][0] == board[rowMove][1] && board[rowMove][0] == board[rowMove][2])
    		return true;
    	// Checking diagonally
    	if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_')
    		return true;
    	if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
    		return true;
    	return false;
    }
}
