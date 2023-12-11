package com.ldts.asphaltrush;

import com.ldts.asphaltrush.gui.LanternaGUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.states.MenuState;
import com.ldts.asphaltrush.states.State;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private final ImageFactory imageFactory;

    public ImageFactory getImageFactory() {
        return imageFactory;
    }


    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(260, 240);
        imageFactory = new ImageFactory();
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, imageFactory, startTime);

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
