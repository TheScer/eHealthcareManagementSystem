package com.healthcare.app;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public String getPatients(Model model) {
        ArrayList<Patient> patientList = patientService.getPatients();
        model.addAttribute("patientList", patientList);
        return "patientsPage";
    }

    @PostMapping("/patients")
    // if want to have birthdate as a date have to change the params here to date
    // and in the patient class
    // but the html input returns a string by default
    public String addPatient(@RequestParam String fName, String lName, String status, String birthDate,
            String symptoms) {
        Patient pat = new Patient(fName, lName, status, birthDate, symptoms);
        patientService.addPatient(pat);
        return "redirect:/patients";
    }

    @GetMapping("/patients/{fName}")
    public String getPatientInfo(@PathVariable String fName, Model model) {
        Patient patient = patientService.findByPatientName(fName);
        model.addAttribute("patient", patient);
        return "patient";
    }

    @GetMapping("addPage1")
    public String addPage() {
        return "addPatients";
    }
}
