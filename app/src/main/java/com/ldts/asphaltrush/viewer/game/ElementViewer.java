package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui, ImageFactory imageFactory);
}
