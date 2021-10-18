// N-bonacci numbers are like fibonacci but instead of calculating sum of previous 2 we calculate the sum of previous N
// At the start the first N-1 elements will be 0 and the Nth element will be 1.
package com.java.Arrays;

import java.util.Arrays;

public class NbonacciNumbers {
    public static void main(String[] args) {
        int[] result = printNbonacciNumbers(4, 8);
        System.out.println(Arrays.toString(result));
    }

    private static int[] printNbonacciNumbers(int n, int m) {
        if(n>m) return null;
        if(n==m) return new int[]{0};
        int[] result = new int[m];
        int currentSum = 0;
        int start = 0;

        // prefil the first n numbers with 0 and last elem as 1
        // Also calc the sum at each iteration
        for(int i = 0; i<n; i++) {
            if(i == n-1) result[i] = 1;
            else result[i] = 0;
            currentSum+=result[i];
        }
        for (int i = n; i < m; i++) {
            // the next elem will be the sum of N elements
            result[i] = currentSum;
            // we need to move the window, so we add the current elem to sum
            currentSum+= result[i];
            // then subtract the first elem
            currentSum-= result[start];
            // we change the window from start to start+1 to i
            start++;
        }
        return result;
    }
}
