package com.java;

public class LargestContinuousSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -8, 4, -1, 2};
        int sum = findLargestContinuousSum(arr);
        System.out.println(sum);
    }

    private static int findLargestContinuousSum(int[] arr) {
        int resultSum = 0;
        int currentSum = 0;
        for (int j : arr) {
            currentSum += j;
            if (currentSum > resultSum) resultSum = currentSum;
            if (currentSum < 0) currentSum = 0;
        }
        return resultSum;
    }
}
