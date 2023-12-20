package com.ldts.asphaltrush.model.game.elements.obstacleCar;

import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;

public class ObstacleCarBuilder {

    private ImageFactory imageFactory;
    public final static int TYPESNUMBER=4;

    public ObstacleCarBuilder(ImageFactory imageFactory){
        this.imageFactory = imageFactory;
    }


    public ObstacleCar createObstacleCar(int type){
        Image carImage = imageFactory.getImage("/cars/obstacle/car"+type);
        return new ObstacleCar(0,0, type, carImage.getWidth(), carImage.getHeight());
    }



}
