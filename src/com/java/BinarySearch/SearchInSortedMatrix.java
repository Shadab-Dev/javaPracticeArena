// Given a 2D array which is sorted both row-wise and column-wise, return the index of the elem
// https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
package com.java.BinarySearch;

import java.util.Arrays;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int elem = 25;
        int[] index = searchInSortedMatrix(arr, elem);
        System.out.println(Arrays.toString(index));
    }

    private static int[] searchInSortedMatrix(int[][] arr, int elem) {
        int m = arr.length;
        int n = arr[0].length;
        int i = 0;
        int j = n-1;
        while(i>-1 && i<m && j>-1 && j<n) {
            if(arr[i][j] == elem) return new int[]{i, j};
            else if(elem < arr[i][j]) j--;
            else if(elem > arr[i][j]) i++;
        }
        return new int[]{-1,-1};
    }
}
