package com.ldts.asphaltrush.viewer.garage;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.garage.Garage;
import com.ldts.asphaltrush.viewer.Viewer;

public class GarageViewer extends Viewer<Garage> {
    public GarageViewer(Garage model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) {

        // Draw the background
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/garage"));

        // Draw main Title
        gui.drawImage(new Position(130, 15),imageFactory.getImage("/title/garage"), 'c', 't');

        // Draw current selected car
        Image carImage = imageFactory.getImage("/cars/player/car" + getModel().getCurrentCar());
        gui.drawImage(new Position(130,150), carImage, 'c', 'c');
        // Draw the two arrows on the side
        gui.drawImage(new Position(110, 150), imageFactory.getImage("/elements/leftarrow"), 'r', 'c');
        gui.drawImage(new Position(150, 150), imageFactory.getImage("/elements/rightarrow"), 'l', 'c');


        // Draw the different options
        String selected = getModel().isSelected(0) ? "selected/" : "";
        // Consider if the entry is select or not
        Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
        gui.drawImage(new Position(130, 220), entryImage, 'c', 't');


    }
}

