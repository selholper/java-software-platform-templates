package com.example.practice20.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExecutionTimeAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExecutionTimeAspect.class);
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("within(com.example.practice20.services.*)")
    public void beforeServiceMethodExecution(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        LOGGER.info("Executing method: {}", joinPoint.getSignature());
    }

    @After("within(com.example.practice20.services.*)")
    public void afterServiceMethodExecution(JoinPoint joinPoint) {
        long executionTime = System.currentTimeMillis() - startTime.get();
        LOGGER.info("Method {} executed in {} ms", joinPoint.getSignature(), executionTime);
        startTime.remove();
    }
}
