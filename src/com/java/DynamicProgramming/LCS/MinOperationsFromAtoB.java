package com.java.DynamicProgramming.LCS;

public class MinOperationsFromAtoB {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks", str2 = "geeks";
        System.out.println(new MinOperationsFromAtoB().minOperations(str1, str2));
    }

    public int minOperations(String str1, String str2)
    {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else {
                    if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        // The idea here is to understand that str2 and str1 may have something in common
        // If we find that common part and subtract it from str2 we get the no. of insertions
        // And we subtract it from str1 we get the no. of deletions
        return (str2.length() - dp[str1.length()][str2.length()]) + (str1.length() - dp[str1.length()][str2.length()]);
    }
}
