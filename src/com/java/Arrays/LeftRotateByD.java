// Given an array, rotate the elements left by D spaces
package com.java.Arrays;

import java.util.Arrays;

public class LeftRotateByD {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = leftRotateByD(arr, 1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] leftRotateByD(int[] arr, int d) {
        // if d is greater than size of array, then subtract size from d which gives the effective no. of rotations
        if(d > arr.length) {
            d = d - arr.length;
        }
        int[] temp = new int[d];
        int count = 0;
        // copy the D elements in an aux array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        // move the n-d elements to the first part of the array
        for (int i = d; i < arr.length; i++) {
            arr[i-d] = arr[i];
        }
        // copy the elements from aux array to the last part of the array
        for (int i = arr.length-d; i < arr.length; i++) {
            arr[i] = temp[count];
            count++;
        }
        return arr;
    }
}
