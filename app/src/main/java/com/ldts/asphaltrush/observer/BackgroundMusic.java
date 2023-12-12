package com.ldts.asphaltrush.observer;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.states.GameOverState;
import com.ldts.asphaltrush.states.GameState;
import com.ldts.asphaltrush.states.MenuState;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BackgroundMusic implements GameStateObserver{
    private GameState gamestate;
    private Clip backgroundMusicMainMenu;
    private Clip backgroundMusicGameOverMenu;
    private Clip currentBackgroundMusic;
    public BackgroundMusic(GameState game) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        this.gamestate = game;
        initializeSounds();
        gamestate.addObserver(this);
    }

    private void initializeSounds() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        URL resource1 = BackgroundMusic.class.getResource("/audio/mainmenu.wav");
        assert resource1 != null;
        URL resource2 = BackgroundMusic.class.getResource("/audio/gameover.wav");
        assert resource2 != null;

        backgroundMusicMainMenu = AudioSystem.getClip();
        backgroundMusicGameOverMenu = AudioSystem.getClip();
        currentBackgroundMusic = AudioSystem.getClip();

        AudioInputStream mainmenu = AudioSystem.getAudioInputStream(resource1);
        backgroundMusicMainMenu.open(mainmenu);

        AudioInputStream gameovermenu = AudioSystem.getAudioInputStream(resource2);
        backgroundMusicGameOverMenu.open(gameovermenu);
    }

    @Override
    public void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

    }
}
