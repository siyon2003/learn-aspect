package com.aop.learn_aspect.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class AspectConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.aop.learn_aspect.aop.aspect.CommonPointcutConfig.businessDataPackageConfig()")
    private void logMethodNameBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before {} is called - {} with arguments", joinPoint, joinPoint.getArgs());
    }

    @After("com.aop.learn_aspect.aop.aspect.CommonPointcutConfig.dataPackageConfig()")
    private void logAfterMethodExecution(JoinPoint joinPoint) {
        logger.info("After {} is executed", joinPoint);
    }

    @AfterReturning(pointcut = "com.aop.learn_aspect.aop.aspect.CommonPointcutConfig.businessPackageConfig()", returning = "resultValue")
    private void logAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("After returning {} with return value as {}", joinPoint, resultValue);
    }

    @Around("com.aop.learn_aspect.aop.aspect.CommonPointcutConfig.serviceDataBeanConfig()")
    private Object logAroundMethodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start a timer
        long startTime = System.currentTimeMillis();
        // Execute a method
        Object returnValue = proceedingJoinPoint.proceed();
        // Stop a timer
        long endTime = System.currentTimeMillis();

        logger.info("Duration for execution of this {} is {}", proceedingJoinPoint, endTime - startTime);

        return returnValue;
    }




}
