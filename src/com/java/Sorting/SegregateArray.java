// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.
// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
package com.java.Sorting;

import java.util.Arrays;

public class SegregateArray {
    public static void main(String[] args) {
        int[] arr = {0};
        int[] result = sortByParity(arr);
        System.out.println(Arrays.toString(result));
    }

    // We will use the concept of hoarse's partition that is used in quicksort
    private static int[] sortByParity(int[] arr) {
        if(arr.length==1) return arr;
        int i = -1, j = arr.length;
        while (true) {
            // increment i when we find an even number on the left side
            do{ i++; } while (i< arr.length && arr[i] % 2 == 0);
            // decrement j when we find an odd number on the right side
            do{ j--; } while (j>-1 && arr[j] % 2 != 0);
            if(i>=j) return arr;
            // swapping will happen when both pointer stop. The element that they point will be the opposite to their condition
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
