package com.horseman.polish;
import java.util.*;

public class Bboard {
    // I never actually use the EMPTY variable in my code
    final int EMPTY = 0;
    final int BLACK = 2;
    final int WHITE = 1;
    int player;
    int[][] area = new int[19][19];

    /*
     * This is method allows the player to play their piece
     */
    void place(int row, int column, int player) {
        area[row][column] = 0;
        if (player == WHITE) {
            area[row][column] = WHITE;
        } else if (player == BLACK) {
            area[row][column] = BLACK;
        } else
            area[row][column] = EMPTY;
    }

    /*
     * The hasHorizontalWin method uses a count variable to count the pieces in
     * a row, but it appears to only count from row 18 and column 18
     */
    boolean hasHorizontalWin(int player) {
        int count = 0;
        boolean isWinner = false;
        for (int row = 0; row < area.length; row++) {
            for (int column = 0; column < area[row].length; column++) {
                if (area[row][column] == player)
                    count++;

                else
                    count = 0;
            }
        }
        if (count == 5)
            isWinner = true;

        else
            isWinner = false;

        return isWinner;

    }

    /*
     * The hasVerticalWin method works like the hasHorizontalWin method except
     * it checks the columns, also starting from row 18 and column 18
     */
    boolean hasVerticalWin(int player) {
        int count = 0;
        boolean isWinner = false;

        for (int row = 0; row < area.length; row++) {
            for (int column = 0; column < area[row].length; column++) {
                if (area[column][row] == player)
                    count++;
                else
                    count = 0;
            }
        }
        if (count == 5)
            isWinner = true;
        else
            isWinner = false;

        return isWinner;

    }

    // My hasWin method uses an if statement to check the two winning conditions
    boolean hasWin(int player) {
        boolean isWinner = false;

        if (hasVerticalWin(player) == true || hasHorizontalWin(player) == true) {
            System.out.println("You Win!");
            isWinner = true;
        }

        else
            isWinner = false;

        return isWinner;
    }

    // My play method
    void play() {
        // My scanner object to read input from player
        Scanner sc = new Scanner(System.in);
        int turn = 0;
        while (hasWin(player) == false) {
            turn++;

            System.out.println(this);
            /*
             * By creating a variable called turn then using a modular operator
             * I am able to switch between players
             */
            if (turn % 2 != 0) {
                player = WHITE;
                System.out.println("White to play");

            } else {
                player = BLACK;
                System.out.println("Black to play");

            }

            System.out.print("Row: ");
            int row = sc.nextInt();
            System.out.print("Column: ");
            int column = sc.nextInt();
            // Allows player to place piece
            place(row, column, player);

        }
    }

    // My toString() method to print out the board
    public String toString() {
        String result = "";
        for (int row = 0; row < area.length; row++) {
            result += "\n";
            for (int column = 0; column < area[row].length; column++) {

                if (area[row][column] == WHITE) {
                    result += "+o";
                }

                else if (area[row][column] == BLACK) {

                    result += "+x";
                }

                else
                    result += "+-";
            }
        }

        return result;
    }
}


