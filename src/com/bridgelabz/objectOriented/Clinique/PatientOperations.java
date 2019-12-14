package com.bridgelabz.objectOriented.Clinique;

import java.util.ArrayList;

import com.bridgelabz.util.Utility;

public class PatientOperations implements PatientOperationsInterface {

	ArrayList<Patient> patientList;

	public PatientOperations() {
		this.patientList = new ArrayList<Patient>();
	}
	
	
	@Override
	public void registerPatient() {
		System.out.println("Enter ID");
		int id = Utility.intInput();
		System.out.println("Enter name:");
		String name = Utility.SCANNER.next();
		System.out.println("Enter mobile number:");
		long mobileNumber = Utility.longInput();
		System.out.println("Enter age:");
		int age = Utility.intInput();
		Patient newPatient = Patient.newPatient(id, name, mobileNumber, age);
		if(addNewPatient(newPatient))
			System.out.println("New patient added");
		else
			System.out.println("Patient name exists");
		
	}
	
	public int findPatient(int id) {
		for(int i = 0; i < patientList.size(); i++) {
			Patient fetchedId = this.patientList.get(i);
			if(fetchedId.getPatientId() == id)
				return i;
		}
		return -1;
	}
	
	public int findPatient(String name) {
		for(int i = 0; i < patientList.size();) {
			Patient fetchedName = this.patientList.get(i);
			if(fetchedName.getPatientName().equals(name));
				return i;
		}
		return -1;
	}
	
	public int findPatient(long mobileNumber) {
		for(int i = 0; i < patientList.size(); i++) {
			Patient fetchedMobileNumber = this.patientList.get(i);
			if(fetchedMobileNumber.getPatientMobileNumber() == mobileNumber)
				return i;
		}
		return -1;
	}
	
	public int findPatient(Patient patient) {
		return this.patientList.indexOf(patient);
	}
	
	@Override
	public boolean addNewPatient(Patient patient) {
		if(findPatient(patient.getPatientId()) >= 0) {
			System.out.println("Patient already exists");
			return false;
		}
		else {
			patientList.add(patient);
			return true;
		}
	}
	
	@Override
	public void printingPatientDetails() {
		System.out.println("Patient list:");
		for(int i = 0; i < patientList.size(); i++) {
			System.out.println((i + 1) + ". " + "Patient Id: " + patientList.get(i).getPatientId() +
					"\nPatient Name: " + patientList.get(i).getPatientName() + 
					"\nPatient Mobibe Number: " + patientList.get(i).getPatientMobileNumber() + 
					"\nPatient Age:" + patientList.get(i).getPatientAge());
		}
	}

	@Override
	public boolean updatePatientDetails(Patient oldPatient, Patient newPatient) {
		int findPosition = findPatient(oldPatient);
		if(findPosition < 0) 
			System.out.println(oldPatient.toString() + " does not exist");
		this.patientList.set(findPosition, newPatient);
		System.out.println(oldPatient.getPatientName() + " updated");
		return true;
		
	}

	@Override
	public String searchPatient(Patient patient) {
		if(findPatient(patient) >= 0)
			return patient.toString();
		return null;
	}

	@Override
	public Patient searchPatient(String patientName) {
		int position = findPatient(patientName);
		if(position >= 0)
			return this.patientList.get(position);
		return null;
	}

	@Override
	public Patient searchPatient(int id) {
		int position = findPatient(id);
		if(position >= 0)
			return this.patientList.get(position);
		return null;
	}

	@Override
	public Patient searchPatient(long mobileNumber) {
		int position = findPatient(mobileNumber);
		if(position >= 0)
			return this.patientList.get(position);
		return null;
	}

	@Override
	public boolean deletePatientDetails(Patient patient) {
		int findPosition = findPatient(patient);
		if(findPosition < 0) {
			System.out.println(patient.toString() + " was not found");
			return false;
		}
		this.patientList.remove(findPosition);
		System.out.println(patient.getPatientName() + " is deleted");
		return true;
	}
	
}
