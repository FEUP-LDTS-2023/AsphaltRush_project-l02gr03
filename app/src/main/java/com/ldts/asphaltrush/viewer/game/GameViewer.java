package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.elements.Element;
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
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
