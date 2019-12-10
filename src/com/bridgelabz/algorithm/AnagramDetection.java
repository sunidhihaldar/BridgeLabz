package com.bridgelabz.algorithm;

import com.bridgelabz.util.Utility;

public class AnagramDetection {

	public static void main(String[] args) {
		System.out.println("Enter any 2  strings:");
		String string1 = Utility.SCANNER.nextLine();
		String string2 = Utility.SCANNER.nextLine();
		Utility.SCANNER.close();
		if(Utility.isAnagram(string1, string2))
			System.out.println("Anagram");
		else
			System.out.println("Not anagram");

	}

}
