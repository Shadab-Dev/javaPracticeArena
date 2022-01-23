package com.java.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KclosestToOrigin {

    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2,2}};
        int k = 1;
        KclosestToOrigin c = new KclosestToOrigin();
        System.out.println(Arrays.toString(c.kClosest(points, k)));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[][] result = new int[k][2];
        for(int i = 0; i<points.length; i++) {
            // calculate euclidean distance for each point
            double xSquared = Math.pow(points[i][0], 2);
            double ySquared = Math.pow(points[i][1], 2);
            double distance = Math.sqrt(xSquared + ySquared);

            heap.offer(new Pair(points[i][0], points[i][1], distance));
            if(heap.size() > k) heap.poll();
        }

        int count = 0;
        while(!heap.isEmpty()) {
            Pair curr = heap.poll();
            result[count][0] = curr.x;
            result[count][1] = curr.y;
            count++;
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        double distance;
        public Pair(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p) {
            return Double.compare(this.distance, p.distance);
        }
    }
}
