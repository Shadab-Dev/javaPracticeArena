package com.java.DynamicProgramming.PalindromicSubsequence;

import java.util.Collections;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String S = "abcd";
        System.out.println(new LongestPalindromicSubsequence().longestPalinSubseq(S));
    }

    public int longestPalinSubseq(String S)
    {
        // This question is very similar to LCS
        // The intuition is that every palindromic string is equal to the reverse of itself
        // So we create a reverse and find the longest subseq of these two strings
        String text1 = S;
        String text2 = new StringBuilder(S).reverse().toString();
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else {
                    if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }
}
