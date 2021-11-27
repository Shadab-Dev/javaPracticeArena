// Given a sorted array, find first and last occurrence of a repeated number
// arr = { 1, 2, 2, 3, 4}
// first = 1
// last = 2
// YT URL: https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=5

package com.java.Searching;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2};
        int elem = 2;
        int first = findFirstOccurence(arr, elem);
        int last = findLastOccurrence(arr, elem);
        System.out.println(first + " "  + last);
    }

    private static int findLastOccurrence(int[] arr, int elem) {
        if(arr.length == 0 ) return -1;

        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(elem == arr[mid]) {
                result = mid;
                start = mid + 1;
            }
            if(elem > arr[mid]) start = mid + 1;
            if(elem < arr[mid]) end = mid - 1;
        }
        return result;
    }

    private static int findFirstOccurence(int[] arr, int elem) {
        if(arr.length == 0 ) return -1;

        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(elem == arr[mid]) {
                result = mid;
                end = mid - 1;
            }
            if(elem > arr[mid]) start = mid + 1;
            if(elem < arr[mid]) end = mid - 1;
        }
        return result;
    }
}
