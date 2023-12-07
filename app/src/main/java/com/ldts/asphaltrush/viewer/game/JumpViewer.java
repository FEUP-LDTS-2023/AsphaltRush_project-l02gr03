package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.elements.Jump;

public class JumpViewer implements ElementViewer<Jump> {
    @Override
    public void draw(Jump element, GUI gui) {
        gui.drawJump(element.getPosition());
    }
}
