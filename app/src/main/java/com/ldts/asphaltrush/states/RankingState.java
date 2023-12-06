package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.controller.ranking.RankingController;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.viewer.Viewer;
import com.ldts.asphaltrush.viewer.ranking.RankingViewer;

public class RankingState extends State<Ranking> {


    public RankingState(Ranking model) {
        super(model);
    }

    @Override
    protected Viewer<Ranking> getViewer() {
        return new RankingViewer(getModel());
    }

    @Override
    protected Controller<Ranking> getController() {
        return new RankingController(getModel());
    }
}
