package com.practice;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
       int[][] points = {{1,2,5}, {3 ,1 ,1}, {3,3,3}};
       System.out.println(new Test2().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m+1][n+1];
//        for(int[] row : dp) Arrays.fill(row, -1);
//        return topDown(m, n, dp);
        return bottomUp(m, n);
    }

    private int bottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = dp[i][j-1];
                else if(j == 0) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        print(dp);
        return dp[m-1][n-1];
    }

    private int topDown(int m, int n, int[][] dp) {
        if(m < 1 || n < 1) return 0;
        if(m == 1 && n == 1) {
            dp[m][n] = 1;
            return 1;
        }
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = topDown(m-1, n, dp) + topDown(m, n-1, dp);
    }

    private void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
