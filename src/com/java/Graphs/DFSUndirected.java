package com.java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSUndirected {
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
        DFSUndirected c = new DFSUndirected();
        System.out.println(c.traverseInDFS(graph, null));
    }

    private List<Integer> traverseInDFS(List<List<Integer>> graph, Integer source) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> result = new ArrayList<>(graph.size());
        // If the source is given, then start from the source
        if(source != null) DFS(graph, source, visited, result);
        // Then start from every point and check if any node is missed
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i])
                DFS(graph, i, visited, result);
        }
        return result;
    }

    private void DFS(List<List<Integer>> graph, int source, boolean[] visited, List<Integer> result) {
        visited[source] = true;
        result.add(source);
        List<Integer> adjList = graph.get(source);
        for(int elem : adjList) {
            if(!visited[elem])
                DFS(graph, elem, visited, result);
        }
    }
}
