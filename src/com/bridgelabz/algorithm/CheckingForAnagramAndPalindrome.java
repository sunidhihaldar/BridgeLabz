package com.bridgelabz.algorithm;

import com.bridgelabz.util.Utility;

public class CheckingForAnagramAndPalindrome extends PrimeNumbersRange {

	public static void main(String[] args) {
		System.out.println("Enter the lower limit of the range");
		int lowerLimit = Utility.intInput();
		System.out.println("Enter the upper limit of the range");
		int upperLimit = Utility.intInput();
		Utility.SCANNER.close();
		System.out.println("Numbers are:");
		for(int number = lowerLimit; number <= upperLimit; number++) {
			if(Utility.isPrime(number)) {
				String stringNumber = Integer.toString(number);
				if(Utility.isPalindrome(stringNumber)) {
					if(Utility.isAnagram(stringNumber, Utility.reverseString(stringNumber))) {
						System.out.println(Integer.parseInt(stringNumber));
					}
				}
			}
	    }
	}
}