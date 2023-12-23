package com.ldts.asphaltrush.controller.gameOver;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.gameOver.GameOver;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.soundEffects.SelectOptionSound;
import com.ldts.asphaltrush.model.soundEffects.SoundEffect;
import com.ldts.asphaltrush.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends Controller<GameOver> {
    private SoundEffect selectOptionSound;
    public GameOverController(GameOver model) {
        super(model);
        this.selectOptionSound = new SelectOptionSound();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        // Consider all the possible inputs
        // Playing a sound every time one gets processed
        switch (action) {
            case UP:
                selectOptionSound.play();
                getModel().moveUp();
                break;
            case DOWN:
                selectOptionSound.play();
                getModel().moveDown();
                break;
            case LEFT:
                selectOptionSound.play();
                getModel().moveLeft();
                break;
            case RIGHT:
                selectOptionSound.play();
                getModel().moveRight();
                break;
            case SELECT:
                selectOptionSound.play();
                // If BackToMenu option is selected, change the game State to MenuState
                if (getModel().isSelectedBackToMenu()) game.getGameState().setState(new MenuState(new Menu()));
                else if (getModel().isSelectedConfirm()) {
                    // If Confirm option is selected check if name is not empty
                    if (!getModel().isNameEmpty()){
                        // Save the name and score into the ranking
                        getModel().saveRanking();
                        // Change the game state to MenuState
                        game.getGameState().setState(new MenuState(new Menu()));
                    }

                }
                else if (getModel().isSelectedDelete()) {
                    // If Delete option is selected, get already selected name
                    String currentName = getModel().getName();
                    // If not name empty, remove the last character
                    if (!currentName.isEmpty()) getModel().setName(currentName.substring(0, currentName.length() - 1));
                }
                // If one of the letters is selected check first if name is smaller than 5
                // Add the selected character to the end of the name if thats the case
                else if (getModel().getName().length() < 5)getModel().setName(getModel().getName()+getModel().getCurrentEntry());
        }
    }
}
