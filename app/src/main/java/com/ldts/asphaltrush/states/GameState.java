package com.ldts.asphaltrush.states;


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
    private int carType=0;
    public GameState(){
        this.observers = new ArrayList<>();
        setState(new MenuState(new Menu()));
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

    public int getCarType(){
        return carType;
    }

    public void setCarType(int carType){
        this.carType = carType;
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

