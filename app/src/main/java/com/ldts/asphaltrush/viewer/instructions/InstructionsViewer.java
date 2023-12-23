package com.ldts.asphaltrush.viewer.instructions;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.instructions.Instructions;
import com.ldts.asphaltrush.viewer.Viewer;


public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) {

        //Draw the background
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/instructions"));

        // Draw the main Title
        gui.drawImage(new Position(130, 13), imageFactory.getImage("/title/instructions"), 'c', 't');

        // Draw all the instructions
        gui.drawImage(new Position(0,0), imageFactory.getImage("/text/instructions"));

        // Draw the different options
        String selected = getModel().isSelected(0) ? "selected/" : "";
        // Consider if entry is selected or not
        Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
        gui.drawImage(new Position(130, 220), entryImage, 'c', 't');
    }

}
