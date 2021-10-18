// Given an array {8, 3, 4, 8, 8} find all the majority elements
// An element is considered a majority if it appears MORE than n/3 times
package com.java.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {1, 1};
        List<Integer> majors= findIndexOfMajority(arr);
        System.out.println(majors);
    }

    private static List<Integer> findIndexOfMajority(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int elemIndex1 = 0;
        int count2 = 0;
        int elemIndex2 = 0;
        int actualCount1 = 0;
        int actualCount2 = 0;
        // Using this loop we find 2 candidates using Moore's Voting Algo
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[elemIndex1]) count1++;
            else if(arr[i] == arr[elemIndex2]) count2++;
            else if(count1 == 0) {
                elemIndex1 = i;
                count1 = 1;
            } else if(count2 == 0) {
                elemIndex2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // check if the elem1 and elem2 is actually the majority element or not by running another loop
        for (int j : arr) {
            if (j == arr[elemIndex1]) actualCount1++;
            if (j == arr[elemIndex2]) actualCount2++;
        }

        if(actualCount1 > arr.length/3) result.add(arr[elemIndex1]);
        if(actualCount2 > arr.length/3 && arr[elemIndex1]!=arr[elemIndex2]) result.add(arr[elemIndex2]);
        return result;
    }
}
