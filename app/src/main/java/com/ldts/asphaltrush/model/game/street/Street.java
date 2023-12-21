package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.Points;
import com.ldts.asphaltrush.model.game.elements.*;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.LinkedList;
import java.util.List;

public class Street {

    private final int leftCurbWidth = 59;
    private final int width = 126;
    private final int height = 240;
    private Points points;
    private Player player;
    private List<ObstacleCar> obstacleCars;
    private List<PowerUp> powerUps;
    private LinkedList<Line> lines;
    private List<Hole> holes;

    private ObstacleCarBuilder carBuilder;


    public Street(ObstacleCarBuilder carBuilder) {
        this.points = new Points();
        this.carBuilder = carBuilder;
    }

    public ObstacleCarBuilder getCarBuilder(){
        return carBuilder;
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



    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
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

    public boolean isObstacleCar(ObstacleCar obstacleCar, Position position, int width, int height) {
        for (ObstacleCar car : obstacleCars)
            if(car == obstacleCar) return false;

            else if (car.getPosition().getX() < position.getX() + width &&
                    car.getPosition().getX() + car.getWidth() > position.getX() &&
                    car.getPosition().getY() < position.getY() + height &&
                    car.getPosition().getY() + car.getHeight() > position.getY())
                return true;
        return false;
    }

    public boolean isHole(Position position, int width, int height) {
        for (Hole hole : holes)
            if (hole.getPosition().getX() < position.getX() + width &&
                    hole.getPosition().getX() + hole.getWidth() > position.getX() &&
                    hole.getPosition().getY() < position.getY() + height &&
                    hole.getPosition().getY() + hole.getHeight() > position.getY())
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

    public int getLeftCurbWidth() {
        return leftCurbWidth;
    }
}
