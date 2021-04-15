package com.horseman.polish;


public class Board {
    private Pawn[][] board = null;
    private static Board kecske;

    private Board(int n) {
        Pawn[][] board = new Pawn[n][n];
        this.setBoard(board);
    }

    public static Board getInstance(int n) {
        if (kecske == null){
            kecske = new Board(n);
        }
        return kecske;
    }

    public Pawn[][] getBoard() {
        return board;
    }

    public void setBoard(Pawn[][] board) {
        this.board = board;
    }

    public void fillPawns() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 && j % 2 == 0) {
                    board[i][j] = new Pawn(1, i, j);
                } else if (i == 1 && j % 2 != 0) {
                    board[i][j] = new Pawn(1, i, j);
                } else if (i == 2 && j % 2 == 0) {
                    board[i][j] = new Pawn(1, i, j);
                } else if (i == getBoard().length - 1 && j % 2 != 0) {
                    board[i][j] = new Pawn(2, i, j);
                } else if (i == getBoard().length - 2 && j % 2 == 0) {
                    board[i][j] = new Pawn(2, i, j);
                } else if (i == getBoard().length - 3 && j % 2 != 0) {
                    board[i][j] = new Pawn(2, i, j);
                }
            }
        }
    }


    // Size can upto 15
    public void displayBoard(Pawn[][] board) {
        String[] letters = {"   ","1  ","2  ","3  ","4  ","5  ","6  ","7  ","8  ","9 ","10 ","11 ","12 ","13 ","14 ","15 ","16 ","17 ","18 ","19 ","20  "};
        for (int i =0; i<=1; i++) {
            System.out.println("");
            for (int j = 0; j <= board.length; j++) {
                //System.out.println();
                if (i == 0) {
                    System.out.print(letters[j]);
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print("");
                if (board[i][j] != null) {
                    if (board[i][j].getPlayerOne()) {
                        System.out.print(" O ");
                    } else {
                        System.out.print(" X ");
                    }
                } else {
                    if (i % 2 != 0) {
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
