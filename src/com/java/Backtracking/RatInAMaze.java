package com.java.Backtracking;

import java.util.*;

public class RatInAMaze {
    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0},
                     {1, 1, 0, 1},
                     {1, 1, 0, 0},
                     {0, 1, 1, 1}};
        System.out.println(findPath(m, 2));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<>();
        if(m[0][0] == 0) return result;
        helper(m, 0, 0, "", result);
        return result;
    }

    private static void helper(int[][] m, int row, int column, String path, ArrayList<String> result) {
        if(row == m.length-1 && column == m.length-1) {
            result.add(path);
            return;
        }
        if(row >= m.length || column >= m.length || row < 0 || column < 0) return;

        if(row-1 >= 0 && m[row-1][column] == 1) {
            m[row][column] = 0;
            helper(m, row-1, column, path+"U", result);
            m[row][column] = 1;
        }

        if(row+1 <m.length && m[row+1][column] == 1) {
            m[row][column] = 0;
            helper(m, row+1, column, path+"D", result);
            m[row][column] = 1;
        }

        if(column-1>=0 && m[row][column-1] == 1) {
            m[row][column] = 0;
            helper(m, row, column-1, path+"L", result);
            m[row][column] = 1;
        }

        if(column+1<m.length && m[row][column+1] == 1) {
            m[row][column] = 0;
            helper(m, row, column+1, path+"R", result);
            m[row][column] = 1;
        }
    }
}
