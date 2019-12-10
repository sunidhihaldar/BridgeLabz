package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Utility;

/**
 * Initialize the calendar with all negative values and based on starting day
 * position it assign the values by checking Necessary conditions. User gives
 * the input as month and year and based on the conditions it prints the calendar
 * of that particular month.
 * 
 * @author Sunidhi Haldar
 * @created 2019-11-27
 * @version 13.0.1
 */
public class Calender {
	/**
	 * @Array calendar initialize rows and columns which is to be displayed
	 * @Array month to initialize number of days in months
	 */
	private int[][] calender = new int[5][7];
	private int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/**
	 * Initializing whole calendar with negative value for easier formatting.
	 */
	private void initialLinesOfCalender() {
		for (int i = 0; i < calender.length; i++) {
			for (int j = 0; j < calender[i].length; j++) {
				calender[i][j] = -1;
			}
		}
	}

	/**
	 * Display the formatted calendar
	 * 
	 * @param year  as input integer parameter
	 * @param month as input integer parameter
	 */
	
	private void display(int year, int month) {
		System.out.println("	Sun	Mon	Tue	Wed	Thu	Fri	Sat");

		for (int i = 0; i < calender.length; i++) {
			for (int j = 0; j < calender[i].length; j++) {
				if (calender[i][j] < 0 || calender[i][j] > monthArray[month - 1]) {
					System.out.print("\t ");
				} else if (calender[i][j] > 0) {
					System.out.print("\t" + calender[i][j] + " ");
				}
			}
			System.out.println("\t");
		}
	}

	/**
	 * checks the calendar assigned places and put formatted newly assigned data as
	 * per starting day of week till end day
	 * 
	 * @param startingDayPosition as integer input parameter
	 */
	private void putCalender(int startingDayPosition, int year) {
//		System.out.println("starting" + startingDayPosition);
		int startDay = 1;
		/**
		 * checks leap year and if found leap year then change to 29
		 */
		if (Utility.isLeapYear(year)) {
			monthArray[1] = 29;
		}

		/**
		 * @code placing the values of firstLine of calendar
		 */
		for (int i = startingDayPosition; i < calender[0].length; i++) {
			calender[0][i] = startDay++;
		}
		/**
		 * @code placing the values of remaining lines of calendar
		 */
		for (int i = 1; i < calender.length; i++) {
			for (int j = 0; j < calender[i].length; j++) {
				calender[i][j] = startDay++;
			}
		}

	}

	/**
	 * Takes month and year as parameter and return start day of week as integer
	 * value.
	 * 
	 * @param m as month integer parameter
	 * @param y as year integer parameter
	 * @return Integer value
	 */
	private int dayOfWeek(int m, int y) {
		int d = 1;
		int y0 = y - (14 - m) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = m + 12 * ((14 - m) / 12) - 2;
		int d0 = (d + x + (31 * m0) / 12) % 7;
		return d0;
	}

	/**
	 * Prints calender
	 * @param month as integer value.
	 * @param year  as integer value.
	 */
	public void dispCalender(int month, int year) {
		int startDayOfWeek = dayOfWeek(month, year);
//		System.out.println("d -> " + startDayOfWeek);
		initialLinesOfCalender();
		putCalender(startDayOfWeek, year);
		display(year, month);

	}

	public static void main(String[] args) {
		Calender calender = new Calender();
		System.out.println("Please enter month value in between range [1 -> 12]");
		System.out.println("Enter month in Integer value :");
		int inputMonth = Utility.intInput();
		System.out.println("Enter year :");
		int inputYear = Utility.intInput();
		calender.dispCalender(inputMonth, inputYear);

	}

}
