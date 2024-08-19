package com.crudExample.corejava.string;

public class CountWord {
    public static void main(String[] args) {
        String str="Java Developer";
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' ')
                count++;
        }
        System.out.println(count);
    }
}
