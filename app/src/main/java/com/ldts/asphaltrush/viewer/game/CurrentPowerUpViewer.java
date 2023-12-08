package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.HashMap;
import java.util.Map;

public class CurrentPowerUpViewer implements ElementViewer<PowerUp> {

    private Map<Class<? extends PowerUp>, PowerUpDrawFunction> drawFunctions;

    public CurrentPowerUpViewer() {
        this.drawFunctions = new HashMap<>();
        drawFunctions.put(PointMultiplierPowerUp.class, (powerUp, gui) -> gui.drawPointMultiplierPowerUp(powerUp.getPosition()));
        drawFunctions.put(InvenciblePowerUp.class, (powerUp, gui) -> gui.drawInvenciblePowerUp(powerUp.getPosition()));
    }

    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        PowerUpDrawFunction drawFunction = drawFunctions.getOrDefault(powerUp.getClass(), drawFunctions.get(PowerUp.class));
        drawFunction.draw(powerUp, gui);
    }

    public interface PowerUpDrawFunction {
        void draw(PowerUp powerUp, GUI gui);
    }
}
