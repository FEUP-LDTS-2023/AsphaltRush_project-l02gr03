package com.ldts.asphaltrush.model.game.elements.powerup;

import com.ldts.asphaltrush.model.game.elements.Element;

public class PowerUp extends Element {

    private String type;

    public String getType(){
        return type;
    }
    public PowerUp(int x, int y, String type) {
        super(x, y);
        this.type = type;
    }
}
