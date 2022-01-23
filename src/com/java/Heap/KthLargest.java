package com.java.Heap;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        KthLargest c = new KthLargest();
        System.out.println(c.findKthLargest(arr, k));
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if(heap.size() > k) heap.poll();
        }
        return heap.poll();
    }
}
