package com.ldts.asphaltrush.model.game.street;

import com.ldts.asphaltrush.model.game.Points;
import com.ldts.asphaltrush.model.game.elements.Barrier;
import com.ldts.asphaltrush.model.game.elements.ObstacleCar;
import com.ldts.asphaltrush.model.game.elements.Player;
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp;

import java.util.List;

public class Street {

    private final int width;
    private final int height;
    private Points points;
    private Player player;

    private List<ObstacleCar> obstacleCars;

    private List<PowerUp> powerUps;

    private List<Barrier> barriers;

    public Street(int width, int height) {
        this.width = width;
        this.height = height;
        this.points = new Points();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Barrier> getBarriers() {
        return barriers;
    }

    public void setBarriers(List<Barrier> barriers) {
        this.barriers = barriers;
    }
}
