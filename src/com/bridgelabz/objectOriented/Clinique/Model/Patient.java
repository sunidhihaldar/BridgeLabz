package com.bridgelabz.objectOriented.Clinique.Model;

public class Patient {

	private int patientId;
	private String patientName;
	private long patientMobileNumber;
	private int patientAge;
	//private String disease;
	
	public Patient() {
		super();
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
	
	public void setPatientName(String patientName) {
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

}
