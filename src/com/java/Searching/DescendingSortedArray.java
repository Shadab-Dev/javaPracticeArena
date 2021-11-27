// Search element in a sorted array which has descending elements
// eg: { 10 , 9 , 8 , 7, 6, 5 }
// Video URL: https://www.youtube.com/watch?v=YbkELwnGRdo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=3

package com.java.Searching;

public class DescendingSortedArray {

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5};
        int elem = 1;
        int found = reverseBinarySearch(arr, elem);
        System.out.println(found);
    }

    private static int reverseBinarySearch(int[] arr, int elem) {
        if(arr.length == 0) return  -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == elem) return elem;

            if(elem < arr[mid]) start = mid + 1;
            if(elem > arr[mid]) end = mid - 1;
        }
        return -1;
    }
}
