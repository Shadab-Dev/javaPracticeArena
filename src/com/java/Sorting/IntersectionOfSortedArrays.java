// Given two integer arrays nums1 and nums2, return an array of their intersection.
// Each element in the result must be unique and you may return the result in any order.
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
package com.java.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};
        int[] result = findIntersection(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findIntersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;
        List<Integer> result = new ArrayList<>();

        while(p1<arr1.length && p2<arr2.length) {
            if(arr1[p1]==arr2[p2]) {
                if(result.isEmpty() || result.get(result.size()-1) != arr1[p1]) result.add(arr1[p1]);
                p1++; p2++;
            }
            else if(arr1[p1] > arr2[p2]) p2++;
            else p1++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
