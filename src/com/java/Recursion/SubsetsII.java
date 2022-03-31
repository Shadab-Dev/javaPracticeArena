package com.java.Recursion;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubsetsII instance = new SubsetsII();
        System.out.println(instance.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // The idea is to track whether the previous elem is equal to the curr elem
        // For that to work correctly we need to sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), 0, true);
        return result;
    }

    public void helper(int[] nums,
                       List<List<Integer>> result,
                       List<Integer> currList,
                       int ptr,
                       boolean pickedPrev) {

        // Base condition
        if(ptr >= nums.length) {
            result.add(currList);
            return;
        }

        // Since at each recursive stack we have 2 operations on the same picked elem, we keep track using the pickedPrev flag
        // For the first call, we don't pick the elem as output and hence mark the flag as false
        helper(nums, result, new ArrayList<>(currList), ptr+1, false);

        // This is the most important step
        // We check if the curr is equal to prev element and if we have not picked this elem in parent stack, then we don't pick in this stack as well
        // and we follow a linear recursive stack
        if(ptr>0 && nums[ptr]==nums[ptr-1] && !pickedPrev) return;

        // Picking the next element and marking the pickedFlag as true
        currList.add(nums[ptr]);
        helper(nums, result, currList, ptr+1, true);
    }
}
