package com.java.DynamicProgramming.LCS;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "abac";
        String Y = "cab";
        System.out.println(shortestCommonSupersequence(X, Y, X.length(), Y.length()));
    }

    public static int shortestCommonSupersequence(String X,String Y,int m,int n) {
        int[][] dp = new int[X.length()+1][Y.length()+1];
        for (int i = 0; i < X.length() + 1; i++) {
            for (int j = 0; j < Y.length() + 1; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else {
                    if(X.charAt(i-1) == Y.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        // Print SCS
        printSCS(X, Y, dp);
        // The trick in this question is to understand that supersequence is nothing but the 2 strings added together and then subtracted by the longest common subsequence
        return m+n-dp[X.length()][Y.length()];
    }

    private static void printSCS(String text1, String text2, int[][] dp) {
        StringBuilder scs = new StringBuilder();
        int i = text1.length();
        int j = text2.length();
        while (i!=0 && j!=0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                scs.append(text1.charAt(i-1));
                i--; j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    scs.append(text1.charAt(i-1));
                    i--;
                }
                else {
                    scs.append(text2.charAt(j-1));
                    j--;
                }
            }
        }
        while (i>0) {
            scs.append(text1.charAt(i-1));
            i--;
        }
        while (j>0) {
            scs.append(text2.charAt(j-1));
            j--;
        }
        System.out.println(scs.reverse());
    }
}
