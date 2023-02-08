# SpringBootDemo
Demo project to illustrate how to connect a postgres database to a springboot project (using hibernate). <br>
This example uses a Student entity. <br>
### version 1.0
OpenAPI is used to document the endpoints: use /v3/api-docs or /swagger-ui.html to view API documentation. <br>
application.properties stores the configuration for the database connection: <br>
```
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=user
spring.datasource.password=test
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
server.error.include-message=always
```

Student.java defines the Student object <br>
StudentConfig.java contains some sample data to load. <br>
StudentController.java is a rest controller containing the defined endpoints. In this case localhost:8080/api/v1 is the base url defined by @RequestMapping. CRUD mappings are also defined 
eg @DeleteMapping uses localhost:8080/api/v1/atudents/{studentId}. <br>
StudentRepository.java uses JpaRepository<Student, Long> to find a particular student eg
```
Optional<Student> findStudentByEmail(String email);
```
<br>
StudentService.java performs validation eg <br>

```
public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	} 
  ```
### Version 2
Application is dockerised and docker-compose is used to build and manage app and db togther for deployment.
