package com.ldts.asphaltrush.model.game.elements;

import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

public class Player extends Element {

    private static final int NUMBEROFTYPES = 1;
    private int type = 6;

    private double speed = 1;
    private double minSpeed = 1;
    private double maxSpeed = 3.4;
    private boolean crashed = false;
    private PowerUp powerUp;
    private double powerUpTime;


    public int getType(){
        return type;
    }
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

    public void increaseMinSpeed() {
        minSpeed += 0.0005;
        speed = Math.max(speed, minSpeed);
    }

    public boolean getCrashed() {
        return this.crashed;
    }

    public void setCrashed() {
        this.crashed = true;
    }

    public PowerUp getPowerUp() {
        return this.powerUp;
    }

    public void addPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
        this.powerUpTime = 15.0;
    }

    public void removePowerUp() {
        this.powerUp = null;
        powerUpTime = 0;
    }

    public double getPowerUpTime() {
        return this.powerUpTime;
    }

    public void decreasePowerUpTime() {
        powerUpTime-=0.1;
    }
}
