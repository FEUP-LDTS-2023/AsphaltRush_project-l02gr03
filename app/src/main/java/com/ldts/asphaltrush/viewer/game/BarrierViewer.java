package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.elements.Barrier;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

public class BarrierViewer implements ElementViewer<Barrier> {
    @Override
    public void draw(Barrier element, GUI gui) {
        gui.drawBarrier(element.getPosition());
    }
}
