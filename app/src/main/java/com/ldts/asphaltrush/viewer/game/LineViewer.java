package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Line;

public class LineViewer implements ElementViewer<Line> {
    @Override
    public void draw(Line element, GUI gui, ImageFactory imageFactory) {
        gui.drawLine(element.getPosition());
    }
}
