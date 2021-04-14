package com.horseman.polish;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    static int n;

    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Board size between 10-20: ");
            n = scanner.nextInt();
            //check valid input
            if (n > 20 || n < 10 || n % 2 != 0) {
                System.out.println("Size out of range");
            } else {
                //break out of loop and continue to create the board
                break;
            }
        }
        game.Start();
    }

    void Start() {
        int player = 1;
        Board board = new Board(n);
        board.fillPawns();

        while (true) {
            playRound(player,board); // wat?

            //switch player
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
        //printResult(player,isWinner)
    }

    int convertChar(String coordinateRow) {

        Map<String, Integer> abc = new HashMap<String, Integer>() {{
            put("A", 0);
            put("B", 1);
            put("C", 2);
            put("D", 3);
            put("E", 4);
            put("F", 5);
            put("G", 6);
            put("H", 7);
            put("I", 8);
            put("J", 9);
            put("K", 10);
            put("L", 11);
            put("M", 12);
            put("N", 13);
            put("O", 14);
            put("P", 15);
            put("Q", 16);
            put("R", 17);
            put("S", 18);
            put("T", 19);
            put("U", 20);
        }};
        return abc.get(coordinateRow);
    }

    void playRound(int player, Board[][] board) {
        boolean isWinner = false;

        int[] coordinates = getCoordinates(player);
        if (tryToMakeMove(coordinates[0], coordinates[1], coordinates[3])) {
            //movePawn()
            board.displayBoard(board);
            if (checkForWinner) {
                isWinner = true;
                //player won
            } else if (checkForDraw) {
                //last round before tie
            }
        }

    }

    int[] getCoordinates(int player) {
        Scanner scanner = new Scanner(System.in);

        String temp_x;

        int x;
        int y;

        while (true) {

            System.out.print("Input row: ");
            while (true) {
                temp_x = scanner.nextLine();
                if (temp_x.length() > 1) {
                    System.out.println("Row out of range");
                } else {
                    x = convertChar(temp_x);
                    break;
                }
            }

            System.out.print("Input column: ");
            while (true) {
                y = scanner.nextInt();
                if (y < 0 || y > n) {
                    System.out.println("Column out of range");
                } else {
                    break;
                }
            }
            break;

            //ask user input *Checks(); *Checks if valid position from user and within board
        }
        return new int[]{x, y, player};
    }

    boolean checkForWinner(Pawn[][] board) {
        //return if someone win or not
    }

    boolean checkForDraw(Pawn[][] board) {
        //return if it's a tie
    }

    void printResult(int player, boolean isWinner) {
        if (isWinner) {
            System.out.println("Player " + player + " won the game");
        } else {
            System.out.println("It's a tie");
        }
    }

}
