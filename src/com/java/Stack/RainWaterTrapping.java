// Given an array with the heights of buildings, Find out what is the maximum units of water that will be trapped
// arr = {3, 0, 0, 2, 0, 4}, here the answer will be 10
package com.java.Stack;

import java.util.Arrays;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        int unitsOfWater = findTrappedWater(arr);
        System.out.println(unitsOfWater);
    }

    private static int findTrappedWater(int[] arr) {
        int[] leftMax = findMaxInLeft(arr);
        int[] rightMax = findMaxInRight(arr);
        int totalTrappedWater = 0;
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        for (int i = 0; i < arr.length; i++) {
            int waterAtCurrentBuilding = Math.min(leftMax[i], rightMax[i]) - arr[i];
            totalTrappedWater += waterAtCurrentBuilding;
        }
        return totalTrappedWater;
    }

    private static int[] findMaxInRight(int[] arr) {
        int[] right = new int[arr.length];
        right[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i > -1; i--) {
            if(arr[i] > right[i+1]) right[i] = arr[i];
            else right[i] = right[i+1];
        }
        return right;
    }

    private static int[] findMaxInLeft(int[] arr) {
        int[] left = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > left[i-1]) left[i] = arr[i];
            else left[i] = left[i-1];
        }
        return left;
    }
}
