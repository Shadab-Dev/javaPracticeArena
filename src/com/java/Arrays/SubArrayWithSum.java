// Given an array with all positive integers, {1, 4, 20, 3, 10, 5} find the subarray which has the sum as 33
// Use the sliding window technique
package com.java.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        List<Integer> subArray  = findSubArrayWithSum(arr, 3);
        System.out.println(subArray);
    }

    private static List<Integer> findSubArrayWithSum(int[] arr, int sum) {
        List<Integer> result = new ArrayList<>();
        int currentSum = 0;
        int start = 0;
        int end = 0;
        while (end < arr.length || start > end) {
            if(currentSum == sum) {
                result.add(start);
                result.add(end-1);
                return result;
            } else if (currentSum < sum) {
                currentSum += arr[end];
                end++;
            } else {
                currentSum -= arr[start];
                start++;
            }
        }
        // Adding another check for boundary condition in case end > arr.length
        if(currentSum == sum) {
            result.add(start);
            result.add(end-1);
            return result;
        }
        return result;
    }
}
