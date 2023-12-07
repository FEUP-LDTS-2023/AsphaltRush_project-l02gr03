package com.ldts.asphaltrush.gui;

import com.ldts.asphaltrush.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawText(Position position, String text, String color);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

    void drawBarrier(Position position);

    void drawPlayer(Position position);

    void drawLine(Position position);

    void drawObstacleCar(Position position);

    void drawHole(Position position);

    void drawJump(Position position);
}
