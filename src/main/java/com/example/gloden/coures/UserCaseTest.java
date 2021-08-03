package com.example.gloden.coures;

import com.example.gloden.annotation.UseCase;

import java.lang.reflect.Method;

public class UserCaseTest {
    @UseCase(id = 1, description = "check case")
    public boolean check(String pwd) {
        System.out.println("check");
        return true;
    }
    @UseCase(id = 1, description = "check case")
    public boolean validate(String pwd) {
        System.out.println("validate");
        return true;
    }
    public static <T, S> void trackUseCase(T obj, S... params) throws Exception {
        Class<?> cl = obj.getClass();
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found UseCase: " + uc.id() + ", " + uc.description()); // 找出我们定义的测试用例并打印
                m.invoke(obj, params);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        UserCaseTest u = new UserCaseTest();
        UserCaseTest.trackUseCase(u, "aaaaaaaaaa");
    }
}

