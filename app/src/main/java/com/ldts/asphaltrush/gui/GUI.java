package com.ldts.asphaltrush.gui;

import com.ldts.asphaltrush.model.Image;
import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawImage(Position position, Image image);
    void drawImage(Position position, Image image, char htype, char vtype);
    void drawText(String text, Position position, ImageFactory imageFactory, char type, boolean smallNumbers);
    void drawText(String text, Position position, ImageFactory imageFactory, char type);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

    void drawRectangle(Position position, int width, int height, String color);
}
