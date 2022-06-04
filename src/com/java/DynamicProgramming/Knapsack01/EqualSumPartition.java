package com.java.DynamicProgramming.Knapsack01;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
//        int[] nums = {1,5,11,5};
        int total = new EqualSumPartition().getSum(nums, nums.length);
        if(total % 2 != 0) System.out.println(false);
        else System.out.println(new EqualSumPartition().canPartitionBottomUp(nums, nums.length, total/2));
    }

    public boolean canPartition(int[] nums, int n, int sum) {
        if(sum == 0) return true;
        if(n == 0) return false;

        if(nums[n-1] <= sum) return canPartition(nums, n-1, sum-nums[n-1]) || canPartition(nums, n-1, sum);
        else return canPartition(nums, n-1, sum);
    }

    public boolean canPartitionBottomUp(int[] nums, int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i==0&&j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else if(j==0) dp[i][j] = true;
                else {
                    if(nums[i-1]<=j) dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private int getSum(int[] nums, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        return sum;
    }
}
