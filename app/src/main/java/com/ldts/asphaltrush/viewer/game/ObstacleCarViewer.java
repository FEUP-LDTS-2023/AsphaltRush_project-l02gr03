package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.elements.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

public class ObstacleCarViewer implements ElementViewer<ObstacleCar> {
    @Override
    public void draw(ObstacleCar element, GUI gui) {
        gui.drawObstacleCar(element.getPosition());
    }
}
