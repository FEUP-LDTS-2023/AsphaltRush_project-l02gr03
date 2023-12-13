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

        Image titleImage = imageFactory.getImage("/title/ranking");
        gui.drawImage(new Position(130-titleImage.getWidth()/2, 13), titleImage);




        ArrayList<String[]> rankingArray = getModel().getRanking();
        if(!rankingArray.isEmpty()) {

            gui.drawImage(new Position(75, 60), imageFactory.getImage("/text/name"));
            gui.drawImage(new Position(135, 60), imageFactory.getImage("/text/points"));

            for (int i = 0; i < rankingArray.size(); i++){
                gui.drawText(rankingArray.get(i)[0], new Position(125, 80+i*15), imageFactory, 'r');
                gui.drawText(rankingArray.get(i)[1], new Position(135, 80+ i *15), imageFactory, 'l');
            }

        }
        else {
            titleImage = imageFactory.getImage("/text/noresult");
            gui.drawImage(new Position(130-titleImage.getWidth()/2, 120), titleImage);
        }

            String selected = getModel().isSelected(0) ? "selected/" : "";
            Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
            gui.drawImage(new Position(130- entryImage.getWidth()/2, 220), entryImage);
    }
}
