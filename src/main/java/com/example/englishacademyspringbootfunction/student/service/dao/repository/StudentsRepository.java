package com.example.englishacademyspringbootfunction.student.service.dao.repository;

import com.example.englishacademyspringbootfunction.student.service.dao.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, String> {
    @Override
    List<Student> findAll();
}
