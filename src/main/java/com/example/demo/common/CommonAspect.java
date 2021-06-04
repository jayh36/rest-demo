package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class CommonAspect {

    @Around("execution(* com.example.demo..*Service.*(..))")
    public Object calculatePerformance(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        long start = System.currentTimeMillis();

        try {
            //log.info("******** Start : {} {} {} {} ({}ms)", request.getMethod(), request.getRequestURI(), Arrays.toString(joinPoint.getArgs()), (start));
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            log.info("******** Request : {} {} {} ({}ms)", request.getMethod(), request.getRequestURI(), Arrays.toString(joinPoint.getArgs()), (end - start));
        }
    }

}
