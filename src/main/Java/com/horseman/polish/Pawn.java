package com.horseman.polish;

public class Pawn {

    private String color;

    Pawn(String color, int x, int y) {
        this.setColor(color);
        Coordinates.x = x;
        Coordinates.y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    public boolean getIsWhite() {
        return color.equals("white");
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
