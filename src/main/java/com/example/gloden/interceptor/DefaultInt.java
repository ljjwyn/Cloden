package com.example.gloden.interceptor;

import com.example.gloden.annotation.Default;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class DefaultInt {
    @Pointcut("@annotation(com.example.gloden.annotation.Default)")
    public void annotationPointcut() {}

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Default annotation = method.getAnnotation(Default.class);

    }

}
