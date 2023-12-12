package com.ldts.asphaltrush.observer;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.states.GameOverState;
import com.ldts.asphaltrush.states.GameState;
import com.ldts.asphaltrush.states.MenuState;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusic implements GameStateObserver{
    private GameState gamestate;

    public BackgroundMusic(GameState game) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        this.gamestate = game;
    }
    @Override
    public void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

    }
}
