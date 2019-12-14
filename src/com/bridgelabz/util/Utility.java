package com.bridgelabz.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * This class implements reusable functionalities like scanner method, prime number, factorial, palindrome,
 * leap year, anagram, read file, write to file, print date methods etc. 
 * @author Sunidhi Haldar
 * @created 2019-11-15
 * @version 13.0.1
 */

public class Utility {
	
	public static final Scanner SCANNER = new Scanner(System.in);
	
	//takes long input
	public static long longInput() {
		return SCANNER.nextLong();
	}
	
	//takes integer input
	public static int intInput() {
		return SCANNER.nextInt();
	}
	
	//takes String input
	public static String stringInput() {
		return SCANNER.next();
	}
	
	//takes boolean input
	public static boolean booleanInput() {
		return SCANNER.nextBoolean();
	}
	
	/**
	 * To find 2^power defined by user
	 * @param power as input parameter
	 * @return integer value
	 */
	
	public static int powerOfTwo(int power) {
		int result = 0;
		if(power >= 0) {
			result = (int) Math.pow(2, power); 
		}
		return result;
	}
	
	/**
	 * To read the file in String format from the file location
	 * @param filename is the location of the file
	 * @return String data from the file
	 */
	
	public static String readFile(String filename) {
		File file = new File(filename);
		Scanner scan = null;
		String data = "";
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) 
				data = data + scan.nextLine();	
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
//		finally {
//			scan.close();
//		}
		return data;
	}
	
	/**
	 * Takes String data and file location as input parameters and writes the data into the given file location
	 * @param data of string type
	 * @param filename is the location of the file
	 */
	
    public static void writeDataToFile(String data, String filename) {
    	File file = new File(filename);
		FileWriter writer = null;
		if(!file.exists()) {
			try {
				file.createNewFile();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer = new FileWriter(file);
			writer.write(data);
			writer.flush();
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
    
    /**
     * Checks if a 4-digit number is a leap year or not
     * @param year as input parameter of integer type
     * @return Boolean value
     */
    
    public static boolean isLeapYear(int year) {
    	if(year >= 1000 && year < 10000) {
    		if((year % 4 ==0 && year % 100 != 0) || year % 400 == 0) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	return false;
    }
    
    /**
     * Checks if a number is prime or not
     * @param number as input parameter of integer type
     * @return Boolean value
     */
    
    public static boolean isPrime(int number) {
    	if(number <= 0) {
    		return false;
    	}
    	else {
    		if(number == 1) {
    			return false;
    		}
    		else {
    			for(int divisor = 2; divisor <= number/2 ; divisor++) {
    				if(number % divisor == 0) {
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * Checks if two String values are anagram or not, like app and pap
     * @param firstString as input parameter of String type
     * @param secondString as input parameter of String type
     * @return Boolean value
     */
    
    public static boolean isAnagram(String firstString, String secondString ) {
    	char[] character1 = firstString.toLowerCase().trim().replaceAll(" ","").toCharArray();
    	char[] character2 = secondString.toLowerCase().trim().replaceAll(" ","").toCharArray();
    	if(character1.length != character2.length) {
    		return false;
    	}
    	else {
    		Arrays.sort(character1);
    		Arrays.sort(character2);
    		if(Arrays.equals(character1, character2)) {
    			System.out.println("Anagram");
    			return true;
    		}
    	}
        return false;
    }
    
    /**
     * Checks if two integer inputs are anagram or not, like 131 and 113
     * @param firstNumber as integer input parameter
     * @param secondNumber as integer input parameter
     * @return Boolean value
     */
    
    public static boolean isAnagram(int firstNumber, int secondNumber ) {
    	char[] character1 = Integer.toString(firstNumber).toCharArray();
    	char[] character2 = Integer.toString(secondNumber).toCharArray();
    	if(character1.length != character2.length) {
    		return false;
    	}
    	else {
    		Arrays.sort(character1);
    		Arrays.sort(character2);
    		if(Arrays.equals(character1, character2))
    			return true;
    	}
        return false;
    }
    
    /**
     * Checks if a String input is palindrome or not
     * @param inputString as integer input parameter 
     * @return Boolean value
     */
    
    public static boolean isPalindrome(String inputString) {
    	if(inputString.length() == 0) {
    		return false;
    	}
    	else {
    		String temporaryString = inputString;
    		char[] ch1 = inputString.toCharArray();
    		char[] ch2 = temporaryString.toCharArray();
    		System.out.println("Before:" +inputString);
    		int lastCharacter = ch1.length - 1;
    		for(int i = 0; i < ch1.length / 2; i++) {
    			char temporary = ch1[i];
    			ch1[i] = ch1[lastCharacter - i];
    			ch1[lastCharacter - i] = temporary;
    		}
    		if(Arrays.equals(ch1, ch2))
    			return true;
    		else
    			return false;
    	}
    }
    
    /**
     * Takes input parameter date in String format and returns date in Date format 
     * @param date as String format
     * @return date
     */
    
    public static Date printDate(String date) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    	try {
    		return dateFormat.parse(date);
    	}
    	catch(ParseException e) {
    		return null;
    	}
    }
    
    /**
     * Takes date as input and return formatted date
     * @param date as String input parameter
     * @return date
     */
    
    public static String getFormatedDate(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	return sdf.format(date);
    }
    
    /**
     * Gives the factorial of a number
     * @param number as input integer parameter
     * @return integer value
     */
    
    public static int factorial(int number) {
    	int factorial = 1;
    	if(number == 0)
    		return 0;
    	else {
    		while(number > 1) {
    			factorial = factorial * number;
    			number--;
    		}
    		return factorial;
    	}
    }
    
    /**
     * To reverse the String value
     * @param stringVariable as input parameter of String type
     * @return String reversed input value
     */
    
    public static String reverseString(String stringVariable) {
    	String reverse = "";
    	if(!stringVariable.isEmpty()) {
    		for(int i = stringVariable.length() - 1; i >= 0; i--) {
    			reverse += stringVariable.charAt(i);
    		}
    	}
    	return reverse;
    }

}
