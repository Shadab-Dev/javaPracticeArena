// Given an array arr[ ] of size N having distinct elements,
// the task is to find the next greater element for each element of the array in order of their appearance in the array.
// Input:
// N = 4, arr[] = [1 3 2 4]
//Output: 3 4 4 -1
package com.java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int[] result = findNextGreater(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findNextGreater(int[] arr) {
        if(arr.length<2) return arr;
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length-1]);
        result[arr.length-1] = -1;
        for (int i = arr.length-1; i > -1; i--) {
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
