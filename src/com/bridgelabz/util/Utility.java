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

public class Utility {
	
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static long longInput() {
		return SCANNER.nextLong();
	}
	
	public static int intInput() {
		return SCANNER.nextInt();
	}
	
	public static String stringInput() {
		return SCANNER.next();
	}
	
	public static boolean booleanInput() {
		return SCANNER.nextBoolean();
	}
	
	public static int powerOfTwo(int power) {
		int result = 0;
		if(power >= 0) {
			result = (int) Math.pow(2, power); 
		}
		return result;
	}
	
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
	
    public static void writeToFile(String data, String filename) {
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
    
    public static boolean isAnagram(String firstString, String secondString ) {
    	char[] character1 = firstString.toLowerCase().trim().replaceAll(" "," ").toCharArray();
    	char[] character2 = secondString.toLowerCase().trim().replaceAll(" "," ").toCharArray();
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
    
    public static Date printDate(String date) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    	try {
    		return dateFormat.parse(date);
    	}
    	catch(ParseException e) {
    		return null;
    	}
    }
    
    public static String getFormatedDate(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	return sdf.format(date);
    }
    
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
    
    public static String reverseString(String string) {
    	String reverse = "";
    	if(!string.isEmpty()) {
    		for(int i = string.length() - 1; i >= 0; i--) {
    			reverse += string.charAt(i);
    		}
    	}
    	return reverse;
    }

}
