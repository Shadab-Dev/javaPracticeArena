package com.java.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class DetectCycleDirectedBFS {
    public static void main(String[] args) {
        DetectCycleDirectedBFS c = new DetectCycleDirectedBFS();
        ArrayList<Integer> n0 = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> n1 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> n2 = new ArrayList<>(Arrays.asList(3));
        ArrayList<Integer> n3 = new ArrayList<>();
//        ArrayList<Integer> n0 = new ArrayList<>(Arrays.asList(1));
//        ArrayList<Integer> n1 = new ArrayList<>(Arrays.asList(2));
//        ArrayList<Integer> n2 = new ArrayList<>(Arrays.asList(3));
//        ArrayList<Integer> n3 = new ArrayList<>(Arrays.asList(4, 5));
//        ArrayList<Integer> n4 = new ArrayList<>();
//        ArrayList<Integer> n5 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(n0);
        adj.add(n1);
        adj.add(n2);
        adj.add(n3);
//        adj.add(n4);
//        adj.add(n5);
        System.out.println(c.isCyclic(adj.size(), adj));
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // create inbound array
        int[] inbound = createInboundArr(adj);
        Queue<Integer> queue = new ArrayDeque<>();
        // Add all elements in the array which has inbound 0
        for (int i = 0; i < inbound.length; i++) {
            if(inbound[i] == 0) queue.offer(inbound[i]);
        }

        // Start BFS processing and maintain count at each pop
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            ArrayList<Integer> adjList = adj.get(temp);
            for(int elem : adjList) {
                inbound[elem]--;
                if(inbound[elem] == 0) queue.offer(elem);
            }
        }

        // After BFS is complete, we check that count is equal to tne number of vertices.
        // If not, then it means we have not processed all nodes and we return true
        if(count != V) return true;
        return false;
    }

    private int[] createInboundArr(ArrayList<ArrayList<Integer>> adj) {
        int[] result = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for(int elem : adj.get(i)) {
                result[elem]++;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
