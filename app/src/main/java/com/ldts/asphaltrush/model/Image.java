package com.ldts.asphaltrush.model;

public class Image{

    private int width;
    private int height;
    private String[][] colorMatrix;

    // Getters
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
    public String[][] getColorMatrix(){
        return colorMatrix;
    }

    // Constructor
    public Image(int width, int height, String[][] colorMatrix){
        this.height = height;
        this.width = width;
        this.colorMatrix = colorMatrix;
    }


}
