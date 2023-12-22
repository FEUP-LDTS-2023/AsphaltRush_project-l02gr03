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

    public void movePlayerLeft() {
        // Move the player to the lane on its left
        movePlayer(new Position(getModel().getPlayer().getPosition().getX()-28, getModel().getPlayer().getPosition().getY()));
    }

    public void movePlayerRight() {
        // Move the player to the lane on its right
        movePlayer(new Position(getModel().getPlayer().getPosition().getX()+28, getModel().getPlayer().getPosition().getY()));
    }

    public void increasePlayerSpeed() {
        // Increase the speed of the player
        getModel().getPlayer().increaseSpeed();
    }


    public void decreasePlayerSpeed() {
        // Decrease the speed of the player
        getModel().getPlayer().decreaseSpeed();
    }

    private void movePlayer(Position position) {
        // Actually moves the player, checking if its possible to do so
        if(position.getX() > getModel().getLeftCurbWidth() &&
                position.getX() < (getModel().getLeftCurbWidth() + getModel().getWidth()))
            getModel().getPlayer().setPosition(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        // Moves the player every x amount of time
        if (time - lastMovement > 100) {
            // If player has PowerUp active, decrease the time remaining of the PowerUp
            if (getModel().getPlayer().getPowerUp() != null) {
                getModel().getPlayer().decreasePowerUpTime();
                // Check if the remaining PowerUp time reached zero, if so, remove it
                if (getModel().getPlayer().getPowerUpTime() <= 0) getModel().getPlayer().removePowerUp();
            }
            // Increase slightly the speed of the player
            getModel().getPlayer().increaseMinSpeed();
            lastMovement = time;
        }
        // Consider the different inputs
        if (action == GUI.ACTION.UP) increasePlayerSpeed();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) decreasePlayerSpeed();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();
    }
}