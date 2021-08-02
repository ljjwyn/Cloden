package com.example.gloden.coures;

public class FooAException extends RuntimeException{
    public void f(){
        try {
            this.g();
        }catch (FooAException f){
            throw new FooBException();
        }
    }
    public void g(){
        throw new FooAException();
    }

    public static void main(String[] args) {
        FooAException fooAException = new FooAException();
        fooAException.f();
    }
}
