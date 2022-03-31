package com.java.Graphs;

import java.util.*;

public class ShortestPathUndirected {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> n0 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> n1 = new ArrayList<>(Arrays.asList(0,4));
        List<Integer> n2 = new ArrayList<>(Arrays.asList(0,4));
        List<Integer> n3 = new ArrayList<>(Arrays.asList(0,5));
        List<Integer> n4 = new ArrayList<>(Arrays.asList(1,2,5));
        List<Integer> n5 = new ArrayList<>(Arrays.asList(4,3));
        graph.add(n0);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);
        graph.add(n5);
        ShortestPathUndirected c = new ShortestPathUndirected();
        System.out.println(c.traverseInBFS(graph, 0));
    }

    public List<Integer> traverseInBFS(List<List<Integer>> graph, int source) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> result = new ArrayList<>(graph.size());
        // initialize the distance array as INF
        for(int i = 0; i<graph.size(); i++) {
            result.add(Integer.MAX_VALUE);
        }
        BFS(graph, source, visited, result);
        return result;
    }

    public void BFS(List<List<Integer>> graph, int source, boolean[] visited, List<Integer> result) {
        Queue<Integer> queue = new ArrayDeque<>();
        // First add the source to the queue and mark it as visited
        queue.offer(source);
        visited[source] = true;
        // The distance of source will always be 0 since we are always starting from source;
        result.set(source, 0);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            // as we take out an item from the queue we loop through all its adjacent nodes
            List<Integer> adjList = graph.get(temp);
            for (Integer elem : adjList) {
                // For any adjacent nodes that we have not visited, we mark it as visited and push back into the queue
                if (!visited[elem]) {
                    visited[elem] = true;
                    queue.offer(elem);
                    // The distance of the adjacent node will always be 1 more than its parent
                    // Since BFS always goes from source to radially outwards, hence we always know the distance of the parent node
                    result.set(elem, result.get(temp) + 1);
                }
            }
        }
    }
}
