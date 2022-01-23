// Given an array {8, 3, 4, 8, 8} find the majority element
// An element is considered a majority if it appears MORE than n/2 times
package com.java.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        int majorityElem = findIndexOfMajority(arr);
        System.out.println(majorityElem);
    }

    private static int findIndexOfMajority(int[] arr) {
        int count = 1;
        int actualCount = 0;
        int elemIndex = 0;
        // Using this loop we find a candidate using Moore's Voting Algo
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[elemIndex]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                elemIndex = i;
                count = 1;
            }
        }
        // After this loop if the count is greater than 0 then the elemIndex may be the majority elem.
        // We need to verify that with another loop. But if the count is zero or less we straight away return
        if(count <= 0) return -1;

        // check if the elem is actually the majority element or not by running another loop
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[elemIndex]) actualCount++;
        }
        if(actualCount > arr.length/2) return arr[elemIndex];
        return -1;
    }
}
