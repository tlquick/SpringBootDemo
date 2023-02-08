package com.example.demo.student;

import java.time.LocalDate;

import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;

@Entity // this class describes objects
@Table // this class represents a table in the db
@Data // lombok - combines @Getter & @Setter - generates setters and getters
@NoArgsConstructor // lombok - generates the no arg constructor
@ToString(includeFieldNames = true) // lombok - generate toString() with field names included
public class Student {
	@Id // this is the primary key for the table - below defines the sequence for auto
		// increment
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	@Transient // calculated value - not stored in DB
	@Getter(AccessLevel.NONE) // lombok - do not create getter for this field
	@Setter(AccessLevel.NONE) // lombok - do not create setter for this field
	@ToString.Exclude // lombok - do not add this field to the toString()
	private Integer age;

	public Student(Long id, String name, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Student(String name, String email, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears(); // calculate the years between dob & now
	}

}
