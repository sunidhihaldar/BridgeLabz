package com.bridgelabz.objectOriented.Clinique.Model;

public class Doctor {

	private String doctorId;
	private String doctorName;
	private String specilaization;
	private String availability;
	private long patientCount;
//	LocalDateTime time = LocalDateTime.now();
//	String pattern = "hh:mm:ss a";
	
	public Doctor() {
		super();
		//System.out.println(time.format(DateTimeFormatter.ofPattern(pattern)));
	}

	public String getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecilaization() {
		return specilaization;
	}

	public void setSpecilaization(String specilaization) {
		this.specilaization = specilaization;
	}
	
//	public LocalDateTime getTime() {
//		return time;
//	}
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public long getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(long patientCount) {
		this.patientCount = patientCount;
	}
	
	public String toString() {
		return "Doctor Id:" + this.doctorId + "\nDoctor Name:" + this.doctorName 
				+ "\nDoctor specialization:" + this.specilaization + "\nAvailability:" + this.availability;
	}
	
}