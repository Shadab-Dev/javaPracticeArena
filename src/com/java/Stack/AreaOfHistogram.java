// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
// Input: heights = [2,1,5,6,2,3]
// Output: 10
package com.java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class AreaOfHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int result = findArea(arr);
        System.out.println(result);
    }

    private static int findArea(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        int[] next = findNextSmaller(arr);
        int[] prev = findPreviousSmaller(arr);
        int maxArea = -1, currentArea;
        for (int i = 0; i < arr.length; i++) {
            currentArea = arr[i] * (next[i] + prev[i] - 1);
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    private static int[] findNextSmaller(int[] arr) {
        int n = arr.length;
        if(n<2) return arr;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        result[n-1] = 1;
        for (int i = n-2; i > -1; i--) {
            if(stack.isEmpty()) {
                stack.push(i);
                result[i] = 1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                result[i] = (stack.isEmpty()) ? n-i : stack.peek() - i;
                stack.push(i);
            }
        }
        return result;
    }

    private static int[] findPreviousSmaller(int[] arr) {
        int n = arr.length;
        if(n<2) return arr;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                result[i] = 1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                result[i] = (stack.isEmpty()) ? i+1 : i - stack.peek();
                stack.push(i);
            }
        }
        return result;
    }
}
