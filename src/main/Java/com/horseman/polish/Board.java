package com.horseman.polish;


public class Board {
    private Pawn[][] board = null;
    private static Board kecske;

    private Board(int n) {
        Pawn[][] board = new Pawn[n][n];
        this.setBoard(board);
    }

    public static Board getInstance(int n) {
        if (kecske == null) {
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


    public void displayBoard(Pawn[][] board, int player1, int player2) {
        String[] numbers = {"   ", "1  ", "2  ", "3  ", "4  ", "5  ", "6  ", "7  ", "8  ", "9 ", "10 ", "11 ", "12 ", "13 ", "14 ", "15 ", "16 ", "17 ", "18 ", "19 ", "20  "};
        for (int i = 0; i <= 1; i++) {
            System.out.println();
            for (int j = 0; j <= board.length; j++) {
                if (i == 0) {
                    System.out.print(numbers[j]);
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print("");
                if (board[i][j] != null) {
                    if (board[i][j].getPlayerOne()) {
                        System.out.print("\033[0;34m O \033[0m");
                    } else {
                        System.out.print("\033[0;33m O \033[0m");
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
                }
                if (i == 0) {
                    if (j == board.length - 1) {
                        System.out.print(" \033[0;34m Player 1 pawns: \033[0m" + player1);
                    }
                } else if (i == board[0].length-1) {
                    if (j == board.length - 1) {
                        System.out.print(" \033[0;33m Player 2 pawns: \033[0m" + player2);
                    }
                }
            }
            System.out.println();
        }
    }
}
