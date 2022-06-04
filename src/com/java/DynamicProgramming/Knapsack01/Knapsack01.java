package com.java.DynamicProgramming.Knapsack01;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int N = 4;
        int W = 8;
        int[] values = {1,2,5,6};
        int[] weight = {2,3,4,5};
//        System.out.println(new Knapsack01().knapSackRecursive(W, weight, values, N));

        int[][] dp = new int[N+1][W+1];
        for(int[] row : dp) Arrays.fill(row, -1);
//        System.out.println(new Knapsack01().knapSackMemoization(W, weight, values, N, dp));

        int[][] t = new int[N+1][W+1];
        System.out.println(new Knapsack01().knapSackTopDown(W, weight, values, N, t));
    }

    int knapSackRecursive(int W, int wt[], int val[], int n) {
        if(W == 0 || n == 0) return 0;

        if(wt[n-1] <= W) {
            return Math.max(
                    val[n-1] + knapSackRecursive(W-wt[n-1], wt, val, n-1),
                    knapSackRecursive(W, wt, val, n-1)
            );
        } else
            return knapSackRecursive(W, wt, val, n-1);
    }

    int knapSackMemoization(int W, int wt[], int val[], int n, int[][] dp) {
        if(W == 0 || n == 0) return 0;
        if(dp[n][W] != -1) return dp[n][W];

        if(wt[n-1] < W) {
            dp[n][W] = Math.max(val[n-1] + knapSackMemoization(W - wt[n-1], wt, val, n-1, dp), knapSackMemoization(W, wt, val, n-1, dp));
            return dp[n][W];
        } else {
            dp[n][W] = knapSackMemoization(W, wt, val, n-1, dp);
            return dp[n][W];
        }
    }

    int knapSackTopDown(int W, int wt[], int val[], int n, int[][] t) {
        // start the top down iteration where i = N and j = W
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                // Base condition
                if(i == 0 || j == 0) t[i][j] = 0;
                // Add conditions as per recurrence relation
                else if(wt[i-1] <= j) {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println("");
        }
        return t[n][W];
    }
}
