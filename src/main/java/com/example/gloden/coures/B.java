package com.example.gloden.coures;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class B {
    private List<U> uList = new ArrayList<>();
    public void saveU(U u){
        uList.add(u);
    }
    public void getU(){
        int count = 0;
        for(U u:uList){
            log.warn("_______num:{}_________",count);
            u.one();
            u.two();
            u.three();
            log.warn("______________________");
            count++;
        }
    }
}
class Client{
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        U u = a.method();
        b.saveU(u);
        b.saveU(u);
        b.saveU(u);
        b.saveU(u);
        b.getU();
    }
}
