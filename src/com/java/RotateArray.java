package com.java;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
//     BRUTE-FORCE METHOD
    static void rotate(int[] nums, int k) {
        int temp = nums.length - k;
        List<Integer> finalList = new ArrayList<>();
        for(int i = temp; i<nums.length; i++) {
            finalList.add(nums[i]);
        }
        for(int i = 0; i < temp; i++) {
            finalList.add(nums[i]);
        }
        System.out.println(finalList);
    }

    static void optimizedRotate(int[] nums, int k) {

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }
}
