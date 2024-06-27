package com.example.englishacademyspringbootfunction.dao.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Container(containerName = "students")
public class Student {

    @Id
    @GeneratedValue
    private String id;

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
