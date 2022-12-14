package com.healthcare.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    PatientService patientService;

    private ArrayList<Doctor> doctors;

    public DoctorService() {
        System.out.println("DoctorService Constructor");
        this.doctors = new ArrayList<>();
        Doctor h = new Doctor("John", "Physiotherapy", "99889988", false, false);
        Doctor h1 = new Doctor("Sam", "General", "99826511", true, true);
        this.doctors.add(h);
        this.doctors.add(h1);
    }

    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
    }

    public ArrayList<Doctor> getSchedule() {
        ArrayList<Doctor> freeDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.scheduleStatus()) {
                freeDoctors.add(doctor);
            }
        }
        return freeDoctors;
    }

}
