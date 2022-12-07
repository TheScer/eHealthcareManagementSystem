package com.healthcare.app;

import java.util.Date;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient extends AbstractPersistable<Long> {
    private String fName;
    private String lName;
    private String status;
    private int age;
    private Date birthDate;

    public Patient(String firstName) {
        this.fName = firstName;
        this.status = "unhealthy";

    }
}
