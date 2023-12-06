package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.game.elements.Barrier;
import com.ldts.asphaltrush.model.game.elements.Line;
import com.ldts.asphaltrush.model.game.elements.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.Player;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.ArrayList;
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

        street.setPlayer(createPlayer());
        street.setBarriers(createBarriers());
        return street;
    }

    private List<Barrier> createBarriers() {
        List<Barrier> barriers = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            barriers.add(new Barrier(0, y));
            barriers.add(new Barrier(width - 1, y));
        }

        return barriers;
    }

    private Player createPlayer() {
        return new Player(width / 2, height - 2);
    }
}
