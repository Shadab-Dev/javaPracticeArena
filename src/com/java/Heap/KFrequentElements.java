package com.java.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        KFrequentElements c = new KFrequentElements();
        System.out.println(Arrays.toString(c.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        int[] result = new int[k];

        for(int i = 0; i<nums.length; i++) {
            if(countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }

        countMap.forEach((key,value) -> {
            heap.offer(new Pair(key, value));
            if(heap.size() > k) heap.poll();
        });

        for(int i=0; i<heap.size(); i++) {
            result[i] = heap.poll().value;
        }
        return result;
    }

    static class Pair implements Comparable<Pair>{
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.count, o.count);
        }
    }
}
