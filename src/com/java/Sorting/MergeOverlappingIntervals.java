// Given an array of intervals where intervals[i] = [starti, endi],
// merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
package com.java.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,4}, {0, 0}};
        int[][] result = merge(arr);
        for (int[] elem : result) System.out.println(Arrays.toString(elem));
    }

    public static int[][] merge(int[][] intervals) {
        // We will use the idea of merging the previous element with the current element if the curr elem overlaps
        // first we sort the array with start element
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // we use res to denote the previous element
        int res = 0;
        // we start with i = 1 since we will compare with res which is 0
        for (int i = 1; i < intervals.length; i++) {
            // If the current start falls before the previous end, then we can be sure the curr elem is overlapping
            if(intervals[i][0] <= intervals[res][1]) {
                // we update the res to the merged element
                intervals[res][0] = Math.min(intervals[res][0], intervals[i][0]);
                intervals[res][1] = Math.max(intervals[res][1], intervals[i][1]);
            }
            // If that is not true, then we just move res to the next element
            else {
                res++;
                intervals[res] = intervals[i];
            }
        }
        // to send the final result, we consider elements only till res
        int[][] finalResult = new int[res+1][2];
        for (int i = 0; i <= res ; i++) {
            finalResult[i] = intervals[i];
        }
        return finalResult;
    }
}
