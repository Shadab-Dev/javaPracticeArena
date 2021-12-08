// The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days.
// The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
// For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
// then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
// Input: price[] = [100 80 60 70 60 75 85]
// Output: 1 1 1 2 1 4 6
package com.java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};
        int[] result = findStockSpan(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findStockSpan(int[] arr) {
        if(arr.length<2) return arr;
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                result[i] = 1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
                result[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
                stack.push(i);
            }
        }
        return result;
    }
}
