package com.horseman.polish;

public class Board {
    private int[][] board;

    public Board(int n) {
        int[][] board = new int[n][n];
        this.setBoard(board);
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    // Size can upto 15
    public void displayBoard() {
        String pawn_1 = "X";
        String pawn_2 = "O";
        String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M","N","O"};

        for (int i = 0; i <= board[0].length; i++) {
            for (int j = 0; j <= board.length; j++) {
                System.out.print(i == 0 || j == 0 ? i == 0 ? letters[j] : letters[i] : "-"); //trenary :)
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
