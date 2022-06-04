package com.java.Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        // First we iterate through all the cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // We only stop when we find an empty cell,
                // if don't find any empty cell in the board, then it's already valid, hence we return true (Line 30)
                if(board[i][j] == '.') {
                    // Then we try to find a number which we can add to this cell
                    for (char c = '1'; c <= '9'; c++) {
                        // We can only add the number if it follows the 3 rules of sudoku
                        if(isValid(board, i, j, c)) {
                            // We have found a valid number, hence we add it
                            board[i][j] = c;
                            // After adding we check if the current board is valid or not using recursion
                            if(helper(board)) return true;
                            // If its not valid, then we backtrack our changes
                            board[i][j] = '.';
                        }
                    }
                    // At this step, we have checked all rows and have not found any valid numbers that we can put,
                    // hence we return false and move to other recursion branch
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0; i < 9; i++) {
            if(board[i][column] != '.' && board[i][column] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (column / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == c) return false;
        }
        return true;
    }
}
