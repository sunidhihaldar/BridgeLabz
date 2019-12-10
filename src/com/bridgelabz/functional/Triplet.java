package com.bridgelabz.functional;

import com.bridgelabz.util.Utility;

/**
 * A program to read in N integers and counts the number of triples that sum to zero
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class Triplet {

	public static void main(String[] args) {
		System.out.println("Enter the number of array elements");
		int length = Utility.SCANNER.nextInt();
		int[] array= new int[length];
		System.out.println("Enter the array elements");
		for(int i = 0; i < array.length; i++) {
			array[i] = Utility.SCANNER.nextInt();
		}
		System.out.println("The array elements are:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] +" ");
		}
		System.out.println("\n Sum of triplets equal to zero are:");

		printTriplet(array);

	}
	
	/**
	 * @param array is for the user to enter array elements
	 * printTriplet() method finds distinct triplets such as a[i] + a[j] + a[k] = 0 and prints them
	 */
	public static void printTriplet(int[] array) {
		int number = array.length;
		boolean found = false;
		for(int i = 0; i < number - 2 ; i++) {
		      for(int j = i + 1; j < number - 1; j++) {
				   for(int k = j + 1; k < number; k++) {
				        if((array[i] + array[j] + array[k]) == 0) {
						  System.out.print(array[i] +" ");
						  System.out.print(array[j] +" ");
						  System.out.print(array[k]);
						  System.out.println();
						  found = true;
				        }
				}
			}
		}
		if(found == false) {  
			 System.out.println("Triplets do not exist!");
		    }
		}

}