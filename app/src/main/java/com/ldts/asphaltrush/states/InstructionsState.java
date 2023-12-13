package com.ldts.asphaltrush.states;

import com.ldts.asphaltrush.controller.Controller;
import com.ldts.asphaltrush.controller.instructions.InstructionsController;
import com.ldts.asphaltrush.model.instructions.Instructions;
import com.ldts.asphaltrush.viewer.Viewer;
import com.ldts.asphaltrush.viewer.instructions.InstructionsViewer;

public class InstructionsState extends State<Instructions>{
    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}
