package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.controller.gameOver.GameOverController;
import com.ldts.asphaltrush.model.gameOver.GameOver;
import com.ldts.asphaltrush.viewer.Viewer;
import com.ldts.asphaltrush.viewer.gameOver.GameOverViewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
