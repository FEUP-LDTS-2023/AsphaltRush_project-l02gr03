package com.ldts.asphaltrush.controller.garage;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.garage.Garage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GarageController extends Controller<Garage> {
    public GarageController(Garage model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {

    }
}
