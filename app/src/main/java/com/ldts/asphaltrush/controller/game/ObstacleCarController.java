package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder;
import com.ldts.asphaltrush.model.game.street.Street;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleCarController extends GameController {
    private long lastMovement = 0;
    private static final Random RNG = new Random();
    private static final double OBSTACLE_CAR_SPEED = DEFAULT_SPEED*4;

    public ObstacleCarController(Street street) {
        super(street);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if ((time - lastMovement) > 100) {
            addNewObstacleCars();
            for (ObstacleCar obstacleCar : getModel().getObstacleCars()) {
                moveObstacleCar(obstacleCar, obstacleCar.getPosition());
            }
            this.lastMovement = time;
        }
        checkAndRemoveNewObstacleCars();
    }

    private void addNewObstacleCars() {
        ObstacleCar obstacleCar = getModel().getCarBuilder().createObstacleCar(RNG.nextInt(1, ObstacleCarBuilder.TYPESNUMBER+1));
        int r = RNG.nextInt(0, 4);
        int x = r-1+r* 28 + getModel().getLeftCurbWidth();
        int y = -50;
        obstacleCar.setPosition(new Position(x+((28-obstacleCar.getWidth())/2), y));
        if(!getModel().isObstacleCar(new Position(x,y), obstacleCar.getWidth(), obstacleCar.getHeight()) && !getModel().isHole(new Position(x,y), obstacleCar.getWidth(), obstacleCar.getHeight())
                && RNG.nextDouble(0, 40+getModel().getPlayer().getSpeed()) < 5)
            getModel().getObstacleCars().add(obstacleCar);
    }

    private void moveObstacleCar(ObstacleCar obstacleCar, Position position) {
        Position nextPosition = new Position(position.getX(), position.getY() + (int) (OBSTACLE_CAR_SPEED*getModel().getPlayer().getSpeed()));
        // (!getModel().isHole(position, obstacleCar.getWidth(), obstacleCar.getHeight()) && !getModel().isObstacleCar(position, obstacleCar.getWidth(), obstacleCar.getHeight())) ||
        if ((!getModel().isHole(nextPosition, obstacleCar.getWidth(), obstacleCar.getHeight())) && (!getModel().isObstacleCar(obstacleCar, nextPosition, obstacleCar.getWidth(), obstacleCar.getHeight())))
            obstacleCar.setPosition(nextPosition);
        else  obstacleCar.setPosition(new Position(position.getX(), position.getY() + (int) (DEFAULT_SPEED*getModel().getPlayer().getSpeed())));
    }

    private void checkAndRemoveNewObstacleCars() {
        List<ObstacleCar> obstacleCarsToRemove = new ArrayList<>();

        for (ObstacleCar obstacleCar : getModel().getObstacleCars()) {
            if (obstacleCar.getPosition().getY() >= getModel().getHeight()) {
                obstacleCarsToRemove.add(obstacleCar);
            }
        }

        getModel().getObstacleCars().removeAll(obstacleCarsToRemove);
    }
}
