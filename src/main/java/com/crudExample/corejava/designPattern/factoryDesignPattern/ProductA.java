package com.crudExample.corejava.designPattern.factoryDesignPattern;


// Concrete Product A
public class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}
