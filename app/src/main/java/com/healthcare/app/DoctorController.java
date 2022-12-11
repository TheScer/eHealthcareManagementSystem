package com.healthcare.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //private PatientService patientService;

    @GetMapping("/doctors")
    public String getDoctors(Model model){
        ArrayList<Doctor> doctorList = doctorService.getDoctors();
        model.addAttribute("doctorList", doctorList);
        return "doctorPage";
    }

    @GetMapping("/doctorsSchedule")
    public String getSchedule(Model model){
        ArrayList<Doctor> scheduleList = doctorService.getSchedule();
        model.addAttribute("doctorSchedule", scheduleList);
        return "doctorsSchedule";
    }

}
