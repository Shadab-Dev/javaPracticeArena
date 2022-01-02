package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        System.out.println(sortArray(arr));
    }

    public static List<Integer> sortArray(int[] nums) {
        // Convert the primitive array into list for easier implementation
        List<Integer> input = new ArrayList<>();
        for(int elem : nums) {
            input.add(elem);
        }
        return helper(input);
    }

    private static List<Integer> helper(List<Integer> nums) {
        // Base condition
        if(nums.size() <= 1) return nums;
        int curr = nums.remove(nums.size()-1);
        // hypothesis: the recursive method will always give us a sorted array of N-1
        nums = helper(nums);
        // Induction: we add the last element in the sorted array
        return insertToSortedArray(nums, curr);
    }

    private static List<Integer> insertToSortedArray(List<Integer> nums, int elem) {
        // Base conditon
        // If there is no elements, or if the last element is already smaller then curr, then we jsut add curr to last and proceed.
        if(nums.size() == 0 || nums.get(nums.size()-1) < elem) {
            nums.add(elem);
            return nums;
        }
        // else we take out the last element from the list.
        int curr = nums.remove(nums.size()-1);
        // Hypothesis: the recursive method will always return an array where is element is inserted at the correct pos
        nums = insertToSortedArray(nums, elem);
        // Induction: we just simply insert the curr element to the last
        nums.add(curr);
        return nums;
    }


}

