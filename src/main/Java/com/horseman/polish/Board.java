package com.horseman.polish;

public class Board {
    private String[][] board;

    public Board(int n) {
        String[][] board = new String[n][n];
        this.setBoard(board);
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void fillPawns(String symbol, int position) {

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                //Instance pawn object
                if (i == position - 1) {
                    if (j % 2 != 0) {
                        //pawn.x = i
                        //pawn.y = j
                        //board[i][j] = pawnObject;
                        board[i][j] = symbol;
                    }
                } else if (i == position - 2) {
                    if (j % 2 == 0) {
                        board[i][j] = symbol;
                    }
                }
            }
        }
    }

    // Size can upto 15
    public void displayBoard() {
        String pawn_1 = " X ";
        String pawn_2 = " O ";
        String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                //System.out.print(i == 0 || j == 0 ? i == 0 ? j : letters[i] : "█"); //trenary :)
                if (board[i][j] == pawn_1 || board[i][j] == pawn_2) {
                    System.out.print(board[i][j]);
                } else {
                    if (i % 2 != 0 && i != 0) {
                        if (j % 2 != 0) {
                            System.out.print("   ");
                        } else {
                            System.out.print("███");
                        }
                    }
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            System.out.print("   ");
                        } else {
                            System.out.print("███");
                        }
                    }
                    //if (j > 8 && i == 0) {
                      //  System.out.print(" ");
                   // }
                }
            }
            System.out.println();
        }
    }
}
