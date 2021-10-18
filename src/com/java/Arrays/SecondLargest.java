package com.java.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 10};
        int second = findSecondLargest(arr);
        System.out.println(second);
    }

    private static int findSecondLargest(int[] arr) {
        if(arr.length == 0) return -1;
        if(arr.length == 1) return arr[0];
        int largest = arr[0];
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                second = largest;
                largest = arr[i];
            }
            else if(arr[i] != largest && arr[i] >= second) second = arr[i];
        }

        // If there are same numbers throughout the array, then return largest
        if(second == Integer.MIN_VALUE) return largest;
        return second;
    }
}
