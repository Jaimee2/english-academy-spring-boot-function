package com.example.englishacademyspringbootfunction.dto;

import lombok.Data;

@Data
public class RegistrationFormDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String parentPhone;
    private String parentEmail;
    private String siblings;
    private String notes;
    private String books;
    private String payment;
    private String studentStatus;

}
