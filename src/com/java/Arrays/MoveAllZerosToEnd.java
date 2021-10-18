// Given an array with some zeros, move all the zeros to the last of the array while maintaining the order
package com.java.Arrays;

import java.util.Arrays;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {8, 5, 0, 10, 0, 20};
        int[] result = moveZeros(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] moveZeros(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        return arr;
    }
}
