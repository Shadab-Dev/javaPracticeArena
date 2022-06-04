package com.java.Graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
//        char[][] grid = {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if(i >= grid.length || i<0 || j >= grid[0].length || j<0 || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(grid, visited,i+1, j);
        dfs(grid, visited,i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
    }
}
