package com.ldts.asphaltrush.model.game;

public class Points {
    private long points;
    private double multiplier;

    public Points() {
        this.points = 0;
        this.multiplier = 1;
    }

    public long getPoints() {
        return points;
    }

    public void increasePoints(int amount) {
        this.points += amount * multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double value) {
        multiplier = value;
    }
}
