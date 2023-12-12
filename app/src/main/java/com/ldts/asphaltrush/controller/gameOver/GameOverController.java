package com.ldts.asphaltrush.controller.gameOver;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.gameOver.GameOver;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.model.soundEffects.SelectSound;
import com.ldts.asphaltrush.model.soundEffects.SoundEffect;
import com.ldts.asphaltrush.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends Controller<GameOver> {
    private final SoundEffect selectSound;
    public GameOverController(GameOver model) {
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
                if (getModel().isSelectedBackToMenu()) game.getGameState().setState(new MenuState(new Menu()));
                else if (getModel().isSelectedConfirm()) {

                    // GUARDAR O RANKING -- APAGAR
                    System.out.println(getModel().getName() + " " + getModel().getPoints());

                    game.getGameState().setState(new MenuState(new Menu()));
                }
                else if (getModel().isSelectedDelete()) {
                    String currentName = getModel().getName();
                    if (!currentName.isEmpty()) getModel().setName(currentName.substring(0, currentName.length() - 1));
                }
                else getModel().setName(getModel().getName()+getModel().getCurrentEntry());
        }
    }
}
