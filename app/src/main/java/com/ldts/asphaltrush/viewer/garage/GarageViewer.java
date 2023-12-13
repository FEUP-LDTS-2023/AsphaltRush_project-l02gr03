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

        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/garage"));

        Image carImage = imageFactory.getImage("/cars/player/garage/car" + getModel().getCurrentCar());
        gui.drawImage(new Position(130-carImage.getWidth()/2,150-carImage.getHeight()/2), carImage);


        String selected = getModel().isSelected(0) ? "selected/" : "";
        Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
        gui.drawImage(new Position(130- entryImage.getWidth()/2, 220), entryImage);

        gui.drawImage(new Position(95, 145), imageFactory.getImage("/elements/leftarrow"));
        gui.drawImage(new Position(150, 145), imageFactory.getImage("/elements/rightarrow"));

    }
}

