package com.example.englishacademyspringbootfunction;

import com.example.englishacademyspringbootfunction.dao.entity.Student;
import com.example.englishacademyspringbootfunction.dao.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.function.Function;

@AllArgsConstructor
@SpringBootApplication
public class EnglishAcademySpringBootFunctionApplication {

    private StudentsRepository studentsRepository;

    public static void main(String[] args) {
        SpringApplication.run(EnglishAcademySpringBootFunctionApplication.class, args);
    }

    @PostConstruct
    void loadData() {
        System.out.println("***************************************************************");

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
        studentsRepository.findAll().forEach(System.out::println);
        System.out.println("***************************************************************");
    }


    @Bean
    public Function<String, String> uppercase() {
        return payload -> {
            String output = payload.toUpperCase();
            return String.format("Input: %s", output);
        };
    }

}
