// Given a sorted array, remove all duplicates by keeping the distinct elements at the first
package com.java.Arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 30, 30};
        int[] result = findDistinct(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findDistinct(int[] arr) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[res-1]){
                arr[res] = arr[i];
                res++;
            }
        }
        return arr;
    }
}
