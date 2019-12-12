package com.bridgelabz.objectOriented.Clinique;

public class Patient {

	private int patientId;
	private String patientName;
	private long patientMobileNumber;
	private int patientAge;
	
	public Patient(int patientId, String patientName, long patientMobileNumber, int patientAge) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientMobileNumber = patientMobileNumber;
		this.patientAge = patientAge;
	}

	public int getPatientId() {
		return patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public long getPatientMobileNumber() {
		return patientMobileNumber;
	}
	
	public int getPatientAge() {
		return patientAge;
	}
	
	public static Patient newPatient(int patientId, String patientName, long patientMobileNumber, int patientAge) {
		return new Patient(patientId, patientName, patientMobileNumber, patientAge);
	}
	
	public String toString() {
		return "Patient ID:" + this.patientId + "\nPatient Name:" + this.patientName 
				+ "\nPatient Mobile Number:" + this.patientMobileNumber + "\nPatient Age:" + this.patientAge;
	}
}
