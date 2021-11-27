// You are given an array of integers nums,
// there is a sliding window of size k which is moving from the very left of the array to the very right.
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
package com.java.SlidingWindow;

import java.util.*;

public class MaxSubarrayInWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};
        int windowSize = 3;
        int[] result = findMaxSubarray(arr, windowSize);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findMaxSubarray(int[] arr, int windowSize) {
        int start = 0, end = 0;
        int[] result = new int[arr.length-windowSize+1];
        int resultIndex = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        while(end<arr.length){
            // If the queue is empty we just add the current elem
            if(queue.isEmpty()) queue.addFirst(arr[end]);
            // We need to make sure that the queue always has the first elem as the highest elem
            // so if we find anything greater than the first elem, we remove everything and add the current elem
            // since all the smaller elems don't matter
            else if(queue.getFirst() < arr[end]) {
                queue.clear();
                queue.addFirst(arr[end]);
            }
            // We need to be very careful when we find an element which is smaller than the first element in the queue
            // here we need to make sure the current element is inserted at the correct position
            // and all the elems smaller to it doesn't matter
            else {
                while (!queue.isEmpty() && queue.peekLast() < arr[end]) {
                    queue.pollLast();
                }
                queue.addLast(arr[end]);
            }

            if(end-start+1 == windowSize) {
                // the first element will always be the greatest
                result[resultIndex++] = queue.getFirst();
                // when we find an elem that is greatest and has moved out of the window we don't need to worry
                // since the next elements in the queue will be the next highest
                if(arr[start] == queue.getFirst()) queue.removeFirst();
                start++;
            }
            end++;
        }
        return result;
    }
}
