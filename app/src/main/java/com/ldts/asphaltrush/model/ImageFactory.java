package com.ldts.asphaltrush.model;

public class ImageFactory {

    private static ImageFactory instance;




    public static ImageFactory getInstance(){
        if (instance == null){
            instance = new ImageFactory();
        }
        return instance;
    }

}
