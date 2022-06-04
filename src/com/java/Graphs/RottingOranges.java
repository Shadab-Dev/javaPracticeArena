package com.java.Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,2},
                {1,1},
                {0,0},
                {2,0}
        };
        System.out.println(new RottingOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int result;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(Arrays.asList(i, j));
                }
            }
        }
        result = bfs(grid, queue);

        // check if there are any oranges that are not rotten
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int bfs(int[][] grid, Queue<List<Integer>> queue) {
        if(queue.isEmpty()) return 0;
        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                List<Integer> curr = queue.poll();
                int x = curr.get(0);
                int y = curr.get(1);
                if (x - 1 > -1 && grid[x - 1][y] == 1) {
                    grid[x-1][y] = 2;
                    queue.add(Arrays.asList(x - 1, y));
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x+1][y] = 2;
                    queue.add(Arrays.asList(x + 1, y));
                }
                if (y - 1 > -1 && grid[x][y - 1] == 1) {
                    grid[x][y-1] = 2;
                    queue.add(Arrays.asList(x, y - 1));
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y+1] = 2;
                    queue.add(Arrays.asList(x, y + 1));
                }
            }
            System.out.println(queue);
            result++;
        }
        return result;
    }
}
