package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.Line;
import com.ldts.asphaltrush.model.game.street.Street;

public class LineController extends GameController {

    private long lastMovement;
    private static final double LINE_SPEED = DEFAULT_SPEED;

    public LineController(Street street) {
        super(street);
        this.lastMovement = System.currentTimeMillis();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        // Move the lines every x amount of time
        if (time - lastMovement > 100) {
            // Update the position of every line
            for (Line line : getModel().getLines()) {
                moveLine(line, line.getPosition());
            }
            this.lastMovement = time;
        }
    }

    private void moveLine(Line line, Position position) {
        // Check if line exited the screen already
        if (line.getPosition().getY() >= getModel().getHeight()){
            // If so remove it from the list of lines
            getModel().getLines().remove(getModel().getLines().size()-1);
            // Add it before the first line of the list
            getModel().getLines().addFirst(new Line(position.getX(), getModel().getLines().get(0).getPosition().getY()-33));
        }
        else
            // Move the line downward
            line.setPosition(new Position(position.getX(), position.getY() + (int) (LINE_SPEED*getModel().getPlayer().getSpeed())));
    }
}
