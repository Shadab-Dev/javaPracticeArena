// Given an array {2, 3, -8, 7, -1, 2, 3} find the max sum of subarray
package com.java.Arrays;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr = {-5, -2, -1};
        int maxSum = findMaxSumOfSubArray(arr);
        System.out.println(maxSum);
    }

    private static int findMaxSumOfSubArray(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
