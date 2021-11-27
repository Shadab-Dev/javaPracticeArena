// Given an infinite binary array which is sorted, find the first index of 1.
// arr = { 0, 0, 0, 1, 1, 1.....
// index should be 3
package com.java.Searching;

public class IndexOf1BinarySortedArr {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int index = firstOccurence(arr);
        System.out.println(index);
    }

    private static int firstOccurence(int[] arr) {
        int start = 0;
        int end = start + 1;
        int multiplier = 2;

        while(arr[end] != 1) {
            start = end;
            end *= multiplier;
        }
        return findFirstOccurenceInWindow(arr, start, end);
    }

    private static int findFirstOccurenceInWindow(int[] arr, int start, int end) {
        int index = -1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == 1) {
                index = mid;
                end = mid-1;
            }
            if(arr[mid] == 0) start = mid+1;
        }
        return index;
    }
}
