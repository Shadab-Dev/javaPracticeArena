package com.java.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        Map<String, Integer> dp = new HashMap<>();
        System.out.println(new TargetSum().findTargetSumWayMemoization(nums, nums.length, target, dp));
    }

    public int findTargetSumWayMemoization(int[] nums, int n, int target, Map<String, Integer> dp) {
        // Simple trick to create keys when we have multiple states
        String currKey = n +"->"+ target;
        // Memoization in action
        if(dp.containsKey(currKey)) return dp.get(currKey);

        // In the base condition, we must make sure that we have traversed through all elements, hence n == 0
        if(n == 0 && target == 0) return 1;
        if(n == 0) return 0;

        int positive = findTargetSumWayMemoization(nums, n-1, target + nums[n-1], dp);
        int negative = findTargetSumWayMemoization(nums, n-1, target - nums[n-1], dp);
        dp.put(currKey, positive+negative);
        return positive+negative;
    }

}
