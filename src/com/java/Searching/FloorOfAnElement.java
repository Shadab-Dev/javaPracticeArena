// Find the floor of an element in the given array
// Floor of an element is the greatest element in the array which is smaller than the given element
// for arr = {1, 2, 4, 5, 6, 8, 9}
// Floor of 7 will be 6
package com.java.Searching;

public class FloorOfAnElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9};
        int elem = 5;
        int floor = findFloor(arr, elem);
        System.out.println(floor);
    }

    private static int findFloor(int[] arr, int elem) {
        if(arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        int floor = -1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == elem) return arr[mid];

            if(arr[mid] > elem) end = mid-1;
            if(arr[mid] < elem) {
                floor = arr[mid];
                start = mid+1;
            }
        }
        return floor;
    }
}
