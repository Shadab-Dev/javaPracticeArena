// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.
// Input: nums = [1,3,4,2,2]
// Output: 2
package com.java.Searching;

public class RepeatingElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(getDuplicateElement(arr));
    }

    private static int getDuplicateElement(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        // for first iteration we dont check the condition
        slow = arr[slow];
        fast = arr[arr[fast]];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
