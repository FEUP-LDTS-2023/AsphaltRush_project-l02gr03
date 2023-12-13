package com.ldts.asphaltrush.viewer.instructions;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.instructions.Instructions;
import com.ldts.asphaltrush.viewer.Viewer;

import java.io.IOException;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) throws IOException {

    }
}
