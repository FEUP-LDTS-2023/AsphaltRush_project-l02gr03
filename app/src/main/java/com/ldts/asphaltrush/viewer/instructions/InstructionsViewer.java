package com.ldts.asphaltrush.viewer.instructions;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.instructions.Instructions;
import com.ldts.asphaltrush.viewer.Viewer;

import java.io.IOException;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) throws IOException {
        gui.drawImage(new Position(0,0), imageFactory.getImage("/background/instructions"));

        gui.drawImage(new Position(130, 13), imageFactory.getImage("/title/instructions"), 'c', 't');

        Image textImage = imageFactory.getImage("/text/instructions");
        gui.drawImage(new Position(0,0), textImage);

        String selected = getModel().isSelected(0) ? "selected/" : "";
        Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
        gui.drawImage(new Position(130, 220), entryImage, 'c', 't');
    }

}
