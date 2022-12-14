package com.healthcare.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/patients/{fName}")
    public String getPatientInfo(@PathVariable String fName, Model model) {
        Patient patient = patientService.findByPatientName(fName);
        model.addAttribute("patient", patient);
        return "patient";
    }
}
