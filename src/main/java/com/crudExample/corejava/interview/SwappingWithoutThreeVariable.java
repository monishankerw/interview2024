package com.crudExample.corejava.interview;

public class SwappingWithoutThreeVariable {
    public static void main(String[] args) {
        int a=10,b=20;
        System.out.println("Before Swapping:"+a+" "+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After Swapping:"+a+" "+b);
    }
}