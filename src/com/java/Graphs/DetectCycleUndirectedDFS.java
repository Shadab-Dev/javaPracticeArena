package com.java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleUndirectedDFS {

    public static void main(String[] args) {
        DetectCycleUndirectedDFS c = new DetectCycleUndirectedDFS();
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

        // Corner Case to handle two nodes connected to each other !IMPORTANT
//        List<Integer> n0 = new ArrayList<>(Arrays.asList(1));
//        List<Integer> n1 = new ArrayList<>(Arrays.asList(0));
//        graph.add(n0);
//        graph.add(n1);
        System.out.println(c.traverseInDFS(graph));
    }

    private boolean traverseInDFS(List<List<Integer>> graph) {
        boolean result = false;
        boolean[]  visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i])
                result = DFS(graph, i, visited, -1);
        }
        return result;
    }

    private boolean DFS(List<List<Integer>> graph, int source, boolean[] visited, int parent) {
        visited[source] = true;
        List<Integer> adjList = graph.get(source);
        for(int elem : adjList) {
            if(!visited[elem]) {
                if(DFS(graph, elem, visited, source)) return true;
            } else if(parent != elem) return true;
        }
        return false;
    }
}
