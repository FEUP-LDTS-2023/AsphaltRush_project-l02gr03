package com.ldts.asphaltrush.model.game.elements;

public class Player extends Element {

    private double speed = 1;
    private double minSpeed = 1;
    private double maxSpeed = 3.4;

    public Player(int x, int y) {
        super(x, y);
    }

    public double getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        if(speed < maxSpeed) this.speed+=0.2;
    }

    public void decreaseSpeed() {
        speed = Math.max(minSpeed, speed-0.4);
    }
}
