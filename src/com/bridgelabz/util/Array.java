package com.bridgelabz.util;

/**
 * This class has array functionalities
 * @author Sunidhi Haldar
 * @created 2019-11-24
 * @version 13.0.1
 */

public class Array {
	
	//prints 1D integer array
	public static void print1DArray(int[] array) {
		for(int i= 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	//prints 1D String array
	public static void print1DArray(String[] array) {
		for(int i= 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	//prints 2D integer array
	public static void print2DArray(int[][] array) {
		for(int i= 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] != 0)
					System.out.println(array[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	//prints reversed integer array
	public static int[] reverseArray(int[] array) {
		for(int i = 0; i < array.length / 2; i++) {
			int temporaryVariable = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temporaryVariable;
		}
		return array;
	}
}
