package com.codestorykh.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAfter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAfter.class);

    @After("execution(* com.codestorykh.after.AfterController.*(..)) && @annotation(AfterAuditable)")
    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info("After method executed successfully...{}", joinPoint.getSignature());
    }
}
