//package com.example.gloden.coures;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Random;
//
//@Slf4j
//public class ClassLoadingTest {
//    public static void main(String[] args) {
//        TargetClass targetClass = new TargetClass();
//        log.info("成员变量1{}",targetClass.num1);
//        log.info("静态变量1{}",TargetClass.num);
//        TargetClass targetClass1 = new TargetClass();
//        log.info("成员变量2{}",targetClass1.num1);
//        log.info("静态变量2{}",TargetClass.num);
//        TargetClass targetClass2 = new TargetClass();
//        log.info("成员变量3{}",targetClass2.num1);
//        log.info("静态变量3{}",TargetClass.num);
//    }
//}
//
//class TargetClass{
//    static int num = getRandom();
//    int num1 = getRandom();
//    static int getRandom(){
//        Random ran = new Random(System.nanoTime());
//        int rand = ran.nextInt(100);
//        return rand;
//    }
//}
