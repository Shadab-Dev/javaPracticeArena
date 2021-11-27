// given an arr which is nearly sorted, eg: {10, 20, 40, 30, 50}. Here, element at ith pos can be at i-1 pos or i+1 pos as well as i pos.
// so the element can be at 3 positions instead of just at one.
// find the element in this arr
// YT URL: https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
package com.java.Searching;

public class FindElementInNearlySortedArr {
    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 30, 50};
        int element = 50;
        int found = binarySearchInNearlySorted(arr, element);
        System.out.println(found);
    }

    private static int binarySearchInNearlySorted(int[] arr, int element) {
        if(arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == element) return arr[mid];
            if(mid-1 > 0 && arr[mid-1] == element) return arr[mid-1];
            if(mid+1 < arr.length && arr[mid+1] == element) return  arr[mid+1];

            if(element < arr[mid]) end = mid - 2;
            if(element > arr[mid]) start = mid + 2;
        }
        return -1;
    }


}
