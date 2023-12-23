package com.ldts.asphaltrush.viewer.ranking;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.ranking.Ranking;
import com.ldts.asphaltrush.viewer.Viewer;

import java.util.ArrayList;

public class RankingViewer extends Viewer<Ranking> {
    public RankingViewer(Ranking model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) {

        // Draw background
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/ranking"));
        // Draw main Title
        gui.drawImage(new Position(130, 13), imageFactory.getImage("/title/ranking"), 'c', 't');

        // Get the top 5 ranking
        ArrayList<String[]> rankingArray = getModel().getRanking();
        // Consider if the leaderboard is empty or not
        if(!rankingArray.isEmpty()) {
            // Draw the name and points title
            gui.drawImage(new Position(75, 60), imageFactory.getImage("/text/name"));
            gui.drawImage(new Position(135, 60), imageFactory.getImage("/text/points"));

            // Draw the name and score of the top 5, aligned in the middle
            for (int i = 0; i < rankingArray.size(); i++){
                gui.drawText(rankingArray.get(i)[0], new Position(125, 85+i*15), imageFactory, 'r');
                gui.drawText(rankingArray.get(i)[1], new Position(135, 85+ i *15), imageFactory, 'l');
            }
        }
        else {
            // If empty leaderboard show No Result in the middle of the screen
            gui.drawImage(new Position(130, 120), imageFactory.getImage("text/noresult"), 'c', 't');
        }

        // Show all the different options
        String selected = getModel().isSelected(0) ? "selected/" : "";
        // Consider if the entry is selected or not
        Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
        gui.drawImage(new Position(130, 220), entryImage, 'c','t');
    }
}
