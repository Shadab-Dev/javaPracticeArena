package com.java.Graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1,0}, {2,1}, {0,2}};
        System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1 || prerequisites.length == 0) return true;

        // create the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        // Create a visited array to keep track of visited nodes
        int[] visited = new int[numCourses];
        // First add empty lists to denote no dependency
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // Then iterate through the prereqs and add in the adjList
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //check each node in the adjList to find a cycle
        for (int i = 0; i < adjList.size(); i++) {
            if(detectCycle(adjList, i, visited)) return false;
        }

        return true;
    }

    Boolean detectCycle(List<List<Integer>> adjList, int node, int[] visited) {
        if(visited[node] == 1) return true;
        if(visited[node] == 2) return false;

        visited[node] = 1;
        for (int i = 0; i < adjList.get(node).size(); i++) {
            if(detectCycle(adjList, adjList.get(node).get(i), visited)) return true;
        }
        visited[node] = 2;
        return false;
    }
}
