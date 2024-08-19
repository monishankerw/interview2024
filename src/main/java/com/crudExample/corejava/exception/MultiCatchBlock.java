package com.crudExample.corejava.exception;


//Q. Can you write multi catch block?
// Ans: Yes, We can create more than one catch block in try catch. We can create child name follow by parent class.
//public class MultiCatchBlock {
//    public static void main(String[] args) {
//        try {
//            int z = 10 / 0; // This will throw an ArithmeticException
//            Integer.parseInt("xyz"); // This will throw a NumberFormatException
//            int a1 = (Integer) null; // This will throw a NullPointerException
//        } catch (ArithmeticException e) {
//            System.out.println(1); // Will be executed when ArithmeticException occurs
//        } catch (NullPointerException e) {
//            System.out.println(2); // Will be executed when NullPointerException occurs
//        } catch (Exception e) {
//            System.out.println(3); // Will be executed when any other Exception occurs
//        }
//    }
//}

