package com.vikas.simpleApi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(int com.vikas.simpleApi.controller.Hello.id(..)) && args(postId)")
    public Object validateInput(ProceedingJoinPoint jp, int postId) throws Throwable {
        LOGGER.info(String.valueOf(postId));
        if(postId < 0){
            postId = -postId;
        }
        Object obj = jp.proceed(new Object[]{postId});

        return obj;
    }
}
