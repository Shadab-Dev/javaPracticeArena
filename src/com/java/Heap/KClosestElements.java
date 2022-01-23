package com.java.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        KClosestElements c = new KClosestElements();
        System.out.println(c.findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> resultHeap = new PriorityQueue<>();
        int count = k;
        // subtract x from each element
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            System.out.println(diff);
            heap.offer(new Pair(diff, arr[i]));
            if(heap.size() > k) heap.poll();
        }
        while (!heap.isEmpty())  resultHeap.offer(heap.poll().value);
        return new ArrayList<>(resultHeap);
    }

    static class Pair implements Comparable<Pair> {
        int diff;
        int value;

        public Pair(int diff, int value) {
            this.diff = diff;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.diff, o.diff);
        }
    }
}
