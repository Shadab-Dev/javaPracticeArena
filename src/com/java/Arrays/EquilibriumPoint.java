// Given an array of integers, find if it has an equilibrium point
// An element is considered to be an equilibrium point when sum of elements on its left side is equal to the sum of elements on its right side
// for arr = {3, 4, 8, -9, 20, 6}, eq point is 20
package com.java.Arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = {3, 4, 8, -9, 20, 6};
        int eqPoint = findEquilibriumPoint(arr);
        System.out.println(eqPoint);
    }

    private static int findEquilibriumPoint(int[] arr) {
        // calculate the total array sum
        int totalSum = 0;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - (leftSum + arr[i]);
            if(leftSum == rightSum) return arr[i];
            leftSum += arr[i];
        }
        return -1;
    }
}
