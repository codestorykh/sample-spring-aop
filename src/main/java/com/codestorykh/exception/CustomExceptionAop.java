package com.codestorykh.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomExceptionAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionAop.class);

    @AfterThrowing(pointcut = "execution(* com.codestorykh.exception.CustomExceptionController.*(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Throwable ex) {
        LOGGER.error("Exception occurred: {}", ex.getMessage());
        LOGGER.error("Method: {}", joinPoint.getSignature().getName());

        // send email to support team

        // save the record to database
    }
}
