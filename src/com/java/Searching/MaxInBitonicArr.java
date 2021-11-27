// Given an array which keeps on increasing and then starts decreasing at one point, find the max element in that array
// arr = {10, 20, 30, 40, 29, 18, 15}, here the answer should be 40
// this is exactly same as peak element, here also if you observe, we need to find the peak
// https://www.youtube.com/watch?v=BrrZL1RDMwc&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=18
package com.java.Searching;

public class MaxInBitonicArr {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 21, 18, 15};
        int peak = findMaxInBitonicArray(arr);
        System.out.println(peak);
    }

    private static int findMaxInBitonicArray(int[] arr) {
        if(arr.length == 0) return -1;
        if(arr.length == 1) return arr[0];
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            // compare mid element with its neighbours to find out if that is the peak (1st Criteria)
            // edge condition if mid is at start
            if(mid == 0) {
                if(arr[mid] > arr[mid+1]) return arr[mid];
            }
            //edge condition if mid is at end
            else if(mid == arr.length-1) {
                if(arr[mid] > arr[mid-1]) return arr[mid];
            }
            //normal success condition
            else if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return arr[mid];

            // if mid elem is not the peak, then we need to decide which side of the array we need to continue to iterate
            // the strategy here is to continue on that side which has the element greater than current mid
            // because that will be the promising side

            // checking if left side is the promising side
            if(mid > 0 && arr[mid-1] > arr[mid]) end = mid - 1;
            else if(mid < arr.length-1 && arr[mid+1] > arr[mid]) start = mid + 1;
        }
        return -1;
    }
}
