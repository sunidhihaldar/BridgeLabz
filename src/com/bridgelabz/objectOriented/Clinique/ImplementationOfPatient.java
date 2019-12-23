package com.bridgelabz.objectOriented.Clinique;

import com.bridgelabz.objectOriented.Clinique.Model.Patient;
import com.bridgelabz.objectOriented.Clinique.Service.PatientOperationsInterface;
import com.bridgelabz.util.Utility;

public class ImplementationOfPatient {

	static PatientOperationsInterface poi = new PatientOperations();
	
	public static void addNewPatient() {
		poi.registerPatient();
	}
	
	public static void updatePatient() {
		System.out.println("Enter existing patient name");
		String existigPatientName = Utility.SCANNER.next();
		Patient existingPatientInRecord = poi.searchPatient(existigPatientName);
		if(existingPatientInRecord == null) {
			System.out.println("Patient name not found");
			return;
		}
		String patientName = existingPatientInRecord.getPatientName();
		System.out.println("Enter id");
		int id = Utility.intInput();
		System.out.println("Enter mobile number");
		long mobileNumber = Utility.longInput();
		System.out.println("Enter age");
		int age = Utility.intInput();
		
		Patient newPatientDetail = Patient.newPatient(id, patientName, mobileNumber, age);
	    if(poi.updatePatientDetails(existingPatientInRecord, newPatientDetail))
	    	System.out.println("Patient details updated");
	    else
	    	System.out.println("Patient details updating error");
	}
	
	public static void deletePatient() {
		System.out.println("Enter the name of patient you want to delete");
		String existingPatientName = Utility.SCANNER.next();
		Patient existingPatientInRecord = poi.searchPatient(existingPatientName);
		if(existingPatientInRecord == null) {
			System.out.println("Patient name not found");
			return;
		}
		
		if(poi.deletePatientDetails(existingPatientInRecord))
	    	System.out.println("Patient details deleted");
	    else
	    	System.out.println("Patient details error deleting");
	}
	
	public static void searchDetailsOfPatientByName() {
		System.out.println("Enter the name of patient you want to search");
		String patientName = Utility.SCANNER.next();
		Patient existingPatientInRecord = poi.searchPatient(patientName);
		if(existingPatientInRecord == null) {
			System.out.println("Patient name not found");
			return;
		}
		
		System.out.println("Patient Id: " + existingPatientInRecord.getPatientId() +
				"\nPatient Name: " + existingPatientInRecord.getPatientName() +
				"\nMobibe Number: " + existingPatientInRecord.getPatientMobileNumber() + 
				"\nAge:" + existingPatientInRecord.getPatientAge());
	}
	
	public static void searchDetailsOfPatientById() {
		System.out.println("Enter the id of patient you want to search");
		int patientId = Utility.intInput();
		Patient existingPatientInRecord = poi.searchPatient(patientId);
		if(existingPatientInRecord == null) {
			System.out.println("Patient id not found");
			return;
		}
		
		System.out.println("Patient Id: " + existingPatientInRecord.getPatientId() +
				"\nPatient Name: " + existingPatientInRecord.getPatientName() +
				"\nMobibe Number: " + existingPatientInRecord.getPatientMobileNumber() + 
				"\nAge:" + existingPatientInRecord.getPatientAge());
	}
	
	public static void searchDetailsOfPatientByMobileNumber() {
		System.out.println("Enter the mobile number of patient you want to search");
		long patientMobileNumber = Utility.longInput();
		Patient existingPatientInRecord = poi.searchPatient(patientMobileNumber);
		if(existingPatientInRecord == null) {
			System.out.println("Patient mobile number not found");
			return;
		}
		
		System.out.println("Patient Id: " + existingPatientInRecord.getPatientId() +
				"\nPatient Name: " + existingPatientInRecord.getPatientName() +
				"\nMobibe Number: " + existingPatientInRecord.getPatientMobileNumber() + 
				"\nAge:" + existingPatientInRecord.getPatientAge());
	}
	
	public static void patientOperations() {
		System.out.println("Options:");
		System.out.println("1. Add new patient \n2. Update existing patient details \n3. Remove existing patient"
				+ "\n4. Search for a patient by name \n5. Search for a patient by id" 
				+ "\n6.Search for a patient by mobile number" + "\n7. Print patient details \n8. Quit the application");
	    boolean exit = false;
	    while(!exit) {
	    	System.out.println("Choose an option:");
            int choice = Utility.intInput();
            switch(choice) {
            case 1:
            	addNewPatient();
            	break;
            case 2:
            	updatePatient();
            	break;
            case 3:
            	deletePatient();
            	break;
            case 4:
            	searchDetailsOfPatientByName();
            	break;
            case 5:
            	searchDetailsOfPatientById();
            	break;
            case 6:
            	searchDetailsOfPatientByMobileNumber();
            	break;
            case 7:
            	poi.printingPatientDetails();
            case 8:
            	exit = true;
            	System.out.println("Thank You");
            	break;
            default:
            	System.out.println("Invalid option");
            }
	    }

	}
	
}
