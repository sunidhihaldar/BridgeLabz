package com.bridgelabz.algorithm;

import com.bridgelabz.util.Utility;

/**
 * A prgram to do Merge Sort for a list of strings 
 * @author Sunidhi Haldar
 * @created 15.11.19
 * @version 13.0.1
 */

public class MergeSort {
	
	int[] array;
	int[] temporaryMergeArray;
	int length;
	
	/**
	 * @param length is used to store the number of array elements
	 * @param array is used to store the array elements
	 */

	public static void main(String[] args) {
		MergeSort mergesort = new MergeSort();
		System.out.println("Enter the number of elements");
		int length = Utility.SCANNER.nextInt();
		int[] array = new int[length];
		mergesort.sort(array);
		System.out.println("Enter the array elements");
		for(int i = 0; i < length; i++) {
			array[i] = Utility.SCANNER.nextInt();
		}
		System.out.println("The sorted list of array elements are");
		for(int i = 0; i < array.length; i++) {
			System.out.println(i +" ");
		}
	}
	
	public void sort(int[] array) {
		this.array = array;
		this.length = array.length;
		this.temporaryMergeArray = new int[length];
		divideArray(0, length - 1);
	}
	
	/**
	 * divideArray() method is used to sort the left side and the right side of an array
	 * @param lowerIndex is the first index in the array
	 * @param higherIndex is the last index in the array
	 */
	public void divideArray(int lowerIndex, int higherIndex) {
		if(lowerIndex < higherIndex) {
			int middleIndex = (higherIndex - lowerIndex)/2;
			
			// It will sort left side of an array
			divideArray(lowerIndex, middleIndex);
			
			// It will sort right side of an array
			divideArray(middleIndex + 1, higherIndex);
			mergeArray(lowerIndex, middleIndex, higherIndex);
		}
	}
	
	public void mergeArray(int lowerIndex, int middleIndex, int higherIndex) {
		for(int i = lowerIndex; i <= higherIndex; i++) {
			temporaryMergeArray[i] = array[i];
		}
		int i = lowerIndex;
		int j = middleIndex + 1;
		int k = lowerIndex;
		while(i <= middleIndex && j<= higherIndex) {
			if(temporaryMergeArray[i] <= temporaryMergeArray[k]) {
				array[k] = temporaryMergeArray[i];
				i++;
			}
			else {
				array[k] = temporaryMergeArray[j];
				j++;
			}
			k++;
		}
		while(i <= middleIndex) {
			array[k] = temporaryMergeArray[j];
			j++;
		}
	}

}
