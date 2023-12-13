package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.ObstacleCar;
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
        if ((time - lastMovement) > 200*(Math.min(OBSTACLE_CAR_SPEED*getModel().getPlayer().getSpeed(),4))) {
            addNewObstacleCars();
            this.lastMovement = time;
        }

        for (ObstacleCar obstacleCar : getModel().getObstacleCars()) {
            moveObstacleCar(obstacleCar, obstacleCar.getPosition());
        }
        checkAndRemoveNewObstacleCars();
    }

    private void addNewObstacleCars() {
        int x = RNG.nextInt(1, 5) * 28 + getModel().getLeftCurbWidth() + 10;
        int y = -50;
        int type = RNG.nextInt(1, 5);
        ObstacleCar obstacleCar = new ObstacleCar(x, y, type);
        if(!getModel().isObstacleCar(new Position(x,y), obstacleCar.getWidth(), obstacleCar.getHeight()))
            getModel().getObstacleCars().add(obstacleCar);
    }

    private void moveObstacleCar(ObstacleCar obstacleCar, Position position) {
        if (getModel().isEmpty(position)) obstacleCar.setPosition(new Position(position.getX(), position.getY() + (int) (OBSTACLE_CAR_SPEED*getModel().getPlayer().getSpeed())));
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
