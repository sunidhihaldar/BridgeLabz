package com.bridgelabz.functional;

import com.bridgelabz.util.Utility;

/**
 * A program to find distance between the point(x,y) to the origin(0,0)
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class Distance {

	public static void main(String[] args) {
		System.out.println("Enter the value of x1 and y1:");
		int x1 = Utility.SCANNER.nextInt();
		int y1 = Utility.SCANNER.nextInt();
		printEuclideanDistance(x1,y1);
		}
	
	/**
	 * @param x1 takes the  value of the point x1
	 * @param y1 takes the value of the point x2
	 * The method is  used to print Euclidean Distance of 2 points
	 * @param disrance stores the value of the Euclidean Distance of 2 points
	 */
	public static void printEuclideanDistance(int x1,int y1) {
		int x2 = 0, y2 = 0;
		double d1 = Math.pow(x1-x2, 2);
		double d2 = Math.pow(y1-y2, 2);
		double distance = Math.sqrt(d1 + d2);
		System.out.println("The Euclidean distance from (x1,y1) to the origin(0,0)=" +distance);
	}
}
