package com.example.englishacademyspringbootfunction.student.dao.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.englishacademyspringbootfunction.student.dao.entity.Student;

import java.util.List;

public interface StudentsRepository extends CosmosRepository<Student, String> {
    @Override
    List<Student> findAll();

}
