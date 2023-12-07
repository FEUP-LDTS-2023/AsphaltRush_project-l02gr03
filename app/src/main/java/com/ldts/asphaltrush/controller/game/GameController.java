package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.model.game.street.Street;

public abstract class GameController extends Controller<Street> {
    protected static final double DEFAULT_SPEED = 3;
    public GameController(Street street) {
        super(street);
    }
}
