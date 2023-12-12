package com.ldts.asphaltrush.controller.menu;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.street.StreetBuilder;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.model.soundEffects.SelectSound;
import com.ldts.asphaltrush.model.soundEffects.SoundEffect;
import com.ldts.asphaltrush.states.StreetState;
import com.ldts.asphaltrush.states.GarageState;
import com.ldts.asphaltrush.states.RankingState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController extends Controller<Menu> {
    private final SoundEffect selectSound;
    public MenuController(Menu model) {
        super(model);
        this.selectSound = new SelectSound();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                selectSound.play();
                getModel().previousEntry();
                break;
            case DOWN:
                selectSound.play();
                getModel().nextEntry();
                break;
            case SELECT:
                selectSound.play();
                if (getModel().isSelectedStart()) game.getGameState().setState(new StreetState(new StreetBuilder(getModel().getCurrentCar(), game.getImageFactory()).createStreet()));
                if (getModel().isSelectedGarage()) game.getGameState().setState(new GarageState(new Garage()));
                if (getModel().isSelectedRanking()) game.getGameState().setState(new RankingState(new Ranking()));
                if (getModel().isSelectedExit()) game.getGameState().setState(null);
                break;
        }
    }
}
