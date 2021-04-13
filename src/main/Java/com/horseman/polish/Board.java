package com.horseman.polish;

public class Board {
    private int[][] board;

    public Board(int n){
        int[][] board = new int[n][n];

    }

    public int[][] setBoard(int[][] board){
    return this.board = board;
    }

    public int[][] getBoard(){
    return board;
    }

}
