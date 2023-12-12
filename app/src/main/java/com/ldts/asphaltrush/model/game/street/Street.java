package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.Points;
import com.ldts.asphaltrush.model.game.elements.*;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.LinkedList;
import java.util.List;

public class Street {
    private final int width = 260;
    private final int height = 240;
    private Points points;
    private Player player;
    private List<ObstacleCar> obstacleCars;
    private List<PowerUp> powerUps;
    private List<Barrier> barriers;
    private LinkedList<Line> lines;
    private List<Hole> holes;
    private List<Jump> jumps;

    public Street() {
        this.points = new Points();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Barrier> getBarriers() {
        return barriers;
    }

    public void setBarriers(List<Barrier> barriers) {
        this.barriers = barriers;
    }

    public LinkedList<Line> getLines() {
        return lines;
    }

    public void setLines(LinkedList<Line> lines) {
        this.lines = lines;
    }

    public List<ObstacleCar> getObstacleCars() {
        return obstacleCars;
    }

    public void setObstacleCars(List<ObstacleCar> obstacleCars) {
        this.obstacleCars = obstacleCars;
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    public List<Jump> getJumps() {
        return jumps;
    }

    public void setJumps(List<Jump> jumps) {
        this.jumps = jumps;
    }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public boolean isEmpty(Position position) {
        for (Barrier barrier : barriers)
            if (barrier.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isObstacleCar(Position position, int width, int height) {
        for (ObstacleCar obstacleCar : obstacleCars)
            if (obstacleCar.getPosition().getX() < position.getX() + width &&
                    obstacleCar.getPosition().getX() + obstacleCar.getWidth() > position.getX() &&
                    obstacleCar.getPosition().getY() < position.getY() + height &&
                    obstacleCar.getPosition().getY() + obstacleCar.getHeight() > position.getY())
                return true;
        return false;
    }

    public boolean isHole(Position position) {
        for (Hole hole : holes)
            if (hole.getPosition().equals(position))
                return true;
        return false;
    }

    public PowerUp getPowerUp(Position position, int width, int height) {
        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().getX() < position.getX() + width &&
                    powerUp.getPosition().getX() + powerUp.getWidth() > position.getX() &&
                    powerUp.getPosition().getY() < position.getY() + height &&
                    powerUp.getPosition().getY() + powerUp.getHeight() > position.getY()) {
                return powerUp;
            }
        return null;
    }

    public boolean isPowerUp(Position position, int width, int height) {
        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().getX() < position.getX() + width &&
                    powerUp.getPosition().getX() + powerUp.getWidth() > position.getX() &&
                    powerUp.getPosition().getY() < position.getY() + height &&
                    powerUp.getPosition().getY() + powerUp.getHeight() > position.getY())
                return true;
        return false;
    }

    public Points getPoints() {
        return points;
    }
}
