package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.elements.Hole;
import com.ldts.asphaltrush.model.game.street.Street;
import com.ldts.asphaltrush.model.gameOver.GameOver;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.states.GameOverState;
import com.ldts.asphaltrush.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StreetController extends GameController {

    private final PlayerController playerController;
    private final ObstacleCarController obstacleCarController;
    private final LineController lineController;
    private final PowerUpController powerUpController;
    private final HoleController holeController;
    private final JumpController jumpController;

    public StreetController(Street street) {
        super(street);

        this.playerController = new PlayerController(street);
        this.lineController = new LineController(street);
        this.obstacleCarController = new ObstacleCarController(street);
        this.powerUpController = new PowerUpController(street);
        this.holeController = new HoleController(street);
        this.jumpController = new JumpController(street);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
        else if (getModel().getPlayer().getCrashed()) game.setState(new GameOverState(new GameOver()));
        else {
            playerController.step(game, action, time);
            lineController.step(game, action, time);
            obstacleCarController.step(game, action, time);
            powerUpController.step(game, action, time);
            holeController.step(game, action, time);
            jumpController.step(game, action, time);
            checkCollisions();
        }
    }

    public void checkCollisions() {
        if (getModel().isObstacleCar(getModel().getPlayer().getPosition()) ||
        getModel().isHole(getModel().getPlayer().getPosition()))
            getModel().getPlayer().setCrashed();
    }
}
