package com.ldts.asphaltrush.model.game.elements;

import com.ldts.asphaltrush.model.Position;

public class Element {
    private Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }
}
