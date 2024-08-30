

          Run Time Polymorphism
-> It is also known as Dynamic Method Dispatch.
-> During run time any child class address object injected into reference variable than calling the method is called as 
Runtime Polymorphism.


public class A {
public void test(){
System.out.println(100);
}
public static class B extends A{
@Override
public void test() {
System.out.println(100);
}

        public static void main(String[] args) {
            A a=new A();
            a.test();
        }
    }
}


package com.crudExample.corejava.oops.polymorphism.RunTimePolymorphism;

public class Parent {
public void test() {
System.out.println("Parent Class:");
}

    // Adding the print method to the Parent class
    public void print() {
        System.out.println("Parent Class print method");
    }

    public static class Subclass1 extends Parent {
        @Override
        public void print() {
            System.out.println("Subclass1:");
        }
    }

    public static class Subclass2 extends Parent {
        @Override
        public void print() {
            System.out.println("Subclass2:");
        }

        public static void main(String[] args) {
            Parent parent = new Subclass1();
            parent.print(); // Calls Subclass1's print method

            Parent parent1 = new Subclass2();
            parent1.print(); // Calls Subclass2's print method
        }
    }
}

Rule of Method Overloading

1. Overriding and Access-Modifiers
--> The access modifier for an overriding method can allow more, but not less, access than the override method.

Example: A Protected instance method in the super-class can be made public but not private.


  