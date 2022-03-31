package com.java.Graphs;

import java.util.*;

public class DetectCycleUndirectedBFS {
    public static void main(String[] args) {
        DetectCycleUndirectedBFS c = new DetectCycleUndirectedBFS();
        List<List<Integer>> graph = new ArrayList<>();
//        List<Integer> n0 = new ArrayList<>(Arrays.asList(1,2,3));
//        List<Integer> n1 = new ArrayList<>(Arrays.asList(0,4));
//        List<Integer> n2 = new ArrayList<>(Arrays.asList(0,4));
//        List<Integer> n3 = new ArrayList<>(Arrays.asList(0,5));
//        List<Integer> n4 = new ArrayList<>(Arrays.asList(1,2,5));
//        List<Integer> n5 = new ArrayList<>(Arrays.asList(4,3));
//        graph.add(n0);
//        graph.add(n1);
//        graph.add(n2);
//        graph.add(n3);
//        graph.add(n4);
//        graph.add(n5);

        // Corner Case to handle two nodes connected to each other !IMPORTANT
        List<Integer> n0 = new ArrayList<>(Arrays.asList(1));
        List<Integer> n1 = new ArrayList<>(Arrays.asList(0));
        graph.add(n0);
        graph.add(n1);
        System.out.println(c.traverseInBFS(graph));
    }

    public boolean traverseInBFS(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean result = false;
        // start from every point and check
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i])
                result = BFS(graph, i, visited);
        }
        return result;
    }

    public boolean BFS(List<List<Integer>> graph, int source, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        // We create a parent array and initialize with -1
        int[] parent = new int[graph.size()];
        Arrays.fill(parent, -1);
        // First add the source to the queue and mark it as visited
        queue.offer(source);
        visited[source] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            // as we take out an item from the queue we loop through all its adjacent nodes
            List<Integer> adjList = graph.get(temp);
            for (Integer elem : adjList) {
                // For any adjacent nodes that we have not visited, we mark it as visited and push back into the queue
                if (!visited[elem]) {
                    visited[elem] = true;
                    parent[elem] = temp;
                    queue.offer(elem);
                }
                // If we find any element that we have visited before
                // and the parent of temp is not the current element, then we break and return true
                else if(parent[temp] != elem) return true;
            }
        }
        return false;
    }
}
