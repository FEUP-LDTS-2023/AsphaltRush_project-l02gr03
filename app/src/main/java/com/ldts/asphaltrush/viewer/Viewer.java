package com.ldts.asphaltrush.viewer;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui, ImageFactory imageFactory) throws IOException {
        gui.clear();
        drawElements(gui, imageFactory);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui, ImageFactory imageFactory) throws IOException;
}
