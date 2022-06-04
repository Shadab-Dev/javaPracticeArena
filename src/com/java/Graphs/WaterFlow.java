package com.java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};
        System.out.println(new WaterFlow().pacificAtlantic(heights));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return result;
        }
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        // start from first and last row
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, heights.length-1, i, Integer.MIN_VALUE, atlantic);
        }

        // then run dfs for the first and last column
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, heights.length-1, Integer.MIN_VALUE, atlantic);
        }

        //Add the results if both atlantic and pacific are true
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void dfs (int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length) return;
        if(prev > heights[i][j] || ocean[i][j]) return;
        ocean[i][j] = true;
        dfs(heights, i+1, j, heights[i][j], ocean);
        dfs(heights, i-1, j, heights[i][j], ocean);
        dfs(heights, i, j+1, heights[i][j], ocean);
        dfs(heights, i, j-1, heights[i][j], ocean);
    }
}
