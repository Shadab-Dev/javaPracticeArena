package com.java.DynamicProgramming.PalindromicSubsequence;

public class MinInsertionsToMakePalindrome {
    public static void main(String[] args) {
        System.out.println(new MinInsertionsToMakePalindrome().minInsertions("leetcode"));
    }

    public int minInsertions(String s) {
        String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();
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
        // The intuition is the same as longest palindrome subseq here we just need to remove the remaining chars
        return s.length() - dp[text1.length()][text2.length()];
    }
}
