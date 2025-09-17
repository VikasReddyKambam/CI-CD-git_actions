package com.vikas.simpleApi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(String com.vikas.simpleApi.controller.Hello.hello())")
//    public void logMethodCall(JoinPoint jp){
//        LOGGER.info("Method Called {}", jp.getSignature().getName());
//    }

    @Around("execution(String com.vikas.simpleApi.controller.Hello.hello())")
    public Object monitorTime(ProceedingJoinPoint pj) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pj.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken : {}", start - end);
        return obj;
    }

}
