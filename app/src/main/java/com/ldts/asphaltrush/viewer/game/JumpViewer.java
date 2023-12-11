package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Jump;

public class JumpViewer implements ElementViewer<Jump> {
    @Override
    public void draw(Jump element, GUI gui, ImageFactory imageFactory) {
        gui.drawJump(element.getPosition());
    }
}
