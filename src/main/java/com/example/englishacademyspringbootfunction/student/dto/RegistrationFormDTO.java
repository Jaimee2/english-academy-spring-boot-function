package com.example.englishacademyspringbootfunction.student.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationFormDTO {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String parentPhone;
    private String parentEmail;
    private String siblings;
    private String notes;
    private String books;
    private String payment;
    private String studentStatus;

}
