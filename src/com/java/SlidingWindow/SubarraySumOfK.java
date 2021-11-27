// Given an array containing N integers and an integer K.,
// Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
// This approach only considers positive numbers
// Input :
// A[] = {10, 5, 2, 7, 1, 9}
// K = 15
// Output : 4
package com.java.SlidingWindow;

public class SubarraySumOfK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println(findLargestSubarray(arr, k));
    }

    private static int findLargestSubarray(int[] arr, int k) {
        int start = 0, end = 0, currentSum = 0, result = 0;
        while(end<arr.length && start<arr.length) {
            currentSum += arr[end];
            if(currentSum < k) end++;
            else if(currentSum == k) {
                result = Math.max(result, end-start+1);
                end++;
            } else {
                while (currentSum > k) currentSum -= arr[start++];
            }
        }
        return result;
    }
}
