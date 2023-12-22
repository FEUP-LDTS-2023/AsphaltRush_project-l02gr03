package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.Line;
public class LineViewer implements ElementViewer<Line> {
    @Override
    public void draw(Line element, GUI gui, ImageFactory imageFactory) {
        // Draw the 4 lines using only one as reference
        for (int i = 0; i<4; i++){
            gui.drawImage(new Position(element.getPosition().getX() + i*28, element.getPosition().getY()), imageFactory.getImage("/elements/line"));
        }
    }
}
