package com.crudExample.corejava.string;

public class ReverseCharacter {
    public static void main(String[] args) {

        char[] chars = {'a', 'd', 'q', 'p', 'e'};
        reverseChars(chars);
        System.out.println(chars);
    }

    private static void reverseChars(char[] chars) {
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
