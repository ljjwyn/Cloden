package com.example.gloden.interceptor;

import com.example.gloden.server.BeanFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import java.util.Locale;

/**
 * @author ljjwyn
 */
@Aspect
public class DefaultInt {
    @Pointcut("@annotation(com.example.gloden.annotation.Default)")
    public void annotationPointcut() {}

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        System.out.println("Default");
        Signature signature = joinPoint.getSignature();
        String allPathName = signature.getDeclaringType().getName();
        String keyName =  signature.getDeclaringType().getSimpleName();
        BeanFactory.setBean(keyName.toLowerCase(Locale.ROOT),allPathName);
    }

}
