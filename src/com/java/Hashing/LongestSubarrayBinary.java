// Given two binary arrays arr1[] and arr2[] of same size N. Find the longest subarray which has equal sum
// Input:
// Arr1[] = {0, 1, 0, 0, 0, 0}
// Arr2[] = {1, 0, 1, 0, 0, 1}
// Output: 4
// Explanation: The longest span with same
// sum is from index 1 to 4 following zero based indexing.
package com.java.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayBinary {
    public static void main(String[] args) {
        boolean[] arr1 = {false, true, false, false, false, false};
        boolean[] arr2 = {true, false, true, false, false, true};
        int result = findLongestSubarray(arr1, arr2);
        System.out.println(result);
    }

    private static int findLongestSubarray(boolean[] arr1, boolean[] arr2) {
        int[] diff = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, length = 0;
        // create a diff array
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] && arr2[i]) diff[i] = 2;
            else if(!arr1[i] && arr2[i]) diff[i] = -1;
            else if(arr1[i] && !arr2[i]) diff[i] = 1;
            else diff[i] = 0;
        }
        System.out.println(Arrays.toString(diff));
        // apply the same logic as we used in finding the longest subarray with given sum
        for (int i = 0; i < diff.length; i++) {
            prefixSum += diff[i];
            if(map.containsKey(prefixSum))
                length = Math.max(length, i - map.get(prefixSum));
            if(prefixSum == 0)
                length = Math.max(length, i+1);
            map.put(prefixSum, map.getOrDefault(prefixSum, i));
        }
        return length;
    }
}
