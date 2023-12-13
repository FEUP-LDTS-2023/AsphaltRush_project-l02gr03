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
    private final SoundEffect selectOptionSound;
    public GameOverController(GameOver model) {
        super(model);
        this.selectOptionSound = new SelectOptionSound();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
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
                if (getModel().isSelectedBackToMenu()) game.getGameState().setState(new MenuState(new Menu()));
                else if (getModel().isSelectedConfirm()) {
                    if (!getModel().isNameEmpty()){
                        getModel().saveRanking();
                        game.getGameState().setState(new MenuState(new Menu()));
                    }

                }
                else if (getModel().isSelectedDelete()) {
                    String currentName = getModel().getName();
                    if (!currentName.isEmpty()) getModel().setName(currentName.substring(0, currentName.length() - 1));
                }
                else if (getModel().getName().length() < 5)getModel().setName(getModel().getName()+getModel().getCurrentEntry());
        }
    }
}
