package com.example.englishacademyspringbootfunction.student.dao.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
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
