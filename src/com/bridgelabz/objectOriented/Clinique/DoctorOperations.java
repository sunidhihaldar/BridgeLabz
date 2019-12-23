package com.bridgelabz.objectOriented.Clinique;

//import java.util.ArrayList;
//import java.util.Random;
//import org.json.simple.JSONSArray;
//import com.bridgelabz.objectOriented.Clinique.Model.Doctor;
//import com.bridgelabz.util.Utility;

public abstract class DoctorOperations {

//	ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
//	private static final String PATH_DOCTOR = "doctor.json";
//	//private static JSONArray globalArray = new JSONArray();
//	private static Random random = new Random();
//	
//	public boolean addNewDoctor(Doctor doctor) {
//		JSONObject doctorObject = new JSONObject();
//		if(JsonUtil.readJSONArray(PATH_DOCTOR) != null) {
//			globalArray = JsonUtil.readJsonArray(PATH_DOCTOR);
//		}
//		Doctor newDoctor = new Doctor();
//		System.out.println("Enter the doctor details\n");
//		System.out.println("Enter doctor's name");
//		String doctorName = Utility.SCANNER.nextLine();
//		newDoctor.setDoctorName(doctorName);
//		System.out.println("Enter doctor's id");
//		String doctorId = doctorIdGenerate();
//		newDoctor.setDoctorId(doctorId);
//		System.out.println("Enter doctor's specialization ");
//		String specilaization = Utility.SCANNER.next();
//		newDoctor.setSpecilaization(specilaization);
//		System.out.println("Availability of the doctor");
//		System.out.println("Choose option: 1. am   2. pm");
//		int choice = Utility.intInput();
//		String availability = doctorAvailability(choice);
//		newDoctor.setAvailability(availability);
//		newDoctor.setPatientCount(0);
//		doctorObject.put("name", newDoctor.getDoctorName());
//		doctorObject.put("id", newDoctor.getDoctorId());
//		doctorObject.put("specialization", newDoctor.getSpecilaization());
//		doctorObject.put("availability", newDoctor.getAvailability());
//		doctorObject.put("patientCount", newDoctor.getPatientCount());
//		if(globalArray.add(doctorObject)) {
//			JsonUtil.writeDataToJSONArray(PATH_DOCTOR, globalJsonArray);
//			System.out.println("Dr. " + newDoctor.getDoctorName() + " Doctor Id:" + newDoctor.getDoctorId()
//			                  + " registered");
//		}
//		else {
//			System.out.println(newDoctor.getDoctorId() + " not added to file");
//		}
//	}
//	
//	public static String doctorAvailability(int i) {
//		if(i == 1)
//			return "am";
//		else if(i == 2)
//			return "pm";
//		return "am";
//	}
//	
//	private static String doctorIdGenerate() {
//		String inputId = "Dr";
//		inputId += random.nextInt(100);
//		return inputId;
//	}
	
}
