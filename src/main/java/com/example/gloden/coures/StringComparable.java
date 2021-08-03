//package com.example.gloden.coures;
//
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class StringComparable {
//    public static void main(String[] args) {
//        StringTest s1 = new StringTest("4","1");
//        StringTest s2 = new StringTest("3","2");
//        StringTest s3 = new StringTest("2","3");
//        StringTest s4 = new StringTest("1","4");
//        List<StringTest> list = new ArrayList<>();
//        list.add(s3);
//        list.add(s2);
//        list.add(s1);
//        list.add(s4);
//        Collections.sort(list);
//        System.out.println(list);
//    }
//}
//@Data
//class StringTest implements Comparable{
//    private String str1;
//    private String str2;
//    public StringTest(String str1, String str2){
//        this.str1 = str1;
//        this.str2 = str2;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        StringTest stringTest = (StringTest) o;
//        return this.str2.compareTo(stringTest.getStr2());
//    }
//
//    @Override
//    public String toString() {
//        return "StringTest{" +
//                "str1='" + str1 + '\'' +
//                ", str2='" + str2 + '\'' +
//                '}';
//    }
//}
