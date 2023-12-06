package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.game.elements.Barrier;
import com.ldts.asphaltrush.model.game.elements.Line;
import com.ldts.asphaltrush.model.game.elements.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.Player;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.List;

public class StreetBuilder {

    private final int width;
    private final int height;

    public StreetBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Street createStreet() {
        Street street = new Street(width, height);

        return street;
    }
}
