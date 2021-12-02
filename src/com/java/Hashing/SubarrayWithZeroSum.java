// Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
// Input:
//4 2 -3 1 6
//Output:
//Yes
package com.java.Hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 8, 6, 0}; // 4 6 3 4
        boolean result = checkSubarrayWithZeroSum(arr);
        System.out.println(result);
    }

    private static boolean checkSubarrayWithZeroSum(int[] arr) {
        int prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(set.contains(prefixSum) || prefixSum == 0) return true;
            else set.add(prefixSum);
        }
        return false;
    }
}
