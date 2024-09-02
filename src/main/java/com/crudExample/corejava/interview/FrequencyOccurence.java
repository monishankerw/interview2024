package com.crudExample.corejava.interview;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOccurence {
    public static void main(String[] args) {
        
    int arr[]={12,11,13,12,11,14,13,11,13,13};
    frequencyOccurence(arr);
}

    private static void frequencyOccurence(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" :"+entry.getValue());
        }
    }
    }
