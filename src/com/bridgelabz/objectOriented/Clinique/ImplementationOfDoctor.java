package com.bridgelabz.objectOriented.Clinique;

import java.util.ArrayList;

public class ImplementationOfDoctor {

	ArrayList<Doctor> dlist;
	
	public ImplementationOfDoctor(ArrayList<Doctor> dlist) {
		this.dlist = dlist;
	}

	public void doctorDetails() {
		System.out.println("List of doctors");
		for(int i = 0; i < dlist.size(); i++) {
			System.out.println((i + 1) + "." + "Doctor id:" + dlist.get(i).getDoctorId()
					+ "Doctor name:" + dlist.get(i).getDoctorName() 
					+ "Specialization:" + dlist.get(i).getSpecilaization()
					+ "Availability:"+ dlist.get(i).getAvailability());
		}
	}
	
}
