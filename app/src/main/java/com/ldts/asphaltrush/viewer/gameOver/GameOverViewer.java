package com.ldts.asphaltrush.viewer.gameOver;

import com.ldts.asphaltrush.gui.GUI;
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

        gui.drawText(new Position(5, 6), "Points: " + getModel().getPoints(), "#FFFFFF");
        gui.drawText(new Position(5, 7), "Name: " + getModel().getName(), "#FFFFFF");
        gui.drawText(new Position(5, 9), getModel().getEntry(0), getModel().isSelected(0) ? "#0096FF" : "#FFFFFF");
        gui.drawText(new Position(5, 10), getModel().getEntry(1), getModel().isSelected(1) ? "#0096FF" : "#FFFFFF");
        gui.drawText(new Position(5, 11), getModel().getEntry(2), getModel().isSelected(2) ? "#0096FF" : "#FFFFFF");

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
