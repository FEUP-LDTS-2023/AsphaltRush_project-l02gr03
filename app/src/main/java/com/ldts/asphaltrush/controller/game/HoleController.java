package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.Hole;
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
        if (time - lastMovement > 800/(HOLE_SPEED*getModel().getPlayer().getSpeed())) {
            addNewHoles();
            for (Hole hole : getModel().getHoles()) {
                moveHole(hole, hole.getPosition());
            }
            this.lastMovement = time;
            checkAndRemoveHoles();
        }
    }

    private void moveHole(Hole hole, Position position) {
        if (hole.getPosition().getY() >= getModel().getHeight())
            hole.setPosition(new Position(position.getX(), position.getY() - getModel().getHeight()));
        else
            hole.setPosition(new Position(position.getX(), position.getY() + 1));
    }

    private void checkAndRemoveHoles() {
        List<Hole> holesToRemove = new ArrayList<>();

        for (Hole hole : getModel().getHoles()) {
            if (hole.getPosition().getY() >= getModel().getHeight()) {
                holesToRemove.add(hole);
            }
        }

        getModel().getHoles().removeAll(holesToRemove);
    }

    private void addNewHoles() {
        if(RNG.nextDouble(0,100) < 1) getModel().getHoles().add(new Hole(RNG.nextInt(getModel().getWidth() - 2) + 1, -10));
    }
}
