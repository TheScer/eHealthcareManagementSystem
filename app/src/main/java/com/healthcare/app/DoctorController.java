package com.healthcare.app;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

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

    @PostMapping("/bookDoctor")
    public String bookDoctor(@RequestParam String name){
        Doctor doc = doctorService.findDocByName(name);
        doc.fixAppointment();
        return "redirect:/doctors";
    }


    @GetMapping("/doctors/{name}")
    public String getDoctorInfo(@PathVariable String name, Model model) {
        Doctor doc = doctorService.findDocByName(name);
        model.addAttribute("doctor", doc);
        return "doctorInfo";
    }

    @GetMapping("/doctorsSchedule")
    public String getSchedule(Model model){
        ArrayList<Doctor> scheduleList = doctorService.getAppointment();
        model.addAttribute("doctorSchedule", scheduleList);
        return "doctorsSchedule";
    }

    @GetMapping("/addPage")
    public String addPage(){
        return "addDoctors";
    }
}
