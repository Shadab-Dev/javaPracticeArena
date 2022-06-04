package com.java.Graphs;

import java.util.Arrays;

public class SurroundingIslands {
    public static void main(String[] args) {
        char[][] board = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
        };
        new SurroundingIslands().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;
        int m = board.length;
        int n = board[0].length;
        // replace all outer Os with Ts
        for (int i = 0; i < n; i++) {
            // recurse for first Row
            if(board[0][i] == 'O') dfs(board, 0, i);
            // recurse for last row
            if(board[m-1][i] == 'O') dfs(board, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            // recurse for first Column
            if(board[i][0] == 'O') dfs(board, i, 0);
            // recurse for last row
            if(board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        
        // Traverse to replace all inner Os with Ts
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                // Convert the Ts back to Os
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j] != 'O') return;
        board[i][j] = 'T';

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
