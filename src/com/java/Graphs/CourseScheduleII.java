package com.java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(numCourses, prerequisites)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return new int[numCourses];

        // create the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        // Create a visited array to keep track of visited nodes
        int[] visited = new int[numCourses];
        // Create a list to keep the trace
        List<Integer> trace = new ArrayList<>();
        // First add empty lists to denote no dependency
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // Then iterate through the prereqs and add in the adjList
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //check each node in the adjList to find a cycle
        for (int i = 0; i < adjList.size(); i++) {
            if(detectCycle(adjList, i, visited, trace)) return new int[0];
        }

        int[] result = new int[trace.size()];
        for (int i = 0; i < trace.size(); i++) {
            result[i] = trace.get(i);
        }
        return result;
    }

    Boolean detectCycle(List<List<Integer>> adjList, int node, int[] visited, List<Integer> trace) {
        if(visited[node] == 1) return true;
        if(visited[node] == 2) return false;

        visited[node] = 1;
        for (int i = 0; i < adjList.get(node).size(); i++) {
            if(detectCycle(adjList, adjList.get(node).get(i), visited, trace)) return true;
        }
        trace.add(node);
        visited[node] = 2;
        return false;
    }
}
