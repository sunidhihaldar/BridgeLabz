package com.bridgelabz.objectOriented.Clinique;

public interface PatientOperationsInterface {

	void registerPatient();
	
	boolean addNewPatient(Patient patient);
	
	boolean updatePatientDetails(Patient oldPatient, Patient newPatient);
	
	String searchPatient(Patient patient);
	
	Patient searchPatient(String patientName);
	
	Patient searchPatient(int id);
	
	Patient searchPatient(long mobileNumber);
	
	boolean deletePatientDetails(Patient patient);

	void printingPatientDetails();
	
}
