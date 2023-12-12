package com.ldts.asphaltrush.controller.garage;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.soundEffects.SelectSound;
import com.ldts.asphaltrush.model.soundEffects.SoundEffect;
import com.ldts.asphaltrush.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GarageController extends Controller<Garage> {
    private final SoundEffect selectSound;
    public GarageController(Garage model) {
        super(model);
        this.selectSound = new SelectSound();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                selectSound.play();
                getModel().moveUp();
                break;
            case DOWN:
                selectSound.play();
                getModel().moveDown();
                break;
            case LEFT:
                selectSound.play();
                getModel().moveLeft();
                break;
            case RIGHT:
                selectSound.play();
                getModel().moveRight();
                break;
            case SELECT:
                selectSound.play();
                int selectedCar = getModel().getCurrentEntry();
                game.getGameState().setState(new MenuState(new Menu(selectedCar)));
        }
    }
}
