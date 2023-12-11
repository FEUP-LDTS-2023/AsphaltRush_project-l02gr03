package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.controller.game.StreetController;
import com.ldts.asphaltrush.model.game.street.Street;
import com.ldts.asphaltrush.viewer.Viewer;
import com.ldts.asphaltrush.viewer.game.GameViewer;

public class StreetState extends State<Street> {
    public StreetState(Street model) {
        super(model);
    }

    @Override
    protected Viewer<Street> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Street> getController() {
        return new StreetController(getModel());
    }
}
