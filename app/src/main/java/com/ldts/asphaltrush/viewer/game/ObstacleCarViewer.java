package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar;


public class ObstacleCarViewer implements ElementViewer<ObstacleCar> {
    @Override
    public void draw(ObstacleCar element, GUI gui, ImageFactory imageFactory) {
        // Draw the obstacle cars considering their type
        gui.drawImage(element.getPosition(), imageFactory.getImage( "/cars/obstacle/car"+ element.getType()));
    }
}
