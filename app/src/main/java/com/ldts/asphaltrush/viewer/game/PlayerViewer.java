package com.ldts.asphaltrush.viewer.game;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player element, GUI gui, ImageFactory imageFactory) {
        gui.drawImage(element.getPosition(), imageFactory.getImage("/cars/player/game/car" + element.getType()));
    }
}

