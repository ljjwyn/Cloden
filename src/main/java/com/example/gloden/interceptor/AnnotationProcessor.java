package com.example.gloden.interceptor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.example.gloden.annotation.Test"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Log in AnnotationProcessor.process");
        for (TypeElement typeElement : annotations) {
            System.out.println(typeElement);
        }
        System.out.println(roundEnv);
        return true;
    }
}
