package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

public class CurrentPowerUpViewer implements ElementViewer<PowerUp> {

    @Override
    public void draw(PowerUp powerUp, GUI gui, ImageFactory imageFactory) {
        // Draw the active PowerUp on the right corner considering its type
        gui.drawImage(new Position(248, 220), imageFactory.getImage("/elements/"+powerUp.getType()), 'c', 't');
    }
}
