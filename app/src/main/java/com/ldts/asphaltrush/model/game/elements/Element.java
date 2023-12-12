package com.ldts.asphaltrush.model.game.elements;

import com.ldts.asphaltrush.model.Position;

public class Element {
    private Position position;
    private int width;
    private int height;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Element(int x, int y, int width, int height) {
        this.position = new Position(x, y);
        this.width = width;
        this.height = height;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
}
