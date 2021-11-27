// Given an array [100, 200, 300, 400], find the max sum of elements falling in a window of size K
package com.java.SlidingWindow;

import java.util.ArrayList;

public class MaxSubarraySumInWindow {
    public static void main(String[] args) {
        int[] arr = {62, 255, 127, 160, 245};
        int windowSize = 4;
        int maxSum = findMaxSubarraySum(arr, windowSize);
        System.out.println(maxSum);
    }

    private static int findMaxSubarraySum(int[] arr, int windowSize) {
        int maxSum,
            currentSum = 0;

        // calculate for first iteration
        for (int i = 0; i < windowSize; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;
        for (int i = 1; i <= arr.length - windowSize; i++) {
            currentSum -= arr[i-1];
            currentSum += arr[i+windowSize-1];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
