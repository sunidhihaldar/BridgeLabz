package com.bridgelabz.functional;

import com.bridgelabz.util.Utility;

/**
 * A program to find the roots of the equation a*x*x + b*x +c
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class Quadratic {

	public static void main(String[] args) {
		System.out.println("Enter the value of a, b and c:");
		int a = Utility.SCANNER.nextInt();
		int b = Utility.SCANNER.nextInt();
		int c = Utility.SCANNER.nextInt();
	    quadraticMethod(a,b,c);	
	}
	
	/**
	 * @param a takes user input value of a from the equation a*x*x + b*x +c
	 * @param b takes user input value of b from the equation a*x*x + b*x +c
	 * @param c takes user input value of c from the equation a*x*x + b*x +c
	 * @param root1 stores the result of the first root
	 * @param root2 stores the result of the second root
	 */
	public static void quadraticMethod(int a,int b,int c) {
		double delta = Math.abs(b*b-4*a*c);
		double root1 = (-b + Math.sqrt(delta))/(2*a);
		double root2 = (-b - Math.sqrt(delta))/(2*a);
		System.out.println("Roots of the equation " +a+ "x*x +" +b+ "x +" +c+ ":\nRoot1=" +root1+ " Root2="+root2);
	}

}
