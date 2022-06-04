package com.java.DynamicProgramming.LCS;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";

        Map<String, Integer> cache = new HashMap<>();
        long start = new Date().getTime();
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequenceMemoization(text1, text2, cache));
        System.out.println("Time Taken in millis: " + Math.subtractExact(new Date().getTime(), start));

        long start2 = new Date().getTime();
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequenceDP(text1, text2));
        System.out.println("Time Taken in millis: " + Math.subtractExact(new Date().getTime(), start2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) return 0;

        int n1 = text1.length()-1;
        int n2 = text2.length()-1;
        if(text1.charAt(n1) == text2.charAt(n2)) return 1 + longestCommonSubsequence(text1.substring(0, n1), text2.substring(0, n2));
        else return Math.max(longestCommonSubsequence(text1.substring(0, n1), text2), longestCommonSubsequence(text1, text2.substring(0, n2)));
    }

    public int longestCommonSubsequenceMemoization(String text1, String text2, Map<String, Integer> cache) {
        String key = text1+"->"+text2;
        if(cache.containsKey(key)) return cache.get(key);

        if(text1.length() == 0 || text2.length() == 0) {
            cache.put(key, 0);
            return cache.get(key);
        }

        int n1 = text1.length()-1;
        int n2 = text2.length()-1;
        int result;

        if(text1.charAt(n1) == text2.charAt(n2)) result = 1 + longestCommonSubsequenceMemoization(text1.substring(0, n1), text2.substring(0, n2), cache);
        else result = Math.max(longestCommonSubsequenceMemoization(text1.substring(0, n1), text2, cache),
                longestCommonSubsequenceMemoization(text1, text2.substring(0, n2), cache));

        cache.put(key, result);
        return result;
    }

    public int longestCommonSubsequenceDP(String text1, String text2) {
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

        // Printing the longest common subsequence
        printLCS(text1, text2, dp);
        return dp[text1.length()][text2.length()];
    }

    private void printLCS(String text1, String text2, int[][] dp) {
        StringBuilder lcs = new StringBuilder();
        int i = text1.length();
        int j = text2.length();
        while (i!=0 && j!=0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                lcs.append(text1.charAt(i-1));
                i--; j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }
        System.out.println(lcs.reverse());
    }
}
