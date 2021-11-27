// Assume that a given array is infinite in size. Search for an element in this array.
// https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13
package com.java.Searching;

public class SearchInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        int elem = 5;
        int found = searchInfiniteArr(arr, elem);
        System.out.println(found);
    }

    private static int searchInfiniteArr(int[] arr, int elem) {
        int start = 0;
        int end = start+1;
        int multiplier = 2;

        // the strategy of solving this problem is to create a window in the arr
        // using start and end where the elem must fall within.
        // If we have such a window then we can apply normal binary search on this window
        while (true) {
            if(arr[end] < elem) {
                // we increase the window by moving start to end and multiplying end by 2
                start = end;
                end *= multiplier;
            // if we find the window, we break and apply binSearch on that window
            } else break;
        }
        return binarySearch(arr, elem, start, end);
    }

    private static int binarySearch(int[] arr, int elem, int start, int end) {
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == elem) return arr[mid];
            if(arr[mid] < elem) start = mid + 1;
            if(arr[mid] > elem) end = mid - 1;
        }
        return -1;
    }
}
