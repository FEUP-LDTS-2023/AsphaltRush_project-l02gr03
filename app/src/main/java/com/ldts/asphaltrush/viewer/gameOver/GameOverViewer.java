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
        gui.drawImage(new Position(50, 15), imageFactory.getImage("/titles/gameOver/MainTitle"));

        String points = String.valueOf(getModel().getPoints());
        Image pointImage = imageFactory.getImage("/titles/gameOver/points");
        Position pointsPosition = new Position(130-(pointImage.getWidth()+points.length()*10)/2, 80);
        gui.drawImage(pointsPosition, pointImage);
        gui.drawText(String.valueOf(getModel().getPoints()), new Position(pointsPosition.getX() + pointImage.getWidth() + 5, pointsPosition.getY()), imageFactory, 'l');

        Image nameImage = imageFactory.getImage("/titles/gameOver/name");
        Position namePosition = new Position(pointsPosition.getX(), pointsPosition.getY()+12);
        gui.drawImage(namePosition, nameImage);
        gui.drawText(getModel().getName(), new Position(namePosition.getX()+nameImage.getWidth()+5, namePosition.getY()), imageFactory, 'l');


        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 7; col++) {
                int index = row * 7 + col + 3;
                if (index < getModel().getNumberEntries()) {
                    String entry = getModel().getEntry(index);
                    String color = getModel().isSelected(index) ? "#0096FF" : "#FFFFFF";
                    gui.drawText(new Position(5 + col * 2, 13 + row), entry, color);
                }
            }
        }
    }
}
