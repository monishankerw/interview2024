package com.crudExample.corejava.exception;

//When an invalid string to number conversion is done we get number format in the exception.
public class NumberFormatException {
    public static void main(String[] args) {
        try{
            String x="xyz";
            int val=Integer.parseInt(x);
            System.out.println(val);
        }
        catch (java.lang.NumberFormatException e){
            e.printStackTrace();
        }
        System.out.println("welcome");
    }
}
