package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.street.Street;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PointsController extends GameController {
    public PointsController(Street street) {
        super(street);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {

    }
}
