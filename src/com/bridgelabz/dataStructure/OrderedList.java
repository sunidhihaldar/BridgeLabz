package com.bridgelabz.dataStructure;

import com.bridgelabz.dataStructure.ImplementingLinkedList;
import com.bridgelabz.util.Sorting;
import com.bridgelabz.util.Utility;

/**
 * This program reads the data from a source file and arranges the data in ascending order.
 * It asks the user to enter a number . If the user input number is found in the list then
 * delete the number, if not found the inserts the number to the list.
 * 
 * @author Sunidhi Haldar
 * created 2019-11-30
 * @version 13.0.1
 */

public class OrderedList {
	static ImplementingLinkedList<Integer> list = new ImplementingLinkedList<Integer>();

	/**
	 * This method does the operation as per user input. If data present, deletes the data and
	 * if data not prsent adds the data
	 * 
	 * @param number as input by the user for operation
	 * @param list Linked List for storing data
	 */
	
	public static void addRemoveOperation(int number, ImplementingLinkedList<Integer> list) {
		if(list.search(number)) {
			list.deleteData(number);
			System.out.println(number + "found and successfully deleted");
		}
		else {
			list.insert(number);
			System.out.println(number + " not found and successfully added");
		}
	}
	
	/**
	 * Converts String array to integer array 
	 * @param stringArray as input parameter
	 * @return integer array
	 */
	
	public static int[] convertingStringToInteger(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for(int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		Sorting.insertionSort(intArray);
		return intArray;
	}
	
	/**
	 * Takes integer array and converts into linked list
	 * 
	 * @param intArray as input to be converted in the linked list
	 * @return linked list
	 */
	
	public static ImplementingLinkedList<Integer> convertingArrayToList(int[] intArray) {
		for(Integer data : intArray) {
			list.insert(data);
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		// collected data stored in string array
		String[] stringArray = Utility.readFile("C:\\Users\\SONY\\Desktop\\list1.txt").split(",");
		int[] intArray = convertingStringToInteger(stringArray);
		convertingArrayToList(intArray);
		System.out.println("List lenght:" + list.length() + "\nCurrent List\n----------------------");
		list.print();
		System.out.println("Enter data");
		int operationalData = Utility.intInput();
		addRemoveOperation(operationalData, list);
		list.print();

	}

}
