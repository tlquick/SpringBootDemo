package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
					Student tracy = new Student("tracy", "tlquick@gmail.com", LocalDate.of(2000, 2, 5));
					Student tim = new Student("tim", "timmy@gmail.com", LocalDate.of(1990, 6, 10));
					repository.saveAll(List.of(tracy, tim));
		};
	}
}
