package com.example.Practice13;

import com.example.Practice13.components.Student;
import com.example.Practice13.configuration.BeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class Practice13ApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Student student = context.getBean(Student.class);

		student.setGroup("IKBO-01-22");
		System.out.println(student);
	}
}
