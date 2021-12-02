// Given an array containing N integers and an integer K.,
// Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
// Input :
// A[] = {10, 5, 2, 7, 1, 9}
// K = 15
// Output : 4
package com.java.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {-7, 17, -12, 2, 11, -1, 4, 11, -18};
        int sum = 25;
        int result = findLongestSubarray(arr, sum);
        System.out.println(result);
    }

    private static int findLongestSubarray(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum - sum))
                maxLength = Math.max(maxLength, i - map.get(prefixSum - sum));
            if(prefixSum == sum)
                maxLength = Math.max(maxLength, i+1);
            map.put(prefixSum, map.getOrDefault(prefixSum, i));
        }
        return maxLength;
    }
}
