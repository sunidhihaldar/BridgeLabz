package com.bridgelabz.objectOriented.Clinique.ServiceImplementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.bridgelabz.objectOriented.Clinique.Model.Doctor;
import com.bridgelabz.objectOriented.Clinique.Model.Patient;
import com.bridgelabz.objectOriented.Clinique.Service.ICliniqueSer;
import com.bridgelabz.util.Utility;
import com.bridgelabz.util.JsonUtil;

/**
 * This class has the implementation of service interface which give the access
 * of functionality of adding a doctor to the hospital allows the patient to
 * search for doctor and take appointment with that doctor. If doctor exceeds
 * the limit of 5 patient then shifts the appointment to next day, all details
 * of patient, doctor and appointments are listed on JSON file.
 * 
 * @author Sunidhi Haldar
 * @created 2019.12.19
 * @version 13.0.1
 */

public class CliniqueOperation implements ICliniqueSer {
	
		private static final String PATH_DOCTOR = "doctor.json";
		private static final String PATH_PATIENT = "patient.json";
		private static final String PATH_APPOINTMENT = "appointment.json";
		private static JSONArray globalJsonArray = new JSONArray();
		private static Random random = new Random();

		/**
		 * Implementation of adding a doctor to the hospital which asks to fill name,
		 * specialization, availability timing and after successful addition of the
		 * doctor to the hospital with id display confirmation message to the user
		 */
		@SuppressWarnings("unchecked")
		public void addDoctor() {
			JSONObject doctorJsonObject = new JSONObject();
			// reading old data from file
			if (JsonUtil.readJsonArray(PATH_DOCTOR) != null) {
				globalJsonArray = JsonUtil.readJsonArray(PATH_DOCTOR);
			}

			Doctor newDoctor = new Doctor();

			System.out.println("Enter Doctor information :\n");
			// name
			System.out.println("Enter Doctor name :");
			String name = Utility.SCANNER.next();
			Utility.SCANNER.nextLine();
			newDoctor.setDoctorName(name);
			// id
			String id = doctorIdGnerator();
			newDoctor.setDoctorId(id);
			// specialization
			System.out.println("Enter Doctor specialization :");
			String specialization = Utility.SCANNER.next();
			newDoctor.setSpecilaization(specialization);;
			// availability
			System.out.println("Availablity : press 1 -> am, 2 -> pm:");
			int choice = Utility.intInput();
			String availabile = docAvailability(choice);
			newDoctor.setAvailability(availabile);
			// patient count
			newDoctor.setPatientCount(0);

			// adding json object
			doctorJsonObject.put("name", newDoctor.getDoctorName());
			doctorJsonObject.put("id", newDoctor.getDoctorId());
			doctorJsonObject.put("specialization", newDoctor.getSpecilaization());
			doctorJsonObject.put("availability", newDoctor.getAvailability());
			doctorJsonObject.put("patientCount", newDoctor.getPatientCount());
			// adding object to json array
			if (globalJsonArray.add(doctorJsonObject)) {
				// writing array data to json file
				JsonUtil.writeDataToJSONArray(PATH_DOCTOR, globalJsonArray);
				System.out.println("Dr." + newDoctor.getDoctorName() + " Doctor  Id : " + newDoctor.getDoctorId()
						+ " registered\n");
			} else {
				System.out.println("Error adding " + newDoctor.getDoctorName() + " to file");
			}

		}

		/**
		 * takes integer value as input and returns String data
		 * 
		 * @param inputData as Integer input parameter
		 * @return String value.
		 */
		private static String docAvailability(int inputData) {
			if (inputData == 1)
				return "am";
			else if (inputData == 2)
				return "pm";
			return null;

		}

		/**
		 * This function generates random id for patient
		 * @return int data
		 */
		private static int patientIdGnerator() {
			int inputId = 0;
			inputId += random.nextInt(10000);
			return inputId;
		}

		/**
		 * This function generates random id for doctor
		 * @return String data
		 */
		private static String doctorIdGnerator() {
			String inputId = "Dr";
			inputId += random.nextInt(100);
			return inputId;
		}

		/**
		 * This function takes doctor id and patient id as input parameter and Add a
		 * patient to the hospital with assigned doctor to that patient, and ask to fill
		 * name, age, mobile number and after successful addition of the patient to the
		 * hospital with id display confirmation message to the user and writes to the
		 * JSON file of the patient
		 * 
		 * @param patientId as String Input parameter
		 * @param doctorId  as String input parameter
		 */
		@SuppressWarnings("unchecked")
		private void addPatient(int patientId, String doctorId) {
			// reading old data from file
			JSONArray jsonArray = new JSONArray();
			JSONObject patientJsonObject = new JSONObject();
			if (JsonUtil.readJsonArray(PATH_PATIENT) != null) {
				jsonArray = JsonUtil.readJsonArray(PATH_PATIENT);
			}

			Patient newPatient = new Patient();

			System.out.println("Enter Doctor information :\n");
			// name
			System.out.println("Enter Patient name :");
			String patientName = Utility.SCANNER.next();
			newPatient.setPatientName(patientName);
			Utility.SCANNER.nextLine();
			// id
			patientId = patientIdGnerator();
			newPatient.setPatientId(patientId);
			// mobile
			System.out.println("Please enter mobile Number :");
			long number = Utility.longInput();
			newPatient.setPatientMobileNumber(number);
			// age
			System.out.println("Enter patient age :");
			int age = Utility.intInput();
			newPatient.setPatientAge(age);
			// adding data to json object
			patientJsonObject.put("name", newPatient.getPatientName());
			patientJsonObject.put("id", newPatient.getPatientId());
			patientJsonObject.put("mobile", newPatient.getPatientMobileNumber());
			patientJsonObject.put("age", newPatient.getPatientAge());
			// adding doctor id
			patientJsonObject.put("doctorId", doctorId);

			// adding the object to jsonArray
			if (jsonArray.add(patientJsonObject)) {
				// writing array data to json file
				JsonUtil.writeDataToJSONArray(PATH_PATIENT, jsonArray);
				System.out.println("patient " + newPatient.getPatientName() + " registered\n");
			} else {
				System.out.println("Error adding patient.");
			}
		}

		/**
		 * This function takes doctor object as input parameter and checks for
		 * appointment path if not empty then checks whether doctor has 5 patient or
		 * more for checking then on the basis of that it fix the appointment of the
		 * patient if doctor not busy then fix appointment date to next day.
		 * 
		 * @param doctorObject as JSON object of doctor
		 */
		@SuppressWarnings({ "unchecked" })
		private void bookAppointment(JSONObject doctorObject) {
			// read data from appointment path
			JSONArray jsonArray = null;
			if (JsonUtil.readJsonArray(PATH_APPOINTMENT) != null) {
				jsonArray = JsonUtil.readJsonArray(PATH_APPOINTMENT);
			} else {
				jsonArray = new JSONArray();
			}
			int patientId = 0;
			String doctorId = (String) doctorObject.get("id");
			long patientCount = (long) doctorObject.get("patientCount");
			// date set up
			LocalDate today = LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String tomorrowDate = tomorrow.format(format);
			String todayDate = today.format(format);
			// if patient count increases above 5 of a single doctor
			if (patientCount >= 5) {
				System.out.println("Doctor's chamber is full. Do you want to shift to tomorrow...[y/n]");
				String response = Utility.SCANNER.nextLine().toLowerCase().trim();
				if (response.equals("y")) {

					JSONObject jsonObject = new JSONObject();
					patientId = patientIdGnerator();
					addPatient(patientId, doctorId);
					jsonObject.put("doctorId", doctorId);
					jsonObject.put("patientId", patientId);
					jsonObject.put("appointmentDate", tomorrowDate);
					jsonArray.add(jsonObject);
					System.out.println("Appointment of patient id : " + patientId + " scheduled for " + tomorrowDate
							+ " with Dr." + doctorObject.get("name"));
					JsonUtil.writeDataToJSONArray(PATH_APPOINTMENT, jsonArray);

				}
				// patient count less than 5 of single doc
			} else {
				JSONObject jsonObject = new JSONObject();
				patientId = patientIdGnerator();
				addPatient(patientId, doctorId);
				doctorObject.put("patientCount", patientCount + 1);
				updateDoctor(doctorObject);
				// writing data to json appointment
				jsonObject.put("doctorId", doctorId);
				jsonObject.put("patientId", patientId);
				jsonObject.put("appointmentDate", todayDate);
				jsonArray.add(jsonObject);
				System.out.println("Appointment of patient id : " + patientId + " fixed today.");
				JsonUtil.writeDataToJSONArray(PATH_APPOINTMENT, jsonArray);
			}
		}

		/**
		 * This method takes key and value as input parameter and read the patient JSON
		 * file if not empty then fetch particular Patient object and display the
		 * content to the user.
		 */
		@SuppressWarnings("rawtypes")
		public void readPatientDetails(String key, String value) {
			// reading old data from file.
			if (JsonUtil.readJsonArray(PATH_PATIENT) == null) {
				System.out.println("Empty list.. plz add patient.");
				return;
			}
			globalJsonArray = JsonUtil.readJsonArray(PATH_PATIENT);
			Iterator iterator = globalJsonArray.iterator();
			// displaying all records of searched patient.
			JSONObject patientObject;
			while (iterator.hasNext()) {
				if ((patientObject = (JSONObject) iterator.next()).get(key).equals(value)) {
					System.out.println("patient details :\n------------------");
					System.out.println("id : " + patientObject.get("id") + "\t");
					System.out.println("name : " + patientObject.get("name") + "\t");
					System.out.println("mobile : " + patientObject.get("mobile") + "\t");
					System.out.println("age : " + patientObject.get("age") + "\t");
				}
			}

		}

		/**
		 * This function read JSON file of doctor from global and after fetching update
		 * doctor object by iterating to end update the doctor information. file of the
		 * doctor.
		 * 
		 * @param currentDoctorObject
		 */
		@SuppressWarnings("unchecked")
		private void updateDoctor(JSONObject currentDoctorObject) {
			globalJsonArray = JsonUtil.readJsonArray(PATH_DOCTOR);

			JSONArray updatedArray = new JSONArray();
			@SuppressWarnings("rawtypes")
			Iterator iterator = globalJsonArray.iterator();

			while (iterator.hasNext()) {
				JSONObject nextDoctorObject = (JSONObject) iterator.next();
				if (nextDoctorObject.get("id").equals(currentDoctorObject.get("id"))) {
					updatedArray.add(currentDoctorObject);
				} else {
					updatedArray.add(nextDoctorObject);
				}
			}
			JsonUtil.writeDataToJSONArray(PATH_DOCTOR, updatedArray);
		}

		/**
		 * This is the implemented functionality which takes key and value as input
		 * parameter of doctor and search the particular doctor and ask the user to
		 * proceed with appointment procedure.
		 * 
		 */
		@SuppressWarnings("rawtypes")
		public void searchDoctorBookAppointment(String key, String value) {
			// reading old data from file.
			JSONArray readOldFile = JsonUtil.readJsonArray(PATH_DOCTOR);
			if (readOldFile == null) {
				System.out.println("Empty list.. plz add doctor.");
				return;
			}
			globalJsonArray = JsonUtil.readJsonArray(PATH_DOCTOR);
			Iterator iterator = globalJsonArray.iterator();
			JSONObject currentDoctorObject = null;
			JSONObject previousDoctorObject = null;
			int doctorCount = 1;
			// searching doc storing.
			while (iterator.hasNext()) {

				if ((currentDoctorObject = (JSONObject) iterator.next()).get(key).equals(value)) {
					previousDoctorObject = currentDoctorObject;
					System.out.println("\nDoctor No : " + doctorCount++ + "\n--------------");
					System.out.println("id : " + currentDoctorObject.get("id") + "\t");
					System.out.println("name :" + currentDoctorObject.get("name") + "\t");
					System.out.println("specialization : " + currentDoctorObject.get("specialization") + "\t");
					System.out.println("availability : " + currentDoctorObject.get("availability") + "\t");
					System.out.println("patientCount : " + currentDoctorObject.get("patientCount") + "\t");
					System.out.println("Do you want to take appointment : [y/n]");
				}
			}
			// if doc not found
			if (previousDoctorObject == null) {
				System.out.println("Opps. doctor not associated with Hospital...");
				return;
			}
			// doc found and proceed with appointment
			String appointmentChoice = Utility.SCANNER.next().trim();
			Utility.SCANNER.nextLine();
			if(appointmentChoice.equalsIgnoreCase("y")) {
				bookAppointment(previousDoctorObject);
			}
			else {
				System.out.println("Thank you...");
				return;
			}
		}

		/**
		 * This is the implementation functionality of displaying all details of doctors
		 * associated with the hospital.
		 */
		@SuppressWarnings("rawtypes")
		public void printDoctorList() {
			JSONArray readOldFileArray = JsonUtil.readJsonArray(PATH_DOCTOR);
			if (readOldFileArray == null) {
				System.out.println("Empty list.. plz add doctor.");
				return;
			}
			Iterator iterator = readOldFileArray.iterator();
			JSONObject jsonDoctorObject;
			int count = 1;
			System.out.println("All Doctors associated with hospital :\n---------------------------------------");
			while (iterator.hasNext()) {
				jsonDoctorObject = (JSONObject) iterator.next();
				System.out.println("Doctor No : " + count++ + "\n--------------");
				System.out.println("id\t: " + jsonDoctorObject.get("id"));
				System.out.println("name\t: " + jsonDoctorObject.get("name"));
				System.out.println("Dept\t: " + jsonDoctorObject.get("specialization"));
				System.out.println("Timing\t: " + jsonDoctorObject.get("availability"));
				System.out.println("Patient\t: " + jsonDoctorObject.get("patientCount"));
				System.out.println();
			}
		}

		/**
		 * This is the implementation functionality of displaying all details of
		 * patients associated with the hospital
		 */
		@SuppressWarnings("rawtypes")
		public void printPatientList() {
			JSONArray readOldFileArray = JsonUtil.readJsonArray(PATH_PATIENT);
			if (readOldFileArray == null) {
				System.out.println("Empty list.. plz add doctor.");
				return;
			}
			Iterator iterator = readOldFileArray.iterator();
			JSONObject jsonPatientObject;
			int count = 1;
			System.out.println("All patients registered with hospital :\n------------------------------------");
			while (iterator.hasNext()) {
				jsonPatientObject = (JSONObject) iterator.next();
				System.out.println("patient No : " + count++ + "\n---------------");
				System.out.println("id\t: " + jsonPatientObject.get("id"));
				System.out.println("name\t: " + jsonPatientObject.get("name"));
				System.out.println("mobile\t: " + jsonPatientObject.get("mobile"));
				System.out.println("age\t: " + jsonPatientObject.get("age"));
				System.out.println("doctor\t: " + jsonPatientObject.get("doctorId"));
				System.out.println();
			}
		}

}
