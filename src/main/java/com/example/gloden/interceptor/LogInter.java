package com.example.gloden.interceptor;

import com.example.gloden.annotation.Default;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author ljjwyn
 */
@Aspect
public class LogInter {
    @Pointcut("@annotation(com.example.gloden.annotation.Log)")
    public void annotationPointcut() {}

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        System.out.println("log before");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Default annotation = method.getAnnotation(Default.class);
        String name = method.getName();
        System.out.println("log: "+name);
    }
}
