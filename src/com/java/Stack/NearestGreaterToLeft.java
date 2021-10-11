// Given an arr = {1, 2, 0, 0, 3, 1, 2, 4}
// For each element, calculate the element which is greater than that element and is on the left side.
// for the first element, since there will be nothing on the left, add -1.
// Here answer will be {-1, -1, 2, 2, -1, 3, 3, -1}
package com.java.Stack;

import java.util.Arrays;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 3, 1, 2, 4};
        int[] output = findGreaterToLeft(arr);
        System.out.println(Arrays.toString(output));
    }

    private static int[] findGreaterToLeft(int[] arr) {
        int[] output = new int[arr.length];
        Stack st = new Stack();

        // since we want the greater elem on the left, we run a normal loop
        for (int i = 0; i < arr.length; i++) {
            // If the stack is empty then add -1 to output and push the arr elem in the stack
            if(st.peek() == -1) {
                output[i] = -1;
                st.push(arr[i]);
                // If the top elem is greater than arr elem, then that is the nearest greater elem
            } else if(st.peek() > arr[i]) {
                output[i] = st.peek();
                st.push(arr[i]);
            } else {
                // If the top elem is smaller, then keep popping until stack is empty,
                // or you find the top elem which is greater than arr elem
                while (st.peek()!=-1 && st.peek()<=arr[i]) {
                    st.pop();
                }
                if(st.peek() == -1) output[i] = -1;
                if(st.peek() > arr[i]) output[i] = st.peek();
                st.push(arr[i]);
            }

        }
        return output;
    }
}
