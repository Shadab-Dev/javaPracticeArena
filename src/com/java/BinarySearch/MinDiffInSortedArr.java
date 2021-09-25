// given an sorted arr and an element, find the element in the array which has min absolute difference with the given element
// if arr = {4, 6, 10} and given elem is 7, then the absolute difference for each elem will be {3, 1, 3}
// so the answer in this case will be 1 and the output should be 6
// https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15
package com.java.BinarySearch;

public class MinDiffInSortedArr {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 10, 12, 15};
        int key = 18;
        int smallestDiff = findSmallestDiff(arr, key);
        System.out.println(smallestDiff);
    }

    private static int findSmallestDiff(int[] arr, int key) {
        if(arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        int smallestDiff = Integer.MAX_VALUE;
        int smallestDiffElement = -1;
        while(start<=end) {
            // out strategy here should be to keep trying to find the element itself.
            // we also would need to store the abs diff of last element we found as mid
            // since that will be the min diff for that iteration
            int mid = start + (end - start) / 2;
            int diff = Math.abs(key - arr[mid]);
            if(diff < smallestDiff) {
                smallestDiff = diff;
                smallestDiffElement = arr[mid];
            }

            // if the key is present in the arr, then return that as the difference will be 0 here which will always be min
            if(arr[mid] == key) return arr[mid];
            if(arr[mid] < key) start = mid + 1;
            if(arr[mid] > key) end = mid - 1;
        }
        return smallestDiffElement;
    }
}
