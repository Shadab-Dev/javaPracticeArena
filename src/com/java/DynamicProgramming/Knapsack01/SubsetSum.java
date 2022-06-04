package com.java.DynamicProgramming.Knapsack01;

public class SubsetSum {
    public static void main(String[] args) {
        int N = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(new SubsetSum().isSubsetSumBottomUp(N, arr, sum));
    }

    Boolean isSubsetSumRecursive(int N, int arr[], int sum){
        if(N == 0 && sum > 0) return false;
        if(N == 0 && sum == 0) return true;

        if(arr[N-1] <= sum) {
            return (isSubsetSumRecursive(N-1, arr, sum-arr[N-1]) || isSubsetSumRecursive(N-1, arr, sum));
        } else {
            return isSubsetSumRecursive(N-1, arr, sum);
        }
    }

    Boolean isSubsetSumMemoization(int N, int arr[], int sum, int[][] dp){
        // Check the memcache to see if we have solved this subproblem earlier
        if(dp[N][sum] != -1) {
            if(dp[N][sum] == 0) return false;
            if(dp[N][sum] == 1) return true;
        }
        // Base case: Found a subset which has the given sum
        if(sum == 0) {
            dp[N][sum] = 1;
            return true;
        }
        // Base case: We have reached the end of the array but did not find a subset with the given sum
        if(N == 0 && sum > 0) {
            dp[N][sum] = 0;
            return false;
        }

        Boolean result;
        if(arr[N-1] <= sum) {
            result = (isSubsetSumMemoization(N-1, arr, sum-arr[N-1], dp) || isSubsetSumMemoization(N-1, arr, sum, dp));
            dp[N][sum] = (result) ? 0 : 1;
        } else {
            result = isSubsetSumMemoization(N-1, arr, sum, dp);
            dp[N][sum] = (result) ? 0 : 1;
        }
        return result;
    }

    Boolean isSubsetSumBottomUp(int N, int arr[], int sum) {
        Boolean[][] t = new Boolean[N+1][sum+1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i==0 && j==0) t[i][j] = true;
                else if(i==0) t[i][j] = false;
                else if(j==0) t[i][j] = true;
                else {
                    if(arr[i-1] <= j) t[i][j] = (t[i-1][j - arr[i-1]] || t[i-1][j]);
                    else t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][sum];
    }
}
