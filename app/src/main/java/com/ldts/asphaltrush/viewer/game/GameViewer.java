package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
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
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getBarriers(), new BarrierViewer());
        drawElements(gui, getModel().getLines(), new LineViewer());
        drawElements(gui, getModel().getObstacleCars(), new ObstacleCarViewer());
        drawElements(gui, getModel().getHoles(), new HoleViewer());
        drawElements(gui, getModel().getJumps(), new JumpViewer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());

        gui.drawText(new Position(0, 0), getModel().getPoints().getPoints() + " " + Math.round(getModel().getPoints().getMultiplier() * 10.0) / 10.0 + "x", "#FFFFFF");

        PowerUp playerPowerUp = getModel().getPlayer().getPowerUp();
        if(playerPowerUp != null) {
            playerPowerUp.setPosition(new Position(14,-1));
            drawElement(gui, playerPowerUp, new CurrentPowerUpViewer());
        }
        else gui.drawText(new Position(14, 0), "/","#FFFFFF");

        gui.drawText(new Position(16, 0), String.valueOf(Math.round(getModel().getPlayer().getPowerUpTime() * 10.0) / 10.0), "#FFFFFF");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
