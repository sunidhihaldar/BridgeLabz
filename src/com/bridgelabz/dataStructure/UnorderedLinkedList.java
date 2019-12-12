package com.bridgelabz.dataStructure;

import com.bridgelabz.dataStructure.ImplementingLinkedList;
import com.bridgelabz.util.Utility;

/**
 * This program reads the file from a source and splits it on the basis of comma and transfers
 * all data to the linked list of generic type and some deletion options are done.
 *   
 * @author Sunidhi Haldar
 * @created 2019-11-28
 * @version 13.0.1
 */

public class UnorderedLinkedList {

	public static void main(String[] args)  {
		ImplementingLinkedList<String> list = new ImplementingLinkedList<String>();
		String[] array = Utility.readFile("C:\\Users\\SONY\\Desktop\\hello.txt").split(",");
		for(String string : array )
			list.insert(string);
		list.print();
		System.out.println("Insert string data for insertion operation");
		String inputData = Utility.stringInput();
		list.insert(inputData);
		System.out.println("Insert string data for insertion operation and position");
		list.insert(Utility.stringInput(),Utility.intInput());
		System.out.println(list.length());
		System.out.println(list.printString());
		Utility.writeDataToFile(list.printString(), "C:\\Users\\SONY\\Desktop\\helloOutput.txt");
	}

}
