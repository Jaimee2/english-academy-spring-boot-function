package com.example.englishacademyspringbootfunction.dao.repository;

import com.example.englishacademyspringbootfunction.dao.entity.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentsRepository extends CrudRepository<Student, String> {

}
