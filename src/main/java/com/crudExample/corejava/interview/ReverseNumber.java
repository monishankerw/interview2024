package com.crudExample.corejava.interview;

public class ReverseNumber {
    public static void main(String[] args) {
        int rev = 0, num = 12345;
        while (num != 0) {
            rev = rev *10+ num % 10;
            num = num / 10;
        }
        System.out.println(rev);
    }
}
