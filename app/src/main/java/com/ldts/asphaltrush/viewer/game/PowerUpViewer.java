package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.HashMap;
import java.util.Map;

public class PowerUpViewer implements ElementViewer<PowerUp> {

    private Map<Class<? extends PowerUp>, PowerUpDrawFunction> drawFunctions;

    public PowerUpViewer() {
        this.drawFunctions = new HashMap<>();
        drawFunctions.put(PointMultiplierPowerUp.class, (powerUp, gui) -> gui.drawPointMultiplierPowerUp(powerUp.getPosition()));
        drawFunctions.put(InvenciblePowerUp.class, (powerUp, gui) -> gui.drawInvenciblePowerUp(powerUp.getPosition()));
    }

    public interface PowerUpDrawFunction {
        void draw(PowerUp powerUp, GUI gui);
    }

    @Override
    public void draw(PowerUp element, GUI gui, ImageFactory imageFactory) {
        PowerUpDrawFunction drawFunction = drawFunctions.getOrDefault(element.getClass(), drawFunctions.get(PowerUp.class));
        drawFunction.draw(element, gui);
    }
}
