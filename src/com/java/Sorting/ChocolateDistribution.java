// Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
// Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
// 1. Each student gets exactly one packet.
// 2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
// Input:
// N = 8, M = 5
// A = {3, 4, 1, 9, 56, 7, 9, 12}
// Output: 6
// Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :
// {3, 4, 9, 7, 9}.
package com.java.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Long[] arr = {7L, 3L, 2L, 4L, 9L, 12L, 56L};
        long m = 3;
        long minDiff = findMinDiff(Arrays.asList(arr), arr.length, m);
        System.out.println(minDiff);
    }

    public static long findMinDiff(List<Long> a, long n, long m)
    {
        Collections.sort(a);
        long minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n-m+1; i++) {
            minDiff = Math.min(minDiff, a.get(i+(int)m-1) - a.get(i));
        }
        return minDiff;
    }
}
