package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.model.menu.Menu;


public class GameState {

    private State state;
    public GameState(){
        this.state = new MenuState(new Menu());
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }
}

