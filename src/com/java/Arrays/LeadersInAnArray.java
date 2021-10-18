// Given an array {7, 10, 4, 3, 6, 5, 2} Find the leaders in this array
// An element is considered to be a leader if all the right side elements are smaller than this element
// here the answer will be {10, 6, 5, 2}
package com.java.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 6, 5, 2};
        List<Integer> result = findLeaders(arr);
        System.out.println(result);
    }

    private static List<Integer> findLeaders(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int leader = arr[n-1];
        // The last element will always be a leader
        result.add(arr[n-1]);
        for (int i = n-2; i > -1 ; i--) {
            if(arr[i] > leader) {
                result.add(arr[i]);
                leader = arr[i];
            }
        }
        Collections.reverse(result);
        return result;
    }
}
