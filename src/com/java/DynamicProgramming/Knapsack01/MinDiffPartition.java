package com.java.DynamicProgramming.Knapsack01;

import java.util.ArrayList;
import java.util.List;

public class MinDiffPartition {
    public static void main(String[] args) {
        int[] nums = {19, 19, 22, 17, 21};
        System.out.println(new MinDiffPartition().minimumDifference(nums));
    }

    public int minimumDifference(int[] nums) {
        int range = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int num : nums) range += num;
        List<Integer> subsetDiff = getSubsetSum(nums, range);
        for (Integer diff : subsetDiff) {
            minDiff = Math.min(minDiff, Math.abs(range - 2*diff));
        }
        return minDiff;
    }

    public List<Integer> getSubsetSum(int[] nums, int sum) {
        Boolean[][] dp = new Boolean[nums.length+1][sum+1];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i==0&&j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else if(j==0) dp[i][j] = true;
                else {
                    if(nums[i-1] <= j) dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < sum + 1; i++) {
            if (dp[nums.length-1][i]) result.add(i);
        }
        return result;
    }
}
