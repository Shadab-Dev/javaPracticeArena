package com.java.DynamicProgramming.LCS;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "axxxy";
        System.out.println(new LongestRepeatingSubsequence().LongestRepeatingSubsequence(str));
    }

    public int LongestRepeatingSubsequence(String str) {
        String text1 = str, text2 = str;
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else {
                    if(text1.charAt(i-1) == text2.charAt(j-1) && i!=j) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }
}
