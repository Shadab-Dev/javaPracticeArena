// Given an array of distinct elements, find previous greater element for every element. If previous greater element does not exist, print -1.
// Input : arr[] = {10, 4, 2, 20, 40, 12, 30}
// Output :         -1, 10, 4, -1, -1, 40, 40
package com.java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class PrevousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12, 30};
        int[] result = findPreviousGreater(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findPreviousGreater(int[] arr) {
        if(arr.length<2) return arr;
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        result[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                result[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                result[i] = (stack.isEmpty()) ? -1 : stack.peek();
                stack.push(arr[i]);
            }
        }
        return result;
    }
}
