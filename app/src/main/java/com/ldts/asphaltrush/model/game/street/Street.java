package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.Points;
import com.ldts.asphaltrush.model.game.elements.*;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.List;

public class Street {
    private final int width;
    private final int height;
    private Points points;
    private Player player;
    private List<ObstacleCar> obstacleCars;
    private List<PowerUp> powerUps;
    private List<Barrier> barriers;
    private List<Line> lines;
    private List<Hole> holes;
    private List<Jump> jumps;

    public Street(int width, int height) {
        this.width = width;
        this.height = height;
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

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
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
}
