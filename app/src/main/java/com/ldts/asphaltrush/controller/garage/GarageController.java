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
        // Consider all the possible inputs
        // Playing a sound every time one gets processed
        switch (action) {
            // Change the selected car
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
                selectOptionSound.closeWhenSoundEnds();
                selectCarSound.closeWhenSoundEnds();
                if (getModel().isSelectedConfirm()){
                    // Change the car type to the one of the current selected
                    game.getGameState().setCarType(getModel().getCurrentCar());
                    // Change the game state to Menu State
                    game.getGameState().setState(new MenuState(new Menu()));
                }
        }
    }
}
