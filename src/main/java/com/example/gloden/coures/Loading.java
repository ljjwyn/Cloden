package com.example.gloden.coures;

/**
 * Exercise 23: (2) Prove that class loading takes place only once.
 * Prove that loading may be caused by either the creation of the first instance of that class
 * or by the access of a static member.
 * 第23题: 证明类的加载只会发生一次. 证明有两种情况导致类的加载:
 * 1)创建第一个对象的时候 2)静态成员被访问的时候
 *
 */

import java.util.Random;

class P190{
    //每次加载类P190, 随机数i都会有所不同; 如果i相同, 说明只加载了一次
    static int i=getRandom();
    public static int getRandom() {
        Random ran = new Random(System.nanoTime());
        int rand = ran.nextInt(10);
        System.out.println("P190 被加载，产生随机数："+rand);
        return rand;
    }
}

public class Loading {

    public static void main(String[] args) {
        //访问静态变量
        System.out.println(P190.i);
        //创建一个对象
        P190 x=new P190();
        System.out.println(P190.i);
        P190 y=new P190();
        System.out.println(P190.i);
        //即使创建了10个对象的数组z, 类P190也只是被加载了一次
        P190[] z=new P190[10];
        for(int i=0; i<10; i++){
            z[i]=new P190();
        }
        for(P190 a:z){
            System.out.print(a.i+"; ");
        }
    }
}
