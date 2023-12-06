package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.controller.garage.GarageController;
import com.ldts.asphaltrush.controller.ranking.RankingController;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.viewer.Viewer;
import com.ldts.asphaltrush.viewer.garage.GarageViewer;
import com.ldts.asphaltrush.viewer.ranking.RankingViewer;

public class GarageState extends State<Garage> {
    public GarageState(Garage model) {
        super(model);
    }

    @Override
    protected Viewer<Garage> getViewer() {
        return new GarageViewer(getModel());
    }

    @Override
    protected Controller<Garage> getController() {
        return new GarageController(getModel());
    }
}
