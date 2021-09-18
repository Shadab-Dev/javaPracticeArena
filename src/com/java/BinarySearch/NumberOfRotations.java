// find the number of times a sorted array has been rotated
// arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
// answer should be 3
// YT URL = https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7
package com.java.BinarySearch;

public class NumberOfRotations {
    public static void main(String[] args) {
        int[] arr =  { 5 , 1, 2, 3, 4};
        int rotations = findNumberOfRotations(arr);
        System.out.println(rotations);
    }

    private static int findNumberOfRotations(int[] arr) {
        if(arr.length == 0) return 0;
        int start = 0;
        int end = arr.length - 1;
        int rotations = 0;

        while(start<=end) {
            int mid = start + (end-start)/2 ;
            // calculate next and prev, if they go out of bounds, then do a modulus with length, this will rotate the index
            // eg, if arr length is 7 and mid is 6,then if you do mid + 1 it will go out of bounds, using below formula will rotate it back to 0
            int prev = (mid + arr.length - 1) % arr.length;
            int next = (mid + 1) % arr.length;

            // if mid is smaller than both left and right, then it must be the smallest element
            // and the number of rotations will be the index of smallest element
            if(arr[mid] < arr[prev] && arr[mid] < arr[next]) {
                rotations = mid;
                break;
            }

            // The concept of dividing lies in finding out the unsorted side of the array
            // We check if start is smaller than mid, if it is, then we assume that the left side is sorted
            // else we check if end is greater than mid, if it is, then it means the right side is sorted
            // which ever is sorted we discard that side and continue with the non sorted side
            // we are assuming that the element must be on the non sorted side
            if(arr[start] <= arr[mid]) start = mid + 1;
            else if(arr[end] >= arr[mid]) end = mid - 1;
        }
        return rotations;
    }
}
