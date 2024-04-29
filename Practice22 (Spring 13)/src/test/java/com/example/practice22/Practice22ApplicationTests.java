package com.example.practice22;

import com.example.practice22.repositories.StudentRepository;
import com.example.practice22.repositories.UniversityRepository;
import com.example.practice22.services.SchedulerService;
import com.example.practice22.services.StudentService;
import com.example.practice22.services.UniversityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Practice22ApplicationTests {
	@Autowired
	UniversityService universityService;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	UniversityRepository universityRepository;

	@Test
	void contextLoads() throws Exception {
		SchedulerService.registerMBean(studentRepository, universityRepository);
	}
}
