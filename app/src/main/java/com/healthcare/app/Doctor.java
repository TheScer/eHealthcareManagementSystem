package com.healthcare.app;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor extends AbstractPersistable<Long>{
    private String name;            // name of doctor
    private String field;           // what specialisation the doctor has
    private String contactNumber;
    private Boolean schedule;       // false means TTS, true means MWF 
    private Boolean appointment;    // false means not free, true means free

    public Doctor(String name){
        this.name = name;
        this.field = "general";
        this.contactNumber = "911";
        this.schedule = true;
    }

    public Boolean appointmentStatus(){
        return this.appointment;
    }

    public void fixAppointment(){
        if(this.appointment == false) {
            System.out.println("Already booked try another doctor");
        }
        else{
            this.appointment = false;
        }
    }

    public void cancelAppointment(){
        if(this.appointment == true) {
            System.out.println("Cancelling Appointment");
            this.appointment = false;
        } 
        else{
            System.out.println("No appointment anyway");
        }
        this.appointment = false;
    }
}
