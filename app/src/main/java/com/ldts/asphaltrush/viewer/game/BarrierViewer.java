package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Barrier;

public class BarrierViewer implements ElementViewer<Barrier> {
    @Override
    public void draw(Barrier element, GUI gui, ImageFactory imageFactory) {
        gui.drawBarrier(element.getPosition());
    }
}
