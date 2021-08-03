package com.example.gloden.coures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class IntegerCompatator {
    public static void main(String[] args) {
        Integer[] ints = new Integer[8];
        Random r = new Random(1);
        for(int i=0 ; i<8 ;  i++) {
            int ran1 = r.nextInt(100);
            ints[i] = ran1;
        }
        Arrays.sort(ints, (a, b) -> b-a);
        System.out.println(ints);
    }
}
