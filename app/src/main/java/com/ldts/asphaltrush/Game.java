package com.ldts.asphaltrush;

import com.ldts.asphaltrush.gui.LanternaGUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.observer.BackgroundMusic;
import com.ldts.asphaltrush.states.GameState;
import com.ldts.asphaltrush.states.MenuState;
import com.ldts.asphaltrush.states.State;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private final GameState gameState;
    private final ImageFactory imageFactory;
    private BackgroundMusic backgroundMusic;


    public Game() throws FontFormatException, IOException, URISyntaxException, LineUnavailableException, UnsupportedAudioFileException {
        this.gui = new LanternaGUI(260, 240);
        this.imageFactory = new ImageFactory();
        this.gameState = new GameState();
        this.backgroundMusic = new BackgroundMusic(gameState);
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, LineUnavailableException, UnsupportedAudioFileException {
        new Game().start();
    }

    public ImageFactory getImageFactory() {
        return imageFactory;
    }

    public GameState getGameState() {
        return gameState;
    }

    private void start() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.gameState.getState() != null) {
            long startTime = System.currentTimeMillis();

            this.gameState.getState().step(this, gui, imageFactory, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
