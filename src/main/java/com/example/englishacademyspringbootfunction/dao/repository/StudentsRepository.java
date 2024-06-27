package com.example.englishacademyspringbootfunction.dao.repository;

import com.example.englishacademyspringbootfunction.dao.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, String> {
    @Override
    List<Student> findAll();
}
