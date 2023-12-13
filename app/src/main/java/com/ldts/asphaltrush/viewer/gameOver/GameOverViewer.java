package com.ldts.asphaltrush.viewer.gameOver;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.gameOver.GameOver;
import com.ldts.asphaltrush.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) {
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/gameOver"));
        gui.drawImage(new Position(50, 15), imageFactory.getImage("/title/gameOver"));

        String points = String.valueOf(getModel().getPoints());
        Image pointImage = imageFactory.getImage("/text/points:");
        Position pointsPosition = new Position(130-(pointImage.getWidth()+points.length()*10)/2, 80);
        gui.drawImage(pointsPosition, pointImage);
        gui.drawText(String.valueOf(getModel().getPoints()), new Position(pointsPosition.getX() + pointImage.getWidth() + 5, pointsPosition.getY()), imageFactory, 'l');

        Image nameImage = imageFactory.getImage("/text/name:");
        Position namePosition = new Position(pointsPosition.getX(), pointsPosition.getY()+12);
        gui.drawImage(namePosition, nameImage);
        gui.drawText(getModel().getName(), new Position(namePosition.getX()+nameImage.getWidth()+5, namePosition.getY()), imageFactory, 'l');


        for (int i=0; i<2; i++){
            String selected = getModel().isSelected(i) ? "selected/" : "";
            Image entryImage = imageFactory.getImage("/text/" +  selected + getModel().getEntry(i));
            gui.drawImage(new Position(130-entryImage.getWidth()/2, 210 + i * 15), entryImage);
        }

        for (int i=0; i<getModel().getNumberEntries()-2; i++){
            int row = i/7;
            int col = i - i/7*7;
            String selected = getModel().isSelected(i+2) ? "selected/" : "";
            Image letter = imageFactory.getImage("/fonts/letters/" + selected + getModel().getEntry(i+2));
            gui.drawImage(new Position(90 + col*12 , 130 + row*12), letter);
        }
    }
}
