package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.game.elements.*;
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp;
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp;
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
        street.setLines(createLines());
        street.setObstacleCars(createObstacleCars());
        street.setHoles(createHoles());
        street.setJumps(createJumps());
        street.setPowerUps(createPowerUps());
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

    private List<Line> createLines() {
        List<Line> lines = new ArrayList<>();

        for (int y = 0; y < height; y+=3) {
            lines.add(new Line(4, y));
            lines.add(new Line(8, y));
            lines.add(new Line(12, y));
            lines.add(new Line(16, y));
        }

        return lines;
    }

    private List<ObstacleCar> createObstacleCars() {
        List<ObstacleCar> obstacleCars = new ArrayList<>();

        obstacleCars.add(new ObstacleCar(2, 5));
        obstacleCars.add(new ObstacleCar(6, 8));
        obstacleCars.add(new ObstacleCar(10, 20));
        obstacleCars.add(new ObstacleCar(14, 15));

        return obstacleCars;
    }

    private List<Hole> createHoles() {
        List<Hole> holes = new ArrayList<>();

        holes.add(new Hole(2, 30));
        holes.add(new Hole(6, 16));
        holes.add(new Hole(10, 20));
        holes.add(new Hole(14, 10));

        return holes;
    }

    private List<Jump> createJumps() {
        List<Jump> jumps = new ArrayList<>();

        jumps.add(new Jump(2, 10));
        jumps.add(new Jump(6, 20));
        jumps.add(new Jump(10, 16));
        jumps.add(new Jump(14, 30));

        return jumps;
    }

    private List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();

        powerUps.add(new InvenciblePowerUp(2, 14));
        powerUps.add(new PointMultiplierPowerUp(18, 20));

        return powerUps;
    }
}
