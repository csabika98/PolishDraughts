package com.horseman.polish;

public class Board {
    private Object[][] board;

    public Board(int n) {
        Object[][] board = new Object[n][n];
        this.setBoard(board);
    }

    public Object[][] getBoard() {
        return board;
    }

    public void setBoard(Object[][] board) {
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
//                        Pawn pawn = new Pawn(symbol, i, j);
                        board[i][j] = new Pawn(symbol, i, j);;
                    }
                } else if (i == position - 2) {
                    if (j % 2 == 0) {
//                        Pawn pawn = new Pawn(symbol, i, j);
                        board[i][j] = new Pawn(symbol, i, j);;
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
        String newBoard;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                //System.out.print(i == 0 || j == 0 ? i == 0 ? j : letters[i] : "█"); //trenary :)
//                if (board[i][j] == pawn_1 || board[i][j] == pawn_2) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j]);
                    if(board[i][j].getIsWhite()){
                        System.out.print(" 1 ");
                    } else {
                        System.out.print(" 2 ");
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
