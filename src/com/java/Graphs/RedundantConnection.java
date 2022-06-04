package com.java.Graphs;

import java.util.Arrays;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        System.out.println(Arrays.toString(new RedundantConnection().findRedundantConnection(edges)));
    }
    // 5
    // 3 -> 4
    //      |
    // 1 -> 2

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];
        // Initialize parent array
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if(!union(edges[i][0], edges[i][1], parent, rank))
                return new int[]{edges[i][0], edges[i][1]};
        }
        return new int[0];
    }

    private boolean union (int x, int y, int[] parent, int[] rank) {
        int parentX = findParent(x, parent, rank);
        int parentY = findParent(y, parent, rank);
        if(parentX == parentY) return false;

        if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else if (rank[parentY] > rank[parentX]){
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
        return true;
    }

    private int findParent (int elem, int[] parent, int[] rank) {
        if(parent[elem] == elem) return elem;
        parent[elem] = findParent(parent[elem], parent, rank);
        return parent[elem];
    }

}
