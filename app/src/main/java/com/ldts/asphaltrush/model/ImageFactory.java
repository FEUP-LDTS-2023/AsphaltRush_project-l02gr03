package com.ldts.asphaltrush.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class ImageFactory {

    private static ImageFactory instance;
    private HashMap<String, Image> images;
    public ImageFactory(){
        images =  new HashMap<>();
    }

    public Image getImage(String image){

    }

    private Image loadImageFromFile(String image){

    }

    private Image readImage(BufferedReader bufferReader){

    }


    public static ImageFactory getInstance(){
        if (instance == null){
            instance = new ImageFactory();
        }
        return instance;
    }

}
