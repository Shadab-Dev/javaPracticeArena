// Given an array arr[ ] of size N having distinct elements,
// the task is to find the next greater element for each element of the array in order of their appearance in the array.
// Input:
// N = 4, arr[] = [1 3 2 4]
//Output: 3 4 4 -1
package com.java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircular {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int[] result = findNextGreaterCircular(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findNextGreaterCircular(int[] arr) {
        int n = arr.length;
        if(n==0) return arr;
        if(n==1) return new int[]{-1};
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2*n-1; i > -1; i--) {
            if(stack.isEmpty()) {
                stack.push(arr[i % n]);
                result[i % n] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() <= arr[i % n]) stack.pop();
                result[i % n] = (stack.isEmpty()) ? -1 : stack.peek();
                stack.push(arr[i % n]);
            }
        }
        return result;
    }
}
