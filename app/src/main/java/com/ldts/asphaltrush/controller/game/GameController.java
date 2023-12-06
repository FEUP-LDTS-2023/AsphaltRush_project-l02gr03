package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.model.game.street.Street;

public abstract class GameController extends Controller<Street> {
    public GameController(Street street) {
        super(street);
    }
}
