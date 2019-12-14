package com.bridgelabz.util;

/**
 * This method implements sorting methods like insertion sort, bubble sort
 * @author Sunidhi Haldar
 * @created 2019-11-25
 * @version 13.0.1
 */

public class Sorting {
	
	/**
	 * This method implements bubble sort for an integer array
	 * @param array as input integer array parameter
	 * @return sorted integer array
	 */
	
	public static int[] bubbleSort(int[] array) {
		int n  = array.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i -1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
	
	/**
	 * This method implements insertion sort for a String array
	 * @param array as input String array parameter
	 * @return sorted String array
	 */
	
	public static String[] insertionSort(String[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int  j = i + 1; j < array.length; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	/**
	 * This method implements insertion sort for an integer array
	 * @param array as input integer array parameter
	 * @return sorted integer array
	 */
	
	public static int[] insertionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int valueToSort = array[i];
			int  j = i;
			while(j > 0 && array[j -1] > valueToSort) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = valueToSort;
		}
		return array;
	}	
	
}
