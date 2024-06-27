package com.example.englishacademyspringbootfunction;

import com.example.englishacademyspringbootfunction.dao.entity.Student;
import com.example.englishacademyspringbootfunction.dao.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Function;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class EnglishAcademySpringBootFunctionApplication {

    private StudentsRepository studentsRepository;

    public static void main(String[] args) {
        SpringApplication.run(EnglishAcademySpringBootFunctionApplication.class, args);
    }

    @PostConstruct
    void loadData() {
        log.info("***************************************************************");


        Student student = Student.builder()
                .firstName("Jaime without id")
                .lastName("Doe")
                .address("123 Main St")
                .parentPhone("123-456-7890")
                .parentEmail("parent@example.com")
                .siblings("None")
                .notes("Interested in football")
                .books("yes")
                .payment("cash")
                .studentStatus("new")
                .build();

        studentsRepository.save(student);

        List<Student> studentList = studentsRepository.findAll();
        studentList.forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        List<Student> students = studentsRepository.findAll();
        System.out.println(students);
        log.info("***************************************************************");
    }


    @Bean
    public Function<String, String> uppercase() {
        return payload -> {
            String output = payload.toUpperCase();
            return String.format("Input: %s", output);
        };
    }

}
