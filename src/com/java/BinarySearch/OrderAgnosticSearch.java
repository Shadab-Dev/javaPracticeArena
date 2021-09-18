// Given a sorted array whose sorting order is not given, hence we do not know whether it is sorted in ASC or DESC.
// YT URL: https://www.youtube.com/watch?v=gY2b-Q6wDEM&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=4

package com.java.BinarySearch;

public class OrderAgnosticSearch {
    public static void main(String[] args) {
        int[] arr = {4};
        int elem = 4;
        int found = agnosticBinarySearch(arr, elem);
        System.out.println(found);
    }

    private static int agnosticBinarySearch(int[] arr, int elem) {
        if(arr.length == 0) return -1;

        // find out the sorting order for the array
        boolean isAsc = true;
        if(arr.length > 1 && arr[0] > arr[arr.length - 1]) isAsc = false;

        int start = 0;
        int end = arr.length - 1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == elem) return arr[mid];
            if(arr[mid] < elem){
                if(isAsc) start = mid + 1;
                else end = mid - 1;
            }
            if(arr[mid] > elem) {
                if(isAsc) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}
