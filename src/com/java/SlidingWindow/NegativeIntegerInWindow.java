// Given an array {-8, 2, 3, -6, 10} of size N and a positive integer K,
// find the first negative integer for each and every window(contiguous subarray) of size K.
package com.java.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NegativeIntegerInWindow {
    public static void main(String[] args) {
        long[] arr = {-8, 2, 3, -6, 10};
        int windowSize = 3;
        long[] result = findNegativeIntegers(arr, windowSize);
        System.out.println(Arrays.toString(result));
    }

    private static long[] findNegativeIntegers(long[] arr, int windowSize) {
        int start = 0, end = 0, resultIndex = 0;
        long[] result = new long[arr.length - windowSize + 1];
        List<Long> queue = new ArrayList<>();

        while(end<arr.length) {
            // we keep adding negative numbers to the queue in each iteration
            if(arr[end] < 0) queue.add(arr[end]);

            if(end - start + 1 == windowSize) {
                // if the queue is empty at this iteration, then we add 0 to the result
                if(queue.isEmpty()) result[resultIndex++] = 0;
                else {
                    // if the queue is not empty, then the first element in the queue must be the first negative number at this window
                    result[resultIndex++] = queue.get(0);
                    // we also need to check that whenever we are moving the window,
                    // if the removed elem is the first elem in the queue, then we pop the queue.
                    if(arr[start] == queue.get(0)) queue.remove(0);
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
