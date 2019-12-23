package com.bridgelabz.objectOriented.Clinique.Model;

public class Patient {

	private int patientId;
	private String patientName;
	private long patientMobileNumber;
	private int patientAge;
	//private String disease;
	
	public Patient(int patientId, String patientName, long patientMobileNumber, int patientAge) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientMobileNumber = patientMobileNumber;
		this.patientAge = patientAge;
		//this.disease = disease;
	}

	public int getPatientId() {
		return patientId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}
	
	public void setName(String patientName) {
		this.patientName = patientName;
	}

	public long getPatientMobileNumber() {
		return patientMobileNumber;
	}
	
	public void setPatientMobileNumber(long patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}
	
	public int getPatientAge() {
		return patientAge;
	}
	
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
//	public String getDisease() {
//		return disease;
//	}

	public static Patient newPatient(int patientId, String patientName, long patientMobileNumber, int patientAge) {
		return new Patient(patientId, patientName, patientMobileNumber, patientAge);
	}
	
	public String toString() {
		return "Patient ID:" + this.patientId + "\nPatient Name:" + this.patientName 
				+ "\nPatient Mobile Number:" + this.patientMobileNumber 
				+ "\nPatient Age:" + this.patientAge;
	}
}
