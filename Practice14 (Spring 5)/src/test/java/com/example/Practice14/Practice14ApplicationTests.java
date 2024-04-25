package com.example.Practice14;

import com.example.Practice14.models.Student;
import com.example.Practice14.models.University;
import com.example.Practice14.services.StudentService;
import com.example.Practice14.services.UniversityService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;


class Practice14ApplicationTests {

	@Test
	void testServices() {
		StudentService studentService = new StudentService();

		studentService.add(new Student("Ivan", "Ivanovich", "Ivanov"));
		studentService.add(new Student("Egor", "Egorovich", "Egorov"));
		studentService.getAll().forEach(System.out::println);
		System.out.println();
		studentService.remove(new Student("Egor", "Egorovich", "Egorov"));
		studentService.getAll().forEach(System.out::println);
		System.out.println();

		UniversityService universityService = new UniversityService();

		universityService.add(new University("RTU MIREA",
				LocalDate.of(1947, Month.MAY, 28)));
		universityService.add(new University("HSE",
				LocalDate.of(1992, Month.NOVEMBER, 27)));
		universityService.getAll().forEach(System.out::println);
		System.out.println();
		universityService.remove(new University("HSE",
				LocalDate.of(1992, Month.NOVEMBER, 27)));
		universityService.getAll().forEach(System.out::println);
		System.out.println();
	}
}
