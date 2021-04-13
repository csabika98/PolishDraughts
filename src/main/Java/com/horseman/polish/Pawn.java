package com.horseman.polish;

public class Pawn {

    private String color;

    Pawn() {
        this.setColor("white");
    }
    Pawn(String color) {
        this.setColor("black");
    }

    public void setColor(String color) {
        this.color = color;
    }
    public boolean getIsWhite() {
        return color.equals("white");
    }
}
