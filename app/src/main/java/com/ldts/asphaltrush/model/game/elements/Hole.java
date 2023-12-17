package com.ldts.asphaltrush.model.game.elements;

import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;

public class Hole extends Element{
    public Hole(int x, int y) {
        super(x, y, 0, 0);

        ImageFactory imageFactory = new ImageFactory();
        Image image = imageFactory.getImage("/elements/hole");

        setWidth(image.getWidth());
        setHeight(image.getHeight());
    }
}
