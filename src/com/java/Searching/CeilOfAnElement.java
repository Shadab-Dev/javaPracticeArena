// Ceil of an element is the smallest element which is greater than 5
// arr = {1 ,2 ,3, 4, 6, 7, 8 };
// ceil of 5 will be 6
package com.java.Searching;

public class CeilOfAnElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 11};
        int elem = 10;
        int ceil = findCeil(arr, elem);
        System.out.println(ceil);
    }

    private static int findCeil(int[] arr, int elem) {
        if(arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        int ceil = -1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == elem) return arr[mid];

            if(arr[mid] > elem) {
                ceil = arr[mid];
                end = mid - 1;
            }
            if(arr[mid] < elem) start = mid+1;
        }
        return ceil;
    }
}
