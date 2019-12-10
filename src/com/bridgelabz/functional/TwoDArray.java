package com.bridgelabz.functional;

import com.bridgelabz.util.Array;
import com.bridgelabz.util.Utility;

/**
 * A program for reading in 2D arrays of integers, doubles and booleans
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class TwoDArray {
	
	public static void main(String[] args) {
		System.out.println("Enter the total rows:");
		int rows = Utility.intInput();
		System.out.println("Enter the total columns:");
		int columns = Utility.intInput();
		int[][] array = new int[rows][columns];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				array[i][j] = Utility.intInput();
			}
		}
		Array.print2DArray(array);
	}

}
