package com.ldts.asphaltrush.controller.gameOver;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.gameOver.GameOver;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {

    }
}
