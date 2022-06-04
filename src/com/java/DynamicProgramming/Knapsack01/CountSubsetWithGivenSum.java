package com.java.DynamicProgramming;

public class CountSubsetWithGivenSum {
    public static void main(String[] args) {
        int N = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 12;
        System.out.println(new CountSubsetWithGivenSum().countSubsetSumDP(N, arr, sum));
    }

    public int countSubsetSum(int n, int[] arr, int sum) {
        if(sum == 0) return 1;
        if(n == 0) return 0;

        if(arr[n-1]<=sum) {
            return countSubsetSum(n-1, arr, sum-arr[n-1]) + countSubsetSum(n-1, arr, sum);
        } else return countSubsetSum(n-1, arr, sum);
    }

    public int countSubsetSumDP(int n, int[] arr, int sum) {
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i==0&&j==0) dp[i][j] = 1;
                else if(i==0) dp[i][j] = 0;
                else if(j==0) dp[i][j] = 1;
                else {
                    if(arr[i-1] <= j) dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
