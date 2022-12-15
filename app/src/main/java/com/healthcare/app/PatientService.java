package com.healthcare.app;

import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private ArrayList<Patient> patients;

    public PatientService() {
        System.out.println("PatientService Constructor");
        this.patients = new ArrayList<>();
        Patient p = new Patient("Jason");
        Patient p1 = new Patient("Jeremy");
        this.patients.add(p);
        this.patients.add(p1);
    }

    public ArrayList<Patient> getPatients() {
        return this.patients;
    }

    // public String getName

    public Patient findByPatientName(String firstname) {
        for (Patient p : this.patients) {
            if (p.getFName().equals(firstname)) {
                return p;
            }
        }
        return patients.get(0);
    }

    public void addPatient(Patient pat) {
        this.patients.add(pat);
    }

}
