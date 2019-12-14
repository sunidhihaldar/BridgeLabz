package com.bridgelabz.util;

/**
 * This class implements searching methods like binary search
 * @author Sunidhi Haldar
 * @created 2019-11-22
 * @version 13.0.1
 */

public class Searching {
	
	/**
	 * This method is valid for sorted array and returns the index position of the integer element in the array
	 * @param inputArray as input integer array parameter
	 * @param key as input parameter is the value to be searched
	 * @return the position of key
	 */
	
	public static int binarySearch(int[] inputArray, int key) {
		int start = 0;
		int end = inputArray.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(key == inputArray[mid]) 
				return mid;
			if(key < inputArray[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
	    return -1;
	}
	
	/**
	 * This method is valid for sorted array and returns the index element of the String element
	 * @param names as input String array parameter
	 * @param key as input parameter as the String element to be searched
	 * @return the position of key
	 */
	
	public static int binarySearch(String[] names, String key) {
		int first = 0;
		int last = names.length - 1;
		while(first <=  last) {
			int middle = (last + (last - first)) / 2;
			int result = key.compareTo(names[middle]);
			if(result == 0)
				return middle;
			if(result > 0)
				first = middle + 1;
			else
				last = middle - 1;
		}
		return -1;
	}
	
	/**
	 * This method iterate to last of the array and return the index position of the array and returns index
	 * value of the key if present
	 * @param <G> generic class type as input parameter
	 * @param array takes array of any class type as input parameter
	 * @param key is the value to be searched
	 * @return integer value
	 */
	
	public static <G> int linearSearch(G[] array, G key) {
		for(int index = 0; index < array.length; index++) {
			if(key.equals(array[index]))
				return index;
		}
		return -1;
	}
	
}
