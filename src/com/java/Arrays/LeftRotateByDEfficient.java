// Given an array, rotate the elements left by D spaces
package com.java.Arrays;

import java.util.Arrays;

public class LeftRotateByDEfficient {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = leftRotateByD(arr, 8);
        System.out.println(Arrays.toString(result));
    }

    private static int[] leftRotateByD(int[] arr, int d) {
        if(d > arr.length) {
            d = d - arr.length;
        }
       reverse(arr, 0, d-1);
       reverse(arr, d, arr.length-1);
       reverse(arr, 0, arr.length-1);
       return arr;
    }

    private static void reverse(int[] arr, int low, int high) {
        while(low<high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++; high--;
        }
    }
}
