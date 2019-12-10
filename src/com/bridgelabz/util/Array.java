package com.bridgelabz.util;

public class Array {
	public static void print1DArray(int[] array) {
		for(int i= 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	public static void print1DArray(String[] array) {
		for(int i= 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	public static void print2DArray(int[][] array) {
		for(int i= 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] != 0)
					System.out.println(array[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public static int[] reverseArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int temporaryVariable = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temporaryVariable;
		}
		return array;
	}
}
