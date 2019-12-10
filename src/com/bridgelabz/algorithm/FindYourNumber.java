package com.bridgelabz.algorithm;

import java.util.Random;

import com.bridgelabz.util.Utility;

public class FindYourNumber {

	public static int thinkNumberInRange(int lowerLimit, int upperLimit) {
		Random random = new Random();
		int userInput = random.nextInt(upperLimit - lowerLimit) + lowerLimit;
		return userInput;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter lower positive range");
		int lowerLimit = Utility.intInput();
		System.out.println("Enter higher positive range");
		int upperLimit = Utility.intInput();
		int userInput = thinkNumberInRange(lowerLimit, upperLimit);
		System.out.println(userInput);
		long powerOfTwo = (long) Utility.powerOfTwo(userInput);
		System.out.println("2 ^ " + userInput + " is " + powerOfTwo);
		
		
	}
	
}