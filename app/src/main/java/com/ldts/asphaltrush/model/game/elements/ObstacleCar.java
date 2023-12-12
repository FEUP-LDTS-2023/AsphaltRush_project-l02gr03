package com.ldts.asphaltrush.model.game.elements;

public class ObstacleCar extends Element{

    public int getType() {
        return type;
    }

    private static final int NUMBEROFTYPES = 1;
    private final int type = 1;
    public ObstacleCar(int x, int y) {
        super(x, y);
    }
}
