package com.ldts.asphaltrush.viewer.menu;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.menu.Menu;
import com.ldts.asphaltrush.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui, ImageFactory imageFactory) {
        gui.drawText(new Position(15, 15), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(15, 17 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#0096FF" : "#FFFFFF");
        gui.drawText(new Position(15, 25), getModel().getCurrentCar(), "#FFFFFF");

    }
}
