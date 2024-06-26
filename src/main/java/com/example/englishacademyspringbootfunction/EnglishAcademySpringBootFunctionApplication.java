package com.example.englishacademyspringbootfunction;

import com.example.englishacademyspringbootfunction.student.dao.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class EnglishAcademySpringBootFunctionApplication {

    private StudentsRepository studentsRepository;

    public static void main(String[] args) {
        SpringApplication.run(EnglishAcademySpringBootFunctionApplication.class, args);
    }

}
