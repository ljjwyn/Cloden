package com.example.gloden.model;

import com.example.gloden.annotation.Default;
import com.example.gloden.annotation.Log;
import lombok.Data;

/**
 * @author ljjwyn
 */
@Data
public class School {
    private String schoolName;
    private int studentCount;
    private String address;
    public void test(){
        System.out.println(1212);
    }
}
