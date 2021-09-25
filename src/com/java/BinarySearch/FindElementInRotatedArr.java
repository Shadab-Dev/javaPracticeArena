// Given an arr which is rotated, search for a given element
// YT URL: https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8
package com.java.BinarySearch;

public class FindElementInRotatedArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int elem = 8;
        int index = findSmallestIndex(arr, elem);
        int left = index - 1;
        int right = index + 1;
        int leftFound = (left > -1) ? binarySearch(arr, elem, 0 , left) : -1;
        int rightFound = (right < arr.length) ? binarySearch(arr, elem, right, arr.length-1) : -1;
        System.out.println(leftFound + " " + rightFound);
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

    private static int findSmallestIndex(int[] arr, int elem) {
        if(arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        int smallestIndex = -1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            int prev = (mid + arr.length - 1) % arr.length;
            int next = (mid + 1) % arr.length;

            if(arr[mid] < arr[next] && arr[mid] < arr[prev]) {
                smallestIndex = mid;
                break;
            }
            if(arr[mid] <= arr[end]) end = mid - 1;
            else if(arr[mid] >= arr[start]) start = mid + 1;
        }
        return smallestIndex;
    }
}
