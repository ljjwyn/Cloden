package com.example.gloden.model;

import com.example.gloden.annotation.Default;
import lombok.Data;

@Data
public class Person {
    private String userName;
    private String userId;
    private int age;
    private String sex;
    private String address;
}
