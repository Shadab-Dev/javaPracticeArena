// Given a rope of length N, and 3 ways to cut it, a, b and c.
// Find out what is the maximum number of pieces such that every piece has length a, b, or c
package com.java.Recursion;

public class RopeCuttingProblem {
    public static void main(String[] args) {
        int n = 9;
        int max = findMax(n, 2, 2, 2);
        System.out.println(max);
    }

    private static int findMax(int n, int a, int b, int c) {
        if(n==0) return 0;
        if(n<0) return -1;
        int max = Math.max(findMax(n-c, a, b, c), Math.max(findMax(n-a, a, b, c), findMax(n-b, a, b, c)));
        if(max == -1) return -1;
        return max + 1;
    }
}
