// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
package com.java.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWith0and1 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0};
        int result = findLongestSubarray(arr);
        System.out.println(result);
    }

    private static int findLongestSubarray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLength = 0;
        // replace all zeros with -1
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) arr[i] = -1;
        }
        // Use the same technique used in longest subarray with given sum where sum is 0
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum))
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            if(prefixSum == 0)
                maxLength = Math.max(maxLength, i+1);
            map.put(prefixSum, map.getOrDefault(prefixSum, i));
        }
        return maxLength;
    }
}
