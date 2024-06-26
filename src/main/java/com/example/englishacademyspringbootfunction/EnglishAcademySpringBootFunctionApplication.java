package com.example.englishacademyspringbootfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class EnglishAcademySpringBootFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishAcademySpringBootFunctionApplication.class, args);
	}

	@Bean
	public Function<String, String> uppercase() {
		return payload -> {
			String output = payload.toUpperCase();
			return String.format("Input: %s", output);
		};
	}

}
