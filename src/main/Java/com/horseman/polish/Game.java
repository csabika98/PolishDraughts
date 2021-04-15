package com.horseman.polish;

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
        boolean isWinner = false;
        Board board = Board.getInstance(n);
        board.fillPawns();
        board.displayBoard(board.getBoard());
        while (true) {
            playRound(player, board.getBoard()); // wat?
            board.displayBoard(board.getBoard());
            if (checkForWinner()) {
                isWinner = true;
                break;
                //player won
            } else if (checkForDraw()) {
                break;
                //last round before tie
            }

            //switch player
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
        //printResult(player,isWinner)
    }

    int convertChar(char coordinateRow) {
        return (int) coordinateRow -97;
    }

    void movePawn(int x, int y, int player) {
        Board board = Board.getInstance(n);
        board.getBoard()[x][y] = new Pawn(player, x, y);
    }
    void removePawn(int x, int y) {
        Board board = Board.getInstance(n);
        board.getBoard()[x][y] = null;
    }

    void changePosition(int prevPosX, int prevPosY, int nextPosX, int nextPosY, int player, boolean hit) {
        movePawn(nextPosX, nextPosY, player);
        removePawn(prevPosX, prevPosY);

        if (hit) {
            int enemyX = 0;
            int enemyY = 0;
            if (prevPosY < nextPosY){
                enemyY = prevPosY + 1;
            } else if (prevPosY > nextPosY) {
                enemyY = prevPosY - 1;
            }
            if(player==1){
                enemyX = prevPosX +1;
            } else if (player==2){
                enemyX = prevPosX -1;
            }
            removePawn(enemyX, enemyY);
        }
    }

    void playRound(int player, Pawn[][] board) {
        boolean isWinner = false;
        int[] pawnPosition;
        int[] moveCoordinates;
        do {
            pawnPosition = getCoordinates(player, "chosen pawn");
            moveCoordinates = getCoordinates(player, "position to move");
        } while (!tryToMakeMove(pawnPosition[0], pawnPosition[1], moveCoordinates[0], moveCoordinates[1], pawnPosition[2]));

        if (isNextStepHit(pawnPosition[0], pawnPosition[1], moveCoordinates[0], moveCoordinates[1], pawnPosition[2])) {
            changePosition(pawnPosition[0], pawnPosition[1], moveCoordinates[0], moveCoordinates[1], pawnPosition[2], true);
        } else {
            changePosition(pawnPosition[0], pawnPosition[1], moveCoordinates[0], moveCoordinates[1], pawnPosition[2], false);
        }

        //movePawn(moveCoordinates[0], moveCoordinates[1], coordinates[3]);
        //removePawn()
        //board.displayBoard(board);
    }

    int[] getCoordinates(int player, String request) {
        Scanner scanner = new Scanner(System.in);

        String temp_x;

        int x;
        int y;

        while (true) {
            System.out.print("Select " + request + " first coordinate (eg.: a, b, or c...): ");
            temp_x = scanner.nextLine();
            if (temp_x.length() > 1) {
                System.out.println("Row out of range");
            } else {
                x = convertChar(temp_x.toLowerCase().charAt(0));
                break;
            }
        }

        while (true) {
            System.out.print("Select " + request + " second coordinate (eg.: 1, 2 or 3...): ");
            y = scanner.nextInt();
            if (y < 0 || y > n) {
                System.out.println("Column out of range");
            } else {
                break;
            }

            //ask user input *Checks(); *Checks if valid position from user and within board
        }
        return new int[]{x, y-1, player};
    }

    void printResult(int player, boolean isWinner) {
        if (isWinner) {
            System.out.println("Player " + player + " won the game");
        } else {
            System.out.println("It's a tie");
        }
    }

    boolean tryToMakeMove(int pawnPosX, int pawnPosY, int movePosX, int movePosY, int player) {
        // cuurent pos is pawn & own
        Board board = Board.getInstance(n);
        if (board.getBoard()[pawnPosX][pawnPosY].getPlayer() == player && board.getBoard()[movePosX][movePosY] == null) {
            if (player == 1){
                if ((movePosY == pawnPosY - 1 || movePosY == pawnPosY +1) && movePosX == pawnPosX + 1) {
                    return true;
                } else if ((movePosY == pawnPosY - 2 || movePosY == pawnPosY +2) && movePosX == pawnPosX + 2){
                    return true;
                }
            } else if (player == 2){
                if ((movePosY == pawnPosY - 1 || movePosY == pawnPosY +1) && movePosX == pawnPosX - 1) {
                    return true;
                } else if ((movePosY == pawnPosY - 2 || movePosY == pawnPosY +2) && movePosX == pawnPosX - 2){
                    return true;
                }
            }
        }
        // next pos null

        // only one step

        return false;
    }

    boolean isNextStepHit(int pawnPosX, int pawnPosY, int movePosX, int movePosY, int player) {
        Board board = Board.getInstance(n);
        int enemyX = 0;
        int enemyY = 0;
        if (pawnPosY< movePosY){
            enemyY = pawnPosY + 1;
        } else if (pawnPosY > movePosY) {
            enemyY = pawnPosY - 1;
        }
        if (player == 1 && ((movePosY == pawnPosY - 2 || movePosY == pawnPosY + 2) && movePosX == pawnPosX + 2)) {
            enemyX = pawnPosX + 1;
            return board.getBoard()[enemyX][enemyY] != null && board.getBoard()[enemyX][enemyY].getPlayer() == 2;
        } else if(player == 2 && ((movePosY == pawnPosY - 2 || movePosY == pawnPosY + 2) && movePosX == pawnPosX - 2)){
            enemyX = pawnPosX - 1;
            return board.getBoard()[enemyX][enemyY] != null && board.getBoard()[enemyX][enemyY].getPlayer() == 1;
        }
        return false;

    }
    boolean checkForWinner() {
        return false;
    }
    boolean checkForDraw() {
        return false;
    }
}
