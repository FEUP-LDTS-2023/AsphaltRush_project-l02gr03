package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.Element;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;
import com.ldts.asphaltrush.model.game.street.Street;
import com.ldts.asphaltrush.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Street> {
    public GameViewer(Street model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui, ImageFactory imageFactory) {

        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/street"));

        drawElements(gui, getModel().getLines(), new LineViewer(), imageFactory);
        drawElements(gui, getModel().getObstacleCars(), new ObstacleCarViewer(), imageFactory);
        drawElements(gui, getModel().getHoles(), new HoleViewer(), imageFactory);
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer(), imageFactory);
        drawElement(gui, getModel().getPlayer(), new PlayerViewer(), imageFactory);


        gui.drawText(String.valueOf(getModel().getPoints().getPoints()), new Position(260, 2), imageFactory, 'r', true);
        gui.drawText(Math.round(getModel().getPoints().getMultiplier() * 10.0) / 10.0 + "x", new Position(260, 10), imageFactory, 'r', true);


        PowerUp playerPowerUp = getModel().getPlayer().getPowerUp();
        if(playerPowerUp != null) {
            playerPowerUp.setPosition(new Position(14,-1));
            drawElement(gui, playerPowerUp, new CurrentPowerUpViewer(), imageFactory);

            int barSize = 45;
            int currentSize = (int)Math.round(barSize/5.0*Math.round(getModel().getPlayer().getPowerUpTime() * 10.0) / 10.0);
            gui.drawRectangle(new Position(245, 170 + barSize-currentSize), 3, currentSize, "#FFFFFF");
            gui.drawImage(new Position(244,169),imageFactory.getImage("/elements/bar"));
        }


    }


    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer, ImageFactory imageFactory) {
        for (T element : elements)
            drawElement(gui, element, viewer, imageFactory);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer, ImageFactory imageFactory) {
        viewer.draw(element, gui, imageFactory);
    }
}
