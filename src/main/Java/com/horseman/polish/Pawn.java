package com.horseman.polish;

public class Pawn {

    private int player;

    Pawn(int player, int x, int y) {
        this.setPlayer(player);
        Coordinates.x = x;
        Coordinates.y = y;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
    public int getPlayer() {
        return this.player;
    }
    public boolean getPlayerOne() {
        return player.equals(1);
    }

    public void setCoordinates(int x, int y) {
        Coordinates.x = x;
        Coordinates.y = y;
    }

    public int[] getCoordinates() {
        return new int[]{Coordinates.x, Coordinates.y};
    }

    static class Coordinates {
        public static int x;
        public static int y;

    }
}
