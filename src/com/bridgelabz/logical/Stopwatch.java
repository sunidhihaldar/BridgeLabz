package com.bridgelabz.logical;

import com.bridgelabz.util.Utility;

/**
 * A program that defines a stopwatch
 * @author Sunidhi Haldar
 * created 15.11.19
 * @version 13.0.1
 */

public class Stopwatch {
    
	// @param start defines the time at which stopwatch starts 
	private static long start;
	
	// @param end defines the time at which stopwatch stops
	private static long end;
    
	// start() method starts the stopwatch
	public void start() {
		start = System.currentTimeMillis();
	}
    
	// stop() method stops the stopwatch
	public void end() {
		end = System.currentTimeMillis();

	}
    
	/**
	 * elapsedTime() method is used for measuring the time that elapses between the start and end clicks
	 * @param elapsedTime defines the elapsed time between the start and stop of a stopwatch  
	 */
	public void elapsedTime() {
		try {
		Thread.sleep(8000);
		}
		catch(InterruptedException e) {
			System.out.println("Tick Tick...");
		}
		long elapsedTime = (long) ((end - start) / 1000);
		System.out.println(elapsedTime);

	}

	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();
		System.out.println(
				"Enter your choice: \n 1.Start Stopwatch 2.End Stopwatch 3.Elapsed Time in milliseconds 4.Elapsed Time in seconds");
		int choice = Utility.intInput();
		switch (choice) {
		case 1:
			System.out.println("Stopwatch has started....");
			timer.start();
			break;
		case 2:
			System.out.println("Stopwatch has ended!");
			timer.end();
			break;
		case 3:
			System.out.println(end - start + "ms");
			break;
		case 4:
			timer.elapsedTime();
			System.out.print("s");
			break;
		default:
			System.out.println("Invalid case");
		}
	}
}