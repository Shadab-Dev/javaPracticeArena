package com.java.Graphs;

import java.util.Arrays;

public class CountriesCount {
    public static void main(String[] args) {

    }

    int countries_count(int[][] A) {
        if (A.length == 0) return 0;
        int sum = 0;
        int rowLength = A.length;
        int colLength = A[0].length;
        if (rowLength ==0 || colLength==0) return 0;
        int[][] copy = Arrays.stream(A).map(int[]::clone).toArray(int[][]::new);
        for(int i=0; i<rowLength; i++)
            for(int j = 0; j<colLength; j++) {
                if (copy[i][j] >= 0) {
                    findNext(A, copy, i, j, rowLength, colLength);
                    sum ++;
                }
            }
        return sum;
    }

    void findNext(int[][] A, int[][] B, int i, int j, int N, int M)
    {
        if(B[i][j] == -1) return;
        B[i][j] = -1;
        if(i+1 < N)
            if(A[i+1][j] == A[i][j]) findNext(A, B, i+1, j, N, M);
        if(i-1 >= 0)
            if(A[i-1][j] == A[i][j]) findNext(A, B, i-1, j, N, M);
        if(j+1 < M)
            if(A[i][j+1] == A[i][j]) findNext(A, B, i, j+1, N, M);
        if(j-1 >= 0)
            if(A[i][j-1] == A[i][j]) findNext(A, B, i, j-1, N, M);
    }
}
