package com.bridgelabz.objectOriented.Clinique;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

public class Doctor {

	private int doctorId;
	private String doctorName;
	private String specilaization;
	//private String availability;
	LocalTime availability = LocalTime.now();
	String pattern = "hh:mm:ss a";
	
	public Doctor(int doctorId, String doctorName, String specilaization, LocalTime availability) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specilaization = specilaization;
		this.availability = availability;
		System.out.println(availability.format(DateTimeFormatter.ofPattern(pattern)));
	}

	public int getDoctorId() {
		return doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getSpecilaization() {
		return specilaization;
	}

	public LocalTime getAvailability() {
		return availability;
	}

	public static Doctor newDoctor(int doctorId, String doctorName, String specialization, LocalTime availability) {
		return new Doctor(doctorId, doctorName, specialization, availability);
	}
	
	public String toString() {
		return "Doctor Id:" + this.doctorId + "\nDoctor Name:" + this.doctorName 
				+ "\nDoctor specialization:" + this.specilaization + "\nAvailability:" + this.availability;
	}
	
}