// Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
// Input:
// N = 7, K = 4
// A[] = {1,2,1,3,4,2,3}
// Output: 3 4 4 3
package com.java.Hashing;

import java.util.*;

public class DistinctElementsInWindow {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        int windowSize = 4;
        ArrayList<Integer> count = countInEachWindow(arr, windowSize);
        System.out.println(count);
    }

    private static ArrayList<Integer> countInEachWindow(int[] arr, int windowSize) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i;
        // add elements in map for first window
        for (i = 0; i < windowSize; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        i--;
        result.add(map.size());
        for (int j = 0; j < arr.length-windowSize; j++) {
            // decrement window
            map.put(arr[j], map.get(arr[j])-1);
            if(map.get(arr[j]) <= 0) map.remove(arr[j]);
            // increment window
            i++;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            result.add(map.size());
        }
        return result;
    }
}
