package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.street.Street;
public class PlayerController extends GameController {

    private long lastMovement;

    public PlayerController(Street street) {
        super(street);
    }

    public void movePlayerLeft() {movePlayer(getModel().getPlayer().getPosition().getLeft());}

    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    public void increasePlayerSpeed() {
        getModel().getPlayer().increaseSpeed();
    }

    public void decreasePlayerSpeed() {
        getModel().getPlayer().decreaseSpeed();
    }

    private void movePlayer(Position position) {
        if (getModel().isEmpty(position)) getModel().getPlayer().setPosition(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovement > 100) {
            if (getModel().getPlayer().getPowerUp() != null) {
                getModel().getPlayer().decreasePowerUpTime();
                if (getModel().getPlayer().getPowerUpTime() <= 0) getModel().getPlayer().removePowerUp();
            }
            getModel().getPlayer().increaseMinSpeed();
            lastMovement = time;
        }
        if (action == GUI.ACTION.UP) increasePlayerSpeed();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) decreasePlayerSpeed();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();
    }
}
