package org.example.Practice10.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.Practice10.components"})
public class BeanConfig {
}
