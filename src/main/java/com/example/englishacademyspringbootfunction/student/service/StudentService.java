package com.example.englishacademyspringbootfunction.student.service;

import com.example.englishacademyspringbootfunction.student.dao.entity.Student;
import com.example.englishacademyspringbootfunction.student.dto.RegistrationFormDTO;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    Student saveStudent(RegistrationFormDTO registrationFormDTO);

    void deleteStudentById(String id);

     Student getStudent(String id);

}
