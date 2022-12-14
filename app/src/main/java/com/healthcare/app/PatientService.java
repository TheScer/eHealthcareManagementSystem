package com.healthcare.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    DoctorService doctorService;

    private ArrayList<Patient> patients;

    public PatientService() {
        System.out.println("PatientService Constructor");
    }
}
