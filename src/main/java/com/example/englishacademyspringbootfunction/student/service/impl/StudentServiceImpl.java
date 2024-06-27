package com.example.englishacademyspringbootfunction.student.service.impl;

import com.example.englishacademyspringbootfunction.student.service.dao.entity.Student;
import com.example.englishacademyspringbootfunction.student.service.dao.repository.StudentsRepository;
import com.example.englishacademyspringbootfunction.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentsRepository studentsRepository;

    public List<Student> GetAllStudents() {
        return studentsRepository.findAll();
    }

}
