package com.ldts.asphaltrush.controller.game;

import com.ldts.asphaltrush.Game;
import com.ldts.asphaltrush.gui.GUI;
import com.ldts.asphaltrush.model.Position;
import com.ldts.asphaltrush.model.game.elements.Line;
import com.ldts.asphaltrush.model.game.street.Street;

public class LineController extends GameController {

    private long lastMovement;
    private static final int LINE_SPEED = DEFAULT_SPEED;

    public LineController(Street street) {
        super(street);
        this.lastMovement = System.currentTimeMillis();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovement > 100) {
            for (Line line : getModel().getLines()) {
                moveLine(line, line.getPosition());
            }
            this.lastMovement = time;
        }
    }

    private void moveLine(Line line, Position position) {
        if (line.getPosition().getY() >= getModel().getHeight()){
            getModel().getLines().remove(getModel().getLines().size()-1);
            getModel().getLines().addFirst(new Line(position.getX(), getModel().getLines().get(0).getPosition().getY()-33));
        }
        else
            line.setPosition(new Position(position.getX(), position.getY() + (int) (LINE_SPEED*getModel().getPlayer().getSpeed())));
    }
}
