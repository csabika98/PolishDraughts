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

    public String toString(Pawn[][] board) {
        //convert board to string
        return null;
    }

    // Size can upto 15
    public void displayBoard(Pawn[][] board) {
        //toString(board);
        //System print board string

        String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
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
