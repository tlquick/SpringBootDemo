package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // all subclasses access database
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findStudentByEmail(String email); //same as @Query("SELECT s FROM Student s WHERE s.email =?1" in JPQL
}
