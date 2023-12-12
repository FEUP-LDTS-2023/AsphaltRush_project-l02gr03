package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.model.gameOver.GameOver;
import com.ldts.asphaltrush.observer.GameStateObserver;
import com.ldts.asphaltrush.model.menu.Menu;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameState {

    private State state;
    private List<GameStateObserver> observers;
    public GameState(){
        this.observers = new ArrayList<>();
        setState(new GameOverState(new GameOver(100)));
    }

    public void setState(State state) {
        this.state = state;
        try {
            notifyObservers();
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
    public State getState() {
        return state;
    }

    public void addObserver(GameStateObserver observer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        observers.add(observer);
        notifyObservers();
    }

    private void notifyObservers() throws IOException, LineUnavailableException, UnsupportedAudioFileException{
        for (GameStateObserver observer : observers) {
            observer.update();
        }
    }

}

