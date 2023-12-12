package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;
import com.ldts.asphaltrush.model.game.street.Street;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerUpController extends GameController {

    private long lastMovement;
    private static final double POWER_UP_SPEED = DEFAULT_SPEED;
    private static final Random RNG = new Random();

    public PowerUpController(Street street) {
        super(street);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (time - lastMovement > 800/(POWER_UP_SPEED*getModel().getPlayer().getSpeed())) {
            addNewPowerUps();
            for (PowerUp powerUp : getModel().getPowerUps()) {
                movePowerUp(powerUp, powerUp.getPosition());
            }
            this.lastMovement = time;
            checkAndRemovePowerUps();
        }
    }

    private void movePowerUp(PowerUp powerUp, Position position) {
        if (getModel().isEmpty(position)) powerUp.setPosition(new Position(position.getX(), position.getY() + 1));
    }

    private void checkAndRemovePowerUps() {
        List<PowerUp> powerUpsToRemove = new ArrayList<>();

        for (PowerUp powerUp : getModel().getPowerUps()) {
            if (powerUp.getPosition().getY() >= getModel().getHeight()) {
                powerUpsToRemove.add(powerUp);
            }
        }

        getModel().getPowerUps().removeAll(powerUpsToRemove);
    }

    private void addNewPowerUps() {
        if(RNG.nextDouble(0,500) < 1) getModel().getPowerUps().add(new PointMultiplierPowerUp(RNG.nextInt(getModel().getLeftCurbWidth(),getModel().getLeftCurbWidth()+getModel().getWidth()) + 1, -30));
        if(RNG.nextDouble(0,500) < 1) getModel().getPowerUps().add(new InvenciblePowerUp(RNG.nextInt(getModel().getLeftCurbWidth(),getModel().getLeftCurbWidth()+getModel().getWidth()) + 1, -30));
    }
}
