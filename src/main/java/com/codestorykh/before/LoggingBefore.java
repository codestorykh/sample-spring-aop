package com.codestorykh.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingBefore {

    private final static Logger logger = LoggerFactory.getLogger(LoggingBefore.class.getName());

    @Before(" execution(* com.codestorykh.before.BeforeController.*(..)) ||" +
            " execution(* com.codestorykh.after.AfterController.*(..)) ||" +
            " execution(* com.codestorykh.around.CustomCacheController.*(..))" +
            "&& @annotation(BeforeAuditable)")
    public void loggingBeforeAdvice(JoinPoint joinPoint) {
        logger.info("Before execution for method: {}", joinPoint.getSignature());
    }
}
