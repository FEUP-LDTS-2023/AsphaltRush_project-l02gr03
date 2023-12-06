package com.ldts.asphaltrush.controller.ranking;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ranking.Ranking;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class RankingController extends Controller<Ranking> {
    public RankingController(Ranking model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {

    }
}
