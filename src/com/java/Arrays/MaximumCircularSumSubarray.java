// Given an array {5, -2, 3, 4} find the max sum of subarray if its circular
package com.java.Arrays;

public class MaximumCircularSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -2};
        int maxCircSum = maxSubarraySumCircular(arr);
        System.out.println(maxCircSum);
    }

    public static int maxSubarraySumCircular(int[] arr) {
        int maxNormalSum = findMaxSumOfSubArray(arr);
        if(maxNormalSum<0) return maxNormalSum;
        int arraySum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // calculating the total arraySum
            arraySum += arr[i];
            // reversing the elements of the array so that we can find minimum subarray sum
            arr[i] = -1 * arr[i];
        }
        int maxCircularSum = arraySum + findMaxSumOfSubArray(arr);
        System.out.println(maxCircularSum);
        System.out.println(maxNormalSum);
        return Math.max(maxCircularSum, maxNormalSum);
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
