package com.ldts.asphaltrush.model.game.elements.obstacleCar;

import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Element;

public class ObstacleCar extends Element {
    private int type;

    public ObstacleCar(int x, int y, int type, int width, int height) {
        super(x, y, width, height);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
