// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
package com.java.Sorting;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }

    private static int findKthLargest(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        while(low<=high) {
            int p = partition(arr, low, high);
            if(p==k-1) return arr[p];
            else if(p>k-1) high = p-1;
            else low = p+1;
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = high;
        int i = low-1;
        for(int j=low; j<high; j++) {
            if(arr[j] > arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, pivot);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
