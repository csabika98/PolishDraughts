package com.horseman.polish;

public class Board {
    String pawn_1 = "X";
    String pawn_2 = "O";
    static String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M","N","O"};
    // Size can upto 15
    public static void displayBoard(int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                System.out.print(i == 0 || j == 0 ? i == 0 ? letters[j] : letters[i] : "-"); //trenary :)
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
