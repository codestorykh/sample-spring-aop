package com.codestorykh.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoring {

    private final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoring.class);

    @Around("execution(* com.codestorykh.before.BeforeController.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
      long startTime = System.currentTimeMillis();
      Object result = joinPoint.proceed();
      long endTime = System.currentTimeMillis();

      LOGGER.info("Method {} executed in {} ms", joinPoint.getSignature(), endTime - startTime);
      LOGGER.info("Response: {}", result);
      return result;
    }
}
