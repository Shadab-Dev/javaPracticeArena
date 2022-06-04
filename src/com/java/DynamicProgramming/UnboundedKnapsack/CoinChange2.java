package com.java.DynamicProgramming.UnboundedKnapsack;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
//        System.out.println(new CoinChange2().changeRecursive(amount, coins, coins.length));
        System.out.println(new CoinChange2().change(amount, coins));
    }

    public int changeRecursive(int amount, int[] coins, int n) {
        if(amount == 0) return 1;
        if(n == 0) return 0;

        if(coins[n-1] <= amount) return changeRecursive(amount-coins[n-1], coins, n) + changeRecursive(amount, coins, n-1);
        else return changeRecursive(amount, coins, n-1);
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if(j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = 0;
                else {
                    if(coins[i-1] <= j) dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
