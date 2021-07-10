package com.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 7;
        int[] resultArr = findTwoSum(arr, k);
        System.out.println(Arrays.toString(resultArr));
    }

    private static int[] findTwoSum(int[] arr, int k) {
        int[] resultArr = new int[2];
        Map<Integer, Integer> complements = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(complements.containsKey(k - arr[i])) {
                resultArr[0] = arr[i];
                resultArr[1] = complements.get(k - arr[i]);
                break;
            } else {
                complements.put(arr[i], arr[i]);
            }
        }
        return resultArr;
    }
}
