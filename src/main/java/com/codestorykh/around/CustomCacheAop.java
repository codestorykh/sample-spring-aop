package com.codestorykh.around;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CustomCacheAop {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomCacheAop.class);

    private final Map<String, Object> cache = new HashMap<>();

    @Around("execution(* com.codestorykh.around.CustomCacheController.*(..)) && @annotation(CustomCache)")
    public Object customCache(ProceedingJoinPoint joinPoint) throws Throwable {
       String key = generateKey(joinPoint);
       if(cache.containsKey(key)){
           LOGGER.info("Returning cached result for key: {}", key);
           return cache.get(key);
       }

       Object result = joinPoint.proceed();
       cache.put(key, result);
       return result;
    }

    private String generateKey(JoinPoint joinPoint){
        StringBuilder key = new StringBuilder(joinPoint.getSignature().toString());
        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            key.append(arg.toString());
        }
        return key.toString();
    }

}
