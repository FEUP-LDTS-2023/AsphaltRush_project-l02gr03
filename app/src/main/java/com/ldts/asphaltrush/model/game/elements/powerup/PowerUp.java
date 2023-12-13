package com.ldts.asphaltrush.model.game.elements.powerup;

import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.game.elements.Element;

public class PowerUp extends Element {
    private String type;

    public String getType(){
        return type;
    }
    public PowerUp(int x, int y, String type) {
        super(x, y, 0, 0);
        this.type = type;

        ImageFactory imageFactory = new ImageFactory();
        Image image = imageFactory.getImage("/elements/"+ type);

        setWidth(image.getWidth());
        setHeight(image.getHeight());
    }
}
