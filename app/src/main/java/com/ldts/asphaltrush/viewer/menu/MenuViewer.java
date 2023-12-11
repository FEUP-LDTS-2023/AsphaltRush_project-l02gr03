package com.ldts.asphaltrush.viewer.menu;

import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Image;
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
        gui.drawImage(new Position(0, 0), imageFactory.getImage("/background/menu.txt"));
        gui.drawImage(new Position(40, 15), imageFactory.getImage("/titles/menu/MainTitle.txt"));

        for (int i = 0; i < getModel().getNumberEntries(); i++){

            String extra = getModel().isSelected(i) ? "2" : "";

            Image entryImage = imageFactory.getImage("/titles/menu/" + getModel().getEntry(i) +  extra +   ".txt");
            gui.drawImage(new Position(130 - entryImage.getWidth()/2, 100 + i * 20), entryImage);

        }

    }
}
