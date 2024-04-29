package com.example.practice21;

import com.example.practice21.models.Student;
import com.example.practice21.models.University;
import com.example.practice21.services.StudentService;
import com.example.practice21.services.UniversityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Practice21ApplicationTests {
	@Autowired
	UniversityService universityService;
	@Autowired
	StudentService studentService;

	@Test
	void contextLoads() {
		University university = new University();
		universityService.saveUniversity(university);

		Student student = new Student();
		studentService.saveStudent(student);

		universityService.deleteUniversitiesByName(null);
		studentService.deleteStudentsByFirstName(null);
	}
}
