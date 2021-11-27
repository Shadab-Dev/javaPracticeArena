// Union of two arrays can be defined as the common and distinct elements in the two arrays.
// Given two sorted arrays of size n and m respectively, find their union.
// Input:
// n = 5, arr1[] = {1, 2, 3, 4, 5}
// m = 3, arr2 [] = {1, 2, 3}
// Output: 1 2 3 4 5
package com.java.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {3, 13};
        int[] arr2 = {13, 17, 18, 19, 20, 22, 22, 27, 36, 39, 46, 48, 50};
        List<Integer> result = findUnion(arr1, arr2);
        System.out.println(result);
    }

    private static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while(p1<arr1.length && p2<arr2.length) {
            if(arr1[p1]==arr2[p2]) {
                result.add(arr1[p1]);
                p1++; p2++;
            }
            else if(arr1[p1] > arr2[p2]) result.add(arr2[p2++]);
            else result.add(arr1[p1++]);
        }
        while (p1 < arr1.length) {
            if(result.get(result.size()-1) != arr1[p1]) result.add(arr1[p1]);
            p1++;
        }
        while (p2 < arr2.length) {
            if(result.get(result.size()-1) != arr2[p2]) result.add(arr2[p2]);
            p2++;
        }
        return result;
    }
}
