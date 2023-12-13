package com.ldts.asphaltrush.controller.garage;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.soundEffects.SelectCarSound;
import com.ldts.asphaltrush.model.soundEffects.SelectOptionSound;
import com.ldts.asphaltrush.model.soundEffects.SoundEffect;
import com.ldts.asphaltrush.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GarageController extends Controller<Garage> {
    private final SoundEffect selectOptionSound;
    private final SoundEffect selectCarSound;
    public GarageController(Garage model) {
        super(model);
        this.selectOptionSound = new SelectOptionSound();
        this.selectCarSound = new SelectCarSound();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case LEFT:
                selectOptionSound.play();
                getModel().moveLeft();
                break;
            case RIGHT:
                selectOptionSound.play();
                getModel().moveRight();
                break;
            case SELECT:
                selectCarSound.play();
                if (getModel().isSelectedConfirm()){
                    game.getGameState().setState(new MenuState(new Menu(getModel().getCurrentCar())));
                }
        }
    }
}
