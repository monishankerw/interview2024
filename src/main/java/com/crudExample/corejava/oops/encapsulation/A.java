package com.crudExample.corejava.oops.encapsulation;

public class A {
    private int i;
    public void SetI(int i){
        this.i=i;
    }
    public int GetI(){
        return i;
    }

    public static void main(String[] args) {
        A a=new A();
        a.SetI(12);

        System.out.println(a.GetI());
    }
}
