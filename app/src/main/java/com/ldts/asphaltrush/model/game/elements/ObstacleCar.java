package com.ldts.asphaltrush.model.game.elements;

import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;

public class ObstacleCar extends Element{
    private int type = 1;

    public ObstacleCar(int x, int y, int type) {
        super(x, y, 0, 0);
        this.type = type;

        ImageFactory imageFactory = new ImageFactory();
        Image image = imageFactory.getImage("/cars/obstacle/car" + type);

        setWidth(image.getWidth());
        setHeight(image.getHeight());
    }

    public int getType() {
        return type;
    }
}
