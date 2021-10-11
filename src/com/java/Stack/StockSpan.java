// Given an array of stock prices, {100, 80, 60, 70, 60, 75, 85}
// Find the span of a stock price. Return an array which will contain the no. of days the stock price was at top.
// Here the answer will be {1, 1, 1, 2, 1, 4, 6}
package com.java.Stack;

import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 110, 75, 85};
        int[] output = findStockSpan(arr);
        System.out.println(Arrays.toString(output));
    }

    private static int[] findStockSpan(int[] arr) {
        int[] output = new int[arr.length];
        Stack st = new Stack();

        // since we want the greater elem on the left, we run a normal loop
        for (int i = 0; i < arr.length; i++) {
            // If the stack is empty then add 1 to output and push the arr elem index in the stack
            if(st.peek() == -1) {
                output[i] = 1;
                st.push(i);
                // If the top elem is greater than arr elem, then that is the nearest greater elem
            } else if(arr[st.peek()] > arr[i]) {
                output[i] = i - st.peek();
                st.push(i);
            } else {
                // If the top elem is smaller, then keep popping until stack is empty,
                // or you find the top elem which is greater than arr elem
                while (st.peek()!=-1 && arr[st.peek()]<=arr[i]) {
                    st.pop();
                }
                if(st.peek() == -1) output[i] = i;
                else if(arr[st.peek()] > arr[i]) output[i] = i - st.peek();
                st.push(i);
            }

        }
        return output;
    }
}
