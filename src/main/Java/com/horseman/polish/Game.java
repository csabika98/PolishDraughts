package com.horseman.polish;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while(true){
            System.out.print("Board size between 10-20: ");
            n = scanner.nextInt();
            //check valid input
            if (n > 20 || n < 10 || n % 2 != 0){
                System.out.println("Size out of range");
            }else{
                //break out of loop and continue to create the board
                break;
            }
        }
        Board board = new Board(n);
        board.fillPawns();
        board.displayBoard();
        //Start();
    }

    static void Start(String[][] board){
        //starts game between players
    }


    //playRound(); *Checks who's playing *Checks if there's a winner

    //Checks(); *Checks if valid position from user and within board
    // if yes, tryToMakeMove() called on pawn instance
    //checkForWinner() * Check after each round of valid play, also check for draw!
}
