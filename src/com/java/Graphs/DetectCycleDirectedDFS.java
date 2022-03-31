package com.java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleDirectedDFS {
    public static void main(String[] args) {
        DetectCycleDirectedDFS c= new DetectCycleDirectedDFS();
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> n0 = new ArrayList<>(Arrays.asList(1));
        List<Integer> n1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> n2 = new ArrayList<>(Arrays.asList(3));
        List<Integer> n3 = new ArrayList<>(Arrays.asList(1));
        graph.add(n0);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        System.out.println(c.detectInDFS(graph));
    }

    // In the directed scenario, the idea is to maintain a Trace.
    private boolean detectInDFS(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] trace = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i])
                if(DFS(graph, i, visited, trace)) return true;
        }
        return false;
    }

    private boolean DFS(List<List<Integer>> graph, int source, boolean[] visited, boolean[] trace) {
        visited[source] = true;
        // Whenever we traverse, we keep track of the previous node by marking it as true
        trace[source] = true;
        List<Integer> adjList = graph.get(source);
        for(int elem : adjList) {
            if(!visited[elem]) {
                if(DFS(graph, elem, visited, trace)) return true;
            }
            // Along the DFS traversal, if we find a node is hsa been visited before and is also a part of the trace then we say that this sub graph is a cycle
            else if(trace[elem]) return true;
        }
        // It is important to delete the trace when we are done traversing the sub graph as the same nodes may be part of another sub graph
        trace[source] = false;
        return false;
    }
}
