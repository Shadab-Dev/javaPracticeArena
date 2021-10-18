// Given N ranges, find max appearing element in those ranges
// L = {1, 2, 3} and R = {3, 5, 7} so the ranges are 1-2, 2-5 and 3-7.
// Given constraint is that the number range can never be greater than 20.
package com.java.Arrays;

import java.util.Arrays;

public class MaxAppearingElementInRange {
    public static void main(String[] args) {
        int[] left = {1, 2, 3};
        int[] right = {3, 5, 7};
        int constraint = 20;
        int maxAppearingElement = findMaxAppearingElement(left, right, constraint);
        System.out.println(maxAppearingElement);
    }

    private static int findMaxAppearingElement(int[] left, int[] right, int constraint) {
        int[] frequency = new int[constraint];
        int max = frequency[0];
        // In this step we add 1 to the start of the range and subtract 1 for the end+1 of the range
        for (int i = 0; i < left.length; i++) {
            frequency[left[i]]++;
            frequency[right[i]+1]--;
        }
        System.out.println(Arrays.toString(frequency));
        // Now we calculate the prefix sum of the frequency array, after which we will get the frequency of all the elements
        // We take the max among them
        for (int i = 1; i < frequency.length; i++) {
            frequency[i] += frequency[i-1];
            max = Math.max(frequency[i], max);
        }
        System.out.println(Arrays.toString(frequency));
        return max;
    }
}
