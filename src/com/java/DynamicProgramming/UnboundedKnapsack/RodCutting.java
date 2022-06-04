package com.java.DynamicProgramming.UnboundedKnapsack;

public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
//        System.out.println(new RodCutting().cutRodRecursive(price, price.length, price.length));
        System.out.println(new RodCutting().cutRodDP(price, price.length));
    }

    public int cutRodRecursive(int[] price, int currLength, int n) {
        if(n == 0) return currLength * price[0];

        int rodLength = n+1;
        if(rodLength <= currLength) return Math.max(price[n] + cutRodRecursive(price, currLength - rodLength, n), cutRodRecursive(price, currLength, n-1));
        else return cutRodRecursive(price, currLength, n-1);
    }

    public int cutRodDP(int[] price, int maxLength) {
        int[][] dp = new int[price.length+1][maxLength+1];
        for (int i = 0; i < price.length + 1; i++) {
            for (int j = 0; j < maxLength + 1; j++) {
                if(i==0) dp[i][j] = j*price[0];
                else {
                    int rodLength = i+1;
                    if(rodLength <= j) dp[i][j] = Math.max(dp[i][j-rodLength] + price[i], dp[i-1][j]);
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[price.length][maxLength];
    }
}
