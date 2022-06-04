package com.java.DynamicProgramming.MCM;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(matrixMultiplication(arr.length, arr));
    }

    static int matrixMultiplication(int N, int arr[])
    {
        return solve(arr, 1, N-1);
    }

    static int solve(int[] arr, int i, int j) {
        if(i>=j) return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j-1; k++) {
            int tempAns = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min, tempAns);
        }
        return min;
    }
}
