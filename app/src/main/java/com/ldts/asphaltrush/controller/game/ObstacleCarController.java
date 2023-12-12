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
    private static final double OBSTACLE_CAR_SPEED = DEFAULT_SPEED*1.5;

    public ObstacleCarController(Street street) {
        super(street);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if ((time - lastMovement) > 800/(OBSTACLE_CAR_SPEED*getModel().getPlayer().getSpeed())) {
            addNewObstacleCars();
            for (ObstacleCar obstacleCar : getModel().getObstacleCars()) {
                moveObstacleCar(obstacleCar, obstacleCar.getPosition());
            }
            this.lastMovement = time;
            checkAndRemoveNewObstacleCars();
        }
    }

    private void addNewObstacleCars() {
        if(RNG.nextDouble(0,50) < 1) getModel().getObstacleCars().add(new ObstacleCar(RNG.nextInt(getModel().getLeftCurbWidth(), getModel().getLeftCurbWidth()+getModel().getWidth()) + 1, -50, 2));
    }

    private void moveObstacleCar(ObstacleCar obstacleCar, Position position) {
        if (getModel().isEmpty(position)) obstacleCar.setPosition(new Position(position.getX(), position.getY() + 1));
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
