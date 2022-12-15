package com.healthcare.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/doctors")
    public String addDoctor(@RequestParam String name, String field, String contact, Boolean schedule, Boolean appointment ){
        Doctor doc = new Doctor(name, field, contact, schedule, appointment); 
        doctorService.addDoctor(doc);
        return "redirect:/doctors";
    }

    @GetMapping("/doctorsSchedule")
    public String getSchedule(Model model){
        ArrayList<Doctor> scheduleList = doctorService.getSchedule();
        model.addAttribute("doctorSchedule", scheduleList);
        return "doctorsSchedule";
    }

    @GetMapping("/addPage")
    public String addPage(){
        return "addDoctors";
    }

}
