// Given arr = {1, 2, 3, 4, 5}, left rotate this arr
// Ans = {2, 3, 4, 5, 1}
package com.java.Arrays;

import java.util.Arrays;

public class LeftRotateByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = leftRotate(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] leftRotate(int[] arr) {
        int elem = arr[0];
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[i] = elem;
        return arr;
    }
}
