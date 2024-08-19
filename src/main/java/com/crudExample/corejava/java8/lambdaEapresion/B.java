package com.crudExample.corejava.java8.lambdaEapresion;


import com.crudExample.corejava.java8.functionalInterface.A;

public class B {
    public static void main(String[] args) {
        A b=()->{
            System.out.println(122);
            System.out.println(111);

        };
b.test();
    }
}
