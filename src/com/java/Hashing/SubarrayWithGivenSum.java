// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
// Input: nums = [1,2,3], k = 3
// Output: 2
package com.java.Hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1};
        int sum = 3;
        int result = findSubarraysWithSum(arr, sum);
        System.out.println(result);
    }

    private static int findSubarraysWithSum(int[] arr, int sum) {
        if(arr.length == 0) return 0;
        int prefixSum = 0, count = 0;
        // Instead of a set we will use a map so that we can store the count of occurrence of the sum
        Map<Integer, Integer> map = new HashMap<>();
        // we add 0 so that if we find arr[i] to be equal to sum, then it should increment the count
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            // At each iteration, if we can find the difference between the current subarray and sum as a previous subarray,
            // then we are sure that there exists a subarray till arr[i] which has sum as given input
            if(map.containsKey(prefixSum - sum))
                count += map.get(prefixSum - sum);
            // we will store current prefix sum in map so that at each iteration we can check previous sum constant time.
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
