package com.bridgelabz.objectOriented.Clinique.Controller;

import com.bridgelabz.objectOriented.Clinique.Service.ICliniqueSer;
import com.bridgelabz.objectOriented.Clinique.ServiceImplementation.CliniqueOperation;
import com.bridgelabz.util.Utility;

/**
 * Implementation of the Clinic management System.
 * 
 * @author Sunidhi Haldar
 * @created 2019-12-19
 * @version 13.0.1
 */

public class Implementation {
	
	private static ICliniqueSer service = new CliniqueOperation();

	public static void main(String[] args) {
        System.out.println("Welcome to Asia hospital\n-----------------------------");
		printInstructions();
		boolean isQuit = false;
		while (!isQuit) {
		System.out.println("\nEnter action:");
		int action = Utility.intInput();
		switch(action) {
        case 1:
        	// add doctor
        	service.addDoctor();
			break;
		case 2:
			// search available doctors and book appointment
			searchDoctorAndBookAppointment();
			break;
		case 3:
			// search patient details
			searchPatientDetails();
			break;
        case 4:
        	// print instructions
			printInstructions();
			break;
		case 5:
			// quit application
			System.out.println("Thank you visit again...");
			isQuit = true;
			break;
		case 6:
			service.printDoctorList();
					// print all doctor list
			break;
		case 7:
			service.printPatientList();
					// print all patient list
			break;
		default:
			System.out.println("please read instrutions!");
			}
		}
	}

	//Instructors displayed to the user to use the application
	public static void printInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> add doctor to list. \n" + "\t2 -> Book Appointment.\n"
				+ "\t3 -> Search patient details\n" + "\t4 -> print instructions.\n" + "\t5 -> Quit the application\n"
				+ "\t6 -> print doctor List associated with hospital\n"
				+ "\t7 -> print patient List associated with hospital\n");
		System.out.println("choose your action :");
	}

	/**
	* This function allows the user to search doctor on the basis of name, id,
	* specialization,availability. if found then proceed with appointment
	* procedure.
	*/
	public static void searchDoctorAndBookAppointment() {
		System.out.println("press to search by : 1 -> name, 2 -> id 3 -> specialization");
		System.out.println("please Enter your choice");
		int choice = Utility.intInput();
		switch (choice) {
		case 1:
			// search by name
			System.out.println("Please Enter Doctor name :");
			String docName = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			service.searchDoctorBookAppointment("name", docName);
			break;
		case 2:
			// search by id
			System.out.println("Please Enter Doctor id :");
			String docId = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			service.searchDoctorBookAppointment("id", docId);
			break;
		case 3:
			// search by specialization
			System.out.println("Please Enter Doctor specialization :");
			String docSpecialization = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			service.searchDoctorBookAppointment("specialization", docSpecialization);
			break;
		default:
			System.out.println("Please follow instructions...");
			break;
		}
	}

	/**
	* This function allows the user to search patients on the basis of name, id,
	* phone number if found then display all information of that patient.
	*/
	public static void searchPatientDetails() {
		System.out.println("press to search by : 1 -> name, 2 -> id, 3 -> mobileNumber ");
		System.out.println("please Enter your choice");
		int choice = Utility.intInput();
		switch(choice) {
		case 1:
			// search by name
			System.out.println("Please Enter Patient name :");
			String patName = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			service.readPatientDetails("name", patName);
			break;
		case 2:
			// search by id
			System.out.println("Please Enter patient id :");
			String patId = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			service.readPatientDetails("id", patId);
			break;
		case 3:
			// search by id
			System.out.println("Please Enter patient mobile Number :");
			String mobile = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			service.searchDoctorBookAppointment("mobile", mobile);
			break;
		default:
			System.out.println("Please follow instructions...");
			break;
		}
	}
}
