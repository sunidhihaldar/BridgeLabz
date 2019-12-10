package com.bridgelabz.functional;

import com.bridgelabz.util.Utility;

/**
 * A program to find the effective temperature i.e. WindChill 
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class WindChill {

	public static void main(String[] args) {
		System.out.println("Enter the value of temperature");
		double temperature = Utility.SCANNER.nextDouble();
		System.out.println("Enter the value of speed");
		double speed = Utility.SCANNER.nextDouble();
		printWindChill(temperature,speed);
		}
	
	/**
	 * @param temperature takes the user input for temperature in Farhrenheit
	 * @param speed takes the user input for speed in miles per hour
	 * @param windchill defines the effective temperature
	 */
	public static void printWindChill(double temperature, double speed) {
		if(! (temperature > Math.abs(50) || speed > 150 || speed <3 )) {
		double windchill = 35.74 + 0.6215 + (0.4275 * temperature - 35.75) * Math.pow(speed, 0.16);
		System.out.println("The wind chill is:" +windchill);
		}
		else {
			System.out.println("Not valid");
		}
	}

}