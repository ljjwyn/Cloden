package com.example.gloden.model;

import com.example.gloden.annotation.Default;
import com.example.gloden.annotation.Log;
import lombok.Data;

/**
 * @author ljjwyn
 */
@Data
@Default("默认类school")
public class School {
    private String schoolName;
    private int studentCount;
    private String address;
    @Log
    public void test(){
        System.out.println(1212);
    }
}
