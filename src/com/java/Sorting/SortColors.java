// Given an array nums with n objects colored red, white, or blue,
// sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.
// Example: Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
package com.java.Sorting;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        // [2,0,1]
        // [0]
        // [1]
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortColors(int[] arr) {
        int i = 0, j = arr.length-1, mid = 0;
        while(mid<=j) {
            if(arr[mid] == 0) swap(arr, mid++, i++);
            else if(arr[mid] == 1) mid++;
            else if(arr[mid] == 2) swap(arr, mid, j--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
