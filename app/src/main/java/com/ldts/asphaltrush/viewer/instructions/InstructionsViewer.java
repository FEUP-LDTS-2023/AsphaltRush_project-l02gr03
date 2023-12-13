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

        Image titleImage = imageFactory.getImage("/title/instructions");
        gui.drawImage(new Position(130-titleImage.getWidth()/2, 13), titleImage);

        String selected = getModel().isSelected(0) ? "selected/" : "";
        Image entryImage = imageFactory.getImage("/text/" + selected + getModel().getEntry(0));
        gui.drawImage(new Position(130- entryImage.getWidth()/2, 220), entryImage);
    }

}
