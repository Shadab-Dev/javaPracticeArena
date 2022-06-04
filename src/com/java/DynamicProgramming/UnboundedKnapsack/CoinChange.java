package com.java.DynamicProgramming.UnboundedKnapsack;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount = 27;
        System.out.println(new CoinChange().coinChangeRecursive(coins, amount, coins.length, 0));
//        System.out.println(new CoinChange().coinChange(coins, amount));
    }

    public int coinChangeRecursive(int[] coins, int amount, int n, int count) {
        if(amount == 0) return count;
        if(n == 0) return Integer.MAX_VALUE;

        if(coins[n-1] <= amount) return Math.min(coinChangeRecursive(coins, amount-coins[n-1], n, count+1), coinChangeRecursive(coins, amount, n-1, count));
        else return coinChangeRecursive(coins, amount, n-1, count);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                // Initialize first row
                if(i == 0) dp[i][j] = Integer.MAX_VALUE-1;
                // Initialize first column
                else if(j == 0) dp[i][j] = 0;
                // Initialize second row (Only specific to coin change problem)
                else if(i == 1) {
                    if(j % coins[0] == 0) dp[i][j] = j/coins[0];
                    else dp[i][j] = Integer.MAX_VALUE-1;
                }
                else {
                    if(coins[i-1] <= j) dp[i][j] = Math.min(1+ dp[i][j-coins[i-1]], dp[i-1][j]);
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (dp[coins.length][amount] >= Integer.MAX_VALUE-1) ? -1 : dp[coins.length][amount];
    }
}
