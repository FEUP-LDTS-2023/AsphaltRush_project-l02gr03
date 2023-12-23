package com.ldts.asphaltrush.controller.ranking;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.model.soundEffects.SelectOptionSound;
import com.ldts.asphaltrush.model.soundEffects.SoundEffect;
import com.ldts.asphaltrush.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class RankingController extends Controller<Ranking> {
    private final SoundEffect selectOptionSound;
    public RankingController(Ranking model) {
        super(model);
        this.selectOptionSound = new SelectOptionSound();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.SELECT){
            selectOptionSound.play();
            if (getModel().isSelectedBack()) game.getGameState().setState(new MenuState(new Menu()));
        }
    }

}
