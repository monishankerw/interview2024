package com.crudExample.corejava.collection.set.TreeSet;

import java.util.Optional;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(30);
        treeSet.add(20);
        treeSet.add(12);
        treeSet.add(43);
        treeSet.add(12);
        treeSet.add(20);
        System.out.println(Optional.ofNullable(null));
        System.out.println(treeSet);
    }
}

