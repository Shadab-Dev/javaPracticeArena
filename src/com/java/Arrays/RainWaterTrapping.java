// Given an array of building heights, find the amount of water that will be trapped
package com.java.Arrays;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 2, 5};
        int waterTrapped = findWaterTrapped(arr);
        System.out.println(waterTrapped);
    }

    private static int findWaterTrapped(int[] arr) {
        int n = arr.length;
        int[] heightOfLeft = new int[n];
        int[] heightOfRight = new int[n];
        heightOfLeft[0] = arr[0];
        heightOfRight[n-1] = arr[n-1];
        int waterTrapped = 0;

        for (int i = 1; i < arr.length; i++) {
            heightOfLeft[i] = Math.max(heightOfLeft[i], heightOfLeft[i-1]);
        }
        for (int i = n-2; i > -1; i--) {
            heightOfRight[i] = Math.max(heightOfRight[i], heightOfRight[i+1]);
        }

        for (int i = 0; i < n; i++) {
            int currentWater = Math.min(heightOfLeft[i], heightOfRight[i]) - arr[i];
            if(currentWater > 0) waterTrapped += currentWater;
        }
        return waterTrapped;
    }
}
