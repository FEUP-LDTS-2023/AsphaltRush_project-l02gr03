package com.ldts.asphaltrush.controller.garage;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.game.street.StreetBuilder;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.states.GameState;
import com.ldts.asphaltrush.states.GarageState;
import com.ldts.asphaltrush.states.MenuState;
import com.ldts.asphaltrush.states.RankingState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GarageController extends Controller<Garage> {
    public GarageController(Garage model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                getModel().moveUp();
                break;
            case DOWN:
                getModel().moveDown();
                break;
            case LEFT:
                getModel().moveLeft();
                break;
            case RIGHT:
                getModel().moveRight();
                break;
            case SELECT:
                String selectedCar = getModel().getCurrentEntry();
                game.setState(new MenuState(new Menu(selectedCar)));
        }
    }
}
