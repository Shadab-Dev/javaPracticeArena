package com.java.DynamicProgramming.LCS;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(new LongestCommonSubstring().longestCommonSubstrDP(s1, s2, s1.length(), s2.length()));
    }

    int longestCommonSubstr(String S1, String S2, int n, int m){
        if(n == 0 || m == 0) return 0;

        if(S1.charAt(n-1) == S2.charAt(m-1)) return 1+longestCommonSubstr(S1, S2, n-1, m-1);
        else return longestCommonSubstr(S1, S2, n-1, m-1);
    }

    int longestCommonSubstrDP(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else {
                    if(S1.charAt(i-1) == S2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                    else dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
