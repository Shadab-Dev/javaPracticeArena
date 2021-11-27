// Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
// Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
// a, b are from arr
// a < b
// b - a equals to the minimum absolute difference of any two elements in arr
// Input: arr = [4,2,1,3]
// Output: [[1,2],[2,3],[3,4]]
// Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
package com.java.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDiffInArr {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> result = minimumAbsDifference(arr);
        System.out.println(result);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length-1; i++) min = Math.min(min, Math.abs(arr[i] - arr[i+1]));
        for (int i = 0; i < arr.length-1; i++) {
            int currentDiff = Math.abs(arr[i] - arr[i+1]);
            if(currentDiff == min) result.add(Arrays.asList(arr[i], arr[i+1]));
        }
        return result;
    }
}
