// given an array which is bitonic, find the element given
// Bitonic = an array which keeps on increasing and then starts decreasing at one point
// arr = {10, 20, 30, 40, 29, 18, 15}, key = 30, answer should be 2
// https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19
package com.java.Searching;

public class SearchInBitonicArr {

    public static void main(String[] args) {
        int[] arr = {10};
        int elem = 10;
        int peakIndex = findMaxInBitonicArray(arr);
        int left = agnosticBinarySearch(arr, elem, 0, peakIndex-1);
        int right = agnosticBinarySearch(arr, elem, peakIndex, arr.length-1);
        int elemIndex = (left==-1) ? right : left;
        System.out.println(elemIndex);
    }

    private static int agnosticBinarySearch(int[] arr, int elem, int start, int end) {
        if(arr.length == 0) return -1;
        boolean isAsc = true;
        if(arr.length > 1 && arr[0] > arr[arr.length - 1]) isAsc = false;

        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == elem) return mid;
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

    private static int findMaxInBitonicArray(int[] arr) {
        if(arr.length == 0) return -1;
        if(arr.length == 1) return 0;
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(mid == 0) {
                if(arr[mid] > arr[mid+1]) return mid;
            }
            else if(mid == arr.length-1) {
                if(arr[mid] > arr[mid-1]) return mid;
            }
            else if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;

            if(mid > 0 && arr[mid-1] > arr[mid]) end = mid - 1;
            else if(mid < arr.length-1 && arr[mid+1] > arr[mid]) start = mid + 1;
        }
        return -1;
    }
}
