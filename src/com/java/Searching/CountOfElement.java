// In a given sorted array, find the count of an element
// arr = {1, 2, 3, 3, 3, 4, 5}
// elem = 3, count should be 3
// YT URL = https://www.youtube.com/watch?v=Ru_HhBFV3Xo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=6&t=1s
package com.java.Searching;

public class CountOfElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5};
        int elem = 3;
        int count = findCount(arr, elem);
        System.out.println(count);
    }

    private static int findCount(int[] arr, int elem) {
        // this question is a slight variation of the previous question
        // we can use first occurrence and last occurrence to find the length
        // then from the length we can get the count
        int first = findFirstOccurence(arr, elem);
        int last = findLastOccurrence(arr, elem);
        return last - first + 1;
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
