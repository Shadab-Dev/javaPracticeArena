// Given an array of integers. Find the Inversion Count in the array.
// Input: N = 5, arr[] = {2, 4, 1, 3, 5}
// Output: 3
package com.java.Sorting;

public class CountInversions {
    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        long result = inversionCount(arr, arr.length-1);
        System.out.println(result);
    }

    static long inversionCount(long arr[], long N)
    {
        return getCount(arr, 0, (int)N);
    }

    private static int getCount(long[] arr, int low, int high) {
        int result = 0;
        if(low<high) {
            int mid = low + (high-low)/2;
            result += getCount(arr, low, mid);
            result += getCount(arr, mid+1, high);
            result += countAndMerge(arr, low, mid, high);
        }
        return result;
    }

    private static int countAndMerge(long[] arr, int low, int mid, int high) {
        long[] a1 = new long[mid-low+1];
        long[] a2 = new long[high-mid];
        int p1 = 0, p2 = 0, pArr = low, count = 0;
        // fill in both the arrays with the unsorted values
        for (int i = 0; i < a1.length; i++) a1[i] = arr[low+i];
        for (int i = 0; i < a2.length; i++) a2[i] = arr[mid+1+i];

        while (p1<a1.length && p2<a2.length) {
            if(a1[p1] <= a2[p2]) arr[pArr++] = a1[p1++];
            else {
                arr[pArr++] = a2[p2++];
                // if we find an element which is smaller
                // then, that element will form an inversion with all the remaining elements in a1
                // We find the remaining elements in a1 by subtracting the a1 pointer with its size which is mid-low+1
                count = count + (mid-low+1-p1);
            }
        }
        while (p1<a1.length) arr[pArr++] = a1[p1++];
        while (p2<a2.length) arr[pArr++] = a2[p2++];
        return count;
    }

}
