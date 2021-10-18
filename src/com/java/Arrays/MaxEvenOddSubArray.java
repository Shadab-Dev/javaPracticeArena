// Given an array {10, 12, 14, 7, 8} find the max subarray which has even odd alternating pattern
// here {14, 7, 8} has this pattern so answer will be 3
package com.java.Arrays;

public class MaxEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 6, 3, 8};
        int max = findMaxEvenOdd(arr);
        System.out.println(max);
    }

    private static int findMaxEvenOdd(int[] arr) {
        int max = 1;
        int currentMax = 1;
        boolean isEven = (arr[0] % 2 == 0);
        for (int i = 1; i < arr.length; i++) {
            // At each iteration we check if the previous element is even
            if(isEven == true) {
                // If its even then the current elem should be odd,
                // then only we can increment the currentMax
                if(arr[i] % 2 != 0) {
                    // we need to set the flag as false as the next elem should now be even for the pattern to hold
                    isEven = false;
                    currentMax++;
                    max = Math.max(max, currentMax);
                } else {
                    currentMax = 1;
                }
            // We do the exact opposite if the previous element is odd
            } else {
                if(arr[i] % 2 == 0) {
                    isEven = true;
                    currentMax++;
                    max = Math.max(max, currentMax);
                } else {
                    currentMax = 1;
                }
            }
        }
        return max;
    }
}
