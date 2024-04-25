package org.example.Practice10;

import org.example.Practice10.components.Junior;
import org.example.Practice10.components.Middle;
import org.example.Practice10.components.Programmer;
import org.example.Practice10.components.Senior;
import org.example.Practice10.configuration.BeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class Practice10ApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		Programmer junior = context.getBean("junior", Junior.class);
		junior.doCoding();

		Programmer middle = context.getBean("middle", Middle.class);
		middle.doCoding();

		Programmer senior = context.getBean("senior", Senior.class);
		senior.doCoding();
	}
}
