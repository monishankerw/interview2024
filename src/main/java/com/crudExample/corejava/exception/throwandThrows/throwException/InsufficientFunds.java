package com.crudExample.corejava.exception.throwandThrows.throwException;

public class InsufficientFunds extends Exception{
    public InsufficientFunds(){
        System.out.println("Low Balance!");
    }

}
