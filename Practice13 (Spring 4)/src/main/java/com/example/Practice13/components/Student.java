package com.example.Practice13.components;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
public class Student {
    private static final Logger LOGGER = LogManager.getLogger(Student.class);
    @Value("${program.student.name}")
    private String name;
    @Value("${program.student.last_name}")
    private String lastName;
    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void init() {
        LOGGER.info("Initial parameters for student: {} {} {}", name, lastName, group);
    }
}
