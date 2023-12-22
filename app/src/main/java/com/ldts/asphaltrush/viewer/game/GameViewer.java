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

        // Draw background
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/street"));

        // Make every viewer draw its own model
        drawElements(gui, getModel().getLines(), new LineViewer(), imageFactory);
        drawElements(gui, getModel().getObstacleCars(), new ObstacleCarViewer(), imageFactory);
        drawElements(gui, getModel().getHoles(), new HoleViewer(), imageFactory);
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer(), imageFactory);
        drawElement(gui, getModel().getPlayer(), new PlayerViewer(), imageFactory);

        // Draw total points considering the numbers as small
        gui.drawText(String.valueOf(getModel().getPoints().getPoints()), new Position(260, 2), imageFactory, 'r', true);
        // Draw current multiplier considering the numbers as small
        gui.drawText(Math.round(getModel().getPoints().getMultiplier() * 10.0) / 10.0 + "x", new Position(260, 10), imageFactory, 'r', true);


        // Get current PowerUp
        PowerUp playerPowerUp = getModel().getPlayer().getPowerUp();

        // Only draw active PowerUp if there is one active
        if(playerPowerUp != null) {
            playerPowerUp.setPosition(new Position(14,-1));

            // Call the corresponding viewer
            drawElement(gui, playerPowerUp, new CurrentPowerUpViewer(), imageFactory);

            // Draw the time bar
            int barSize = 45;
            // Calculate the size of the bar considering the time passed
            int currentSize = (int)Math.round((double)barSize/getModel().getPlayer().getPowerUpDuration()*Math.round(getModel().getPlayer().getPowerUpTime() * 10.0) / 10.0);
            // Draw the inside of the bar
            gui.drawRectangle(new Position(246, 170 + barSize-currentSize), 3, currentSize, "#FFFFFF");
            // Draw the outside of the bar
            gui.drawImage(new Position(248,215),imageFactory.getImage("/elements/bar"), 'c', 'b');
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
