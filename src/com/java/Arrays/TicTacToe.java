package com.java.Arrays;

public class TicTacToe {
    public static void main(String[] args) {
        int[][] board = {
                {1,1,0},
                {0,0,1},
                {0,1,0}
        };
        TicTacToe c = new TicTacToe();
        System.out.println(c.winner(board));
    }

    public boolean winner(int[][] board) {
        int diag1Sum = 0;
        int diag2Sum = 0;
        for (int i = 0; i < board.length; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < board.length; j++) {
                rowSum += board[i][j];
                columnSum += board[j][i];
                if(i == j) diag1Sum += board[i][j];
                if(i + j == board.length-1) diag2Sum += board[i][j];
            }
            if (rowSum == 0 ||
                rowSum == board.length ||
                columnSum == 0 ||
                columnSum == board.length)
                return true;
        }
        if(diag1Sum == 0 || diag1Sum == board.length || diag2Sum == 0 || diag2Sum == board.length) return true;
        return false;
    }
}
