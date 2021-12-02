// Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.
// Input:
//arr[] = {3,1,2,2,1,2,3,3}
// k = 4
// Output: 2
// Explanation: In the given array, 3 and 2 are the only elements that appears more than n/k times.
package com.java.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrence {
    public static void main(String[] args) {
        int[] arr = {3,1,2,2,1,2,3,3,3};
        int k = 4;
        int result = countNKOccurrence(arr, k);
        System.out.println(result);
    }

    private static int countNKOccurrence(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int count = arr.length / k;
        for(int elem : arr) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        for(int freq : map.values()) {
            if(freq > count) result++;
        }
        return result;
    }
}
