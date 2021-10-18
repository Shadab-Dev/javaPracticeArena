// Given an array = {2, 3, 10, 6, 4, 8, 1} find the maximum difference between arr[i] and arr[j] such that j > i
// here the answer will be 10 - 2 = 8
package com.java.Arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        int diff = findMaxDifference(arr);
        System.out.println(diff);
    }

    private static int findMaxDifference(int[] arr) {
        int minVal = arr[0];
        int res = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(arr[i] - minVal, res);
            minVal = Math.min(arr[i], minVal);
        }
        return res;
    }
}
