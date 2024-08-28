package com.crudExample.corejava.interview;

import java.util.HashMap;
import java.util.Map;

public class SumOfNotDuplicateElements {
    public static void main(String[] args) {
        int arr[]={1,2,1,2,3,4,5,5};
        sumOfWithOutReapetedElements(arr);
    }

    private static void sumOfWithOutReapetedElements(int[] arr) {
        int sum=0;
        Map<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        for (int key:map.keySet()){
            if (map.get(key)==1){
                sum=sum+key;
            }
        }
        System.out.println(sum);
    }
}
