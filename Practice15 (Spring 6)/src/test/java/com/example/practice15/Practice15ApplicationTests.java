package com.example.practice15;

import com.example.practice15.models.Student;
import com.example.practice15.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Practice15ApplicationTests {
	@Autowired
	StudentService studentService;

	@Test
	void contextLoads() {
		Student student = new Student(1L, "Ivan", "Ivanov", "Ivanovich");
		studentService.saveStudent(student);
		student = new Student(2L, "Egor", "Egorov", "Egorovich");
		studentService.saveStudent(student);

		System.out.println("\nBefore deleting");
		List<Student> list = studentService.listAllStudents();
		list.forEach(System.out::println);

		studentService.deleteStudentByFirstName("Ivan");

		System.out.println("\nAfter deleting:");
		list = studentService.listAllStudents();
		list.forEach(System.out::println);
	}
}
