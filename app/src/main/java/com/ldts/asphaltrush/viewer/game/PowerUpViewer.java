package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.HashMap;
import java.util.Map;

public class PowerUpViewer implements ElementViewer<PowerUp> {

    @Override
    public void draw(PowerUp element, GUI gui, ImageFactory imageFactory) {
        Image image = imageFactory.getImage("/elements/"+element.getType());
        gui.drawImage(element.getPosition(), image);
    }
}
