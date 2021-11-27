// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
package com.java.Searching;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {};
        int[] a2 = {0};
        System.out.println(findMedian(a1, a2));
    }

    private static double findMedian(int[] a1, int[] a2) {
        int start = 0, end = a1.length;
        int partitionA1, partitionA2;
        int maxLeftA1, minRightA1, maxLeftA2, minRightA2;
        boolean isEven = ((a1.length + a2.length) % 2 == 0);

        // First we find out which array is of smaller length since we will do bSearch on that array
        // if a2 is smaller than we swap the arrays and always refer the smaller array as a1
        if(a2.length < a1.length) {
            end = a2.length;
            int[] temp = a1;
            a1 = a2;
            a2 = temp;
        }

        while (start<=end) {
            // The mid formula that we use to form the partition for a1
            partitionA1 = start + (end - start) / 2;
            // At each iteration we need to make sure that the two partitions exactly divide the combined array by half
            // so we apply this formula to find partitionA2 which is basically the median of the combined array subtracted by partitionA1.
            partitionA2 = ((a1.length + a2.length + 1) / 2) - partitionA1;
            // Now we need to find out max of a1 and a2. This will be the element which is left to mid
            // We also need to handle the edge case that if there are no elements on the left then,
            // we declare it as int min as finally when we do int max this value will not be considered
            maxLeftA1 = (partitionA1 == 0) ? Integer.MIN_VALUE : a1[partitionA1-1];
            maxLeftA2 = (partitionA2 == 0) ? Integer.MIN_VALUE : a2[partitionA2-1];
            // We do a similar scenario for finding the min and handle the edge case by assigning int max
            minRightA1 = (partitionA1 == a1.length) ? Integer.MAX_VALUE : a1[partitionA1];
            minRightA2 = (partitionA2 == a2.length) ? Integer.MAX_VALUE : a2[partitionA2];

            // If we find a partition in which all the elements on the left side are smaller than all the elements in the right side,
            // Then we have found our answer
            if(maxLeftA1 <= minRightA2 && maxLeftA2 <= minRightA1) {
                // For even sized arrays, the answer will be the average of max of left and min of right
                if(isEven) {
                    return (double) (Math.max(maxLeftA1, maxLeftA2) + Math.min(minRightA1, minRightA2)) / 2;
                // for odd, we just return the max of left as there can oly be a single median element in odd sized arrays
                } else return Math.max(maxLeftA1, maxLeftA2);
            } else if(maxLeftA1 > minRightA2) { // if the max of a1 is greater than min of a2 then we need to move to the left
                end = partitionA1 - 1;
            } else { // else we need to move to the right
                start = partitionA1 + 1;
            }
        }
        return -1;
    }
}
