package com.java.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // The first step is to create a board and fill it with dots
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // We need the board and the currRow in our recursion stack
        helper(board, 0, result);
        return result;
    }

    private void helper(char[][] board, int row, List<List<String>> result) {
        if(row == board.length) {
            // Using builder method we just add the whole board to our answer
            result.add(builder(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            // We need to keep a queen at each column for the row
            board[row][i] = 'Q';
            // We use the valid method to check if the queen is attacked by any other queen
            if(isValid(board, row, i))
                // If its not attacked, then we continue with other rows
                helper(board, row+1, result);
            // Irrespective of whether the queen is attacked or not, we have to backtrack our changes
            // So that we get a fresh cells for the next recursive call
            board[row][i] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                // For each row above the currRow, we need to check if any cell contains a Queen
                // If there exists a queen, then we need to check if that queen
                // is in the same column or in the same diagonal than that of our current queen
                if(board[i][j] == 'Q' && (j == column || Math.abs(row-i) == Math.abs(column-j)))
                    return false;
            }
        }
        return true;
    }

    private List<String> builder(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }
}
