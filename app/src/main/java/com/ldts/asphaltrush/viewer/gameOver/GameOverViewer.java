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

        // Draw background
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/gameOver"));
        // Draw main Title
        gui.drawImage(new Position(50, 15), imageFactory.getImage("/title/gameOver"));

        // Draw the final score aligned in the middle
        String points = String.valueOf(getModel().getPoints());
        Image pointImage = imageFactory.getImage("/text/points:");
        // Consider the size of the total score and width of points image
        Position pointsPosition = new Position(130-(pointImage.getWidth()+points.length()*10)/2, 80);
        // Draw the points image
        gui.drawImage(pointsPosition, pointImage);
        // Draw the actual score
        gui.drawText(String.valueOf(getModel().getPoints()), new Position(pointsPosition.getX() + pointImage.getWidth() + 5, pointsPosition.getY()), imageFactory, 'l');

        // Draw the selected name aligned with the total score
        Image nameImage = imageFactory.getImage("/text/name:");
        // Align the name image with the points image
        Position namePosition = new Position(pointsPosition.getX(), pointsPosition.getY()+12);
        // Draw the name image
        gui.drawImage(namePosition, nameImage);
        // Draw the actual name
        gui.drawText(getModel().getName(), new Position(namePosition.getX()+nameImage.getWidth()+5, namePosition.getY()), imageFactory, 'l');


        // Draw the different entries aligned in the middle
        for (int i=0; i<2; i++){
            // Select image considering if the entry is selected or not
            String selected = getModel().isSelected(i) ? "selected/" : "";
            Image entryImage = imageFactory.getImage("/text/" +  selected + getModel().getEntry(i));
            gui.drawImage(new Position(130, 210 + i * 15), entryImage, 'c', 't');
        }

        // Draw the different letters
        for (int i=0; i<getModel().getNumberEntries()-2; i++){
            // Align the letters and organize them into columns and rows
            int row = i/7;
            int col = i - i/7*7;
            // Consider if the entry is selected or not
            String selected = getModel().isSelected(i+2) ? "selected/" : "";
            Image letter = imageFactory.getImage("/fonts/letters/" + selected + getModel().getEntry(i+2));
            gui.drawImage(new Position(90 + col*12 , 130 + row*12), letter);
        }
    }
}
