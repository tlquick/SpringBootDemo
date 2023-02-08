package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@SpringBootApplication // makes this a runnable app
public class DemoApplication {
	@Autowired private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
		Student tracy = new Student("tracy", "tlquick@gmail.com", LocalDate.of(2000, 2, 5));
		Student tim = new Student("tim", "timmy@gmail.com", LocalDate.of(1990, 6, 10));
		System.out.println("Saving data to student table");
		repository.save(tracy);
		repository.save(tim);
    }
}
