package com.ldts.asphaltrush.viewer.ranking;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
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



        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/ranking"));

        Image titleImage = imageFactory.getImage("/titles/ranking/mainTitle");
        gui.drawImage(new Position(130-titleImage.getWidth()/2, 13), titleImage);


        gui.drawImage(new Position(75, 60), imageFactory.getImage("/titles/ranking/name"));
        gui.drawImage(new Position(135, 60), imageFactory.getImage("/titles/ranking/points"));


        ArrayList<String[]> rankingArray = getModel().getRankingAsText();
        if(rankingArray != null) {
            for (int i = 0; i < rankingArray.size(); i++){
                gui.drawText(rankingArray.get(i)[0], new Position(125, 80+i*15), imageFactory, 'r');
                gui.drawText(rankingArray.get(i)[1], new Position(135, 80+ i *15), imageFactory, 'l');
            }

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
