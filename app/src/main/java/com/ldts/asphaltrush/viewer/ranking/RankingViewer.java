package com.ldts.asphaltrush.viewer.ranking;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.viewer.Viewer;

import java.io.IOException;
import java.util.ArrayList;

public class RankingViewer extends Viewer<Ranking> {
    public RankingViewer(Ranking model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) throws IOException {
        gui.drawText(new Position(5, 5), "Ranking", "#FFFFFF");

        ArrayList<String> rankingArray = getModel().getRankingAsText();
        if(rankingArray != null) {
            for (int i = 0; i < rankingArray.size(); i++)
                gui.drawText(new Position(5, 7 + i), rankingArray.get(i), "#FFFFFF");
        }
        else {
            gui.drawText(new Position(5, 10), "No scores", "#FFFFFF");
            gui.drawText(new Position(5, 11), "Go play!", "#FFFFFF");
        }

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 20 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
