package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Utility;
import com.bridgelabz.dataStructure.Deque;

/**
 * User gives a String as input and fetch all characters and transfer them to a Dequeue 
 * genric type and fetch first character and last characters checks for equality conitnues
 * till last 2 charcters remains in the Dequeue. If all removal characters of first and last
 * equalize then the input string is palindrome.
 * 
 * @author Sunidhi Haldar
 * @created 2019-11-26
 * @version 13.0.1
 */

public class PalindromeChecker {
	static Deque<Character> deque = new Deque<Character>();
	
	/**
	 * It deletes first and last character and continues till 2 characters remains on the
	 * String. If both removal characters matches then it returns boolean value
	 * @return Boolean value
	 */
	
	public static boolean palindromeChecker() {
		boolean isMatching = false;
		while(deque.size() > 1) {
			if(deque.deleteFirst() == deque.deleteLast())
				isMatching = true;
		}
		return isMatching;
	}

	public static void main(String[] args) {
		System.out.println("Enter a String");
		String inputString = Utility.SCANNER.nextLine();
		
		// each character is fetched and added to the list of Dequeue
		for(int i = 0; i < inputString.length(); i++) {
			char character = inputString.charAt(i);
			deque.addLast(character);
		}
		if(palindromeChecker())
			System.out.println(inputString + " is a palindrome");
		else
			System.out.println(inputString +" is not a palindrome");

	}

}
