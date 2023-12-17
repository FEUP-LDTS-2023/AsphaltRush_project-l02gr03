package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.Hole;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder;
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp;
import com.ldts.asphaltrush.model.game.street.Street;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HoleController extends GameController {

    private long lastMovement;
    private static final double HOLE_SPEED = DEFAULT_SPEED;
    private static final Random RNG = new Random();

    public HoleController(Street street) {
        super(street);
        this.lastMovement = System.currentTimeMillis();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovement > 100) {
            addNewHoles();
            for (Hole hole : getModel().getHoles()) {
                moveHole(hole, hole.getPosition());
            }
            this.lastMovement = time;
        }
        checkAndRemoveHoles();
    }

    private void moveHole(Hole hole, Position position) {
        hole.setPosition(new Position(position.getX(), position.getY() + (int) (HOLE_SPEED*getModel().getPlayer().getSpeed())));
    }

    private void checkAndRemoveHoles() {
        List<Hole> holesToRemove = new ArrayList<>();

        for (Hole hole : getModel().getHoles()) {
            if (hole.getPosition().getY() >= getModel().getHeight()+500) {
                holesToRemove.add(hole);
            }
        }

        getModel().getHoles().removeAll(holesToRemove);
    }

    private void addNewHoles() {
        int r = RNG.nextInt(0, 4);
        int x = r-1+r* 28 + getModel().getLeftCurbWidth();
        int y = -50;
        Hole hole = new Hole(x,y);
        hole.setPosition(new Position(x+((28-hole.getWidth())/2), y));
        if(!getModel().isHole(hole.getPosition(), hole.getWidth(), hole.getHeight()) && !getModel().isObstacleCar(hole.getPosition(), hole.getWidth(), hole.getHeight()) && RNG.nextDouble(0,100) < 2)
            getModel().getHoles().add(hole);
    }
}
