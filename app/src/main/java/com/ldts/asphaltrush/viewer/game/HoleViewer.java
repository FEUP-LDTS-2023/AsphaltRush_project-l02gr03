package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Hole;

public class HoleViewer implements ElementViewer<Hole> {
    @Override
    public void draw(Hole element, GUI gui, ImageFactory imageFactory) {
        gui.drawHole(element.getPosition());
    }
}
