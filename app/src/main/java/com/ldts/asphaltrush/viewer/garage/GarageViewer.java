package com.ldts.asphaltrush.viewer.garage;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.viewer.Viewer;

public class GarageViewer extends Viewer<Garage> {
    public GarageViewer(Garage model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(15, 5), "Garage", "#FFFFFF");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int index = row * 3 + col;
                if (index < getModel().getNumberEntries()) {
                    String entry = getModel().getEntry(index);
                    String color = getModel().isSelected(index) ? "#FFD700" : "#FFFFFF";
                    gui.drawText(new Position(5 + col * 2, 13 + row), entry, color);
                }
            }
        }
    }
}

