package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.Hole
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import spock.lang.Specification
import spock.lang.Subject

class HoleControllerTest extends Specification {

    @Subject
    HoleController holeController

    def setup() {
        ImageFactory imageFactory = new ImageFactory()
        StreetBuilder streetBuilder = new StreetBuilder(1, imageFactory)
        Street street = streetBuilder.createStreet()
        holeController = new HoleController(street)
    }

    def "checkAndRemoveHoles should remove holes that have moved off the screen"() {
        given:
        Hole holeToRemove = new Hole(2, holeController.getModel().getHeight() + 500)
        holeController.getModel().getHoles().add(holeToRemove)

        when:
        holeController.checkAndRemoveHoles()

        then:
        !holeController.getModel().getHoles().contains(holeToRemove)
    }

    def "HoleController should add new holes"() {
        when:
        holeController.addNewHoles()

        then:
        if (holeController.getModel().getHoles() == null) holeController.getModel().getHoles().size() == 0
        else holeController.getModel().getHoles().size() > 0
    }

    def "HoleController should move holes downward"() {
        given:
        Hole hole = new Hole(1, 1)
        holeController.getModel().getHoles().add(hole)

        when:
        holeController.step(new Game(), GUI.ACTION.NONE, holeController.lastMovement + 150)

        then:
        holeController.getModel().getHoles() != null
        holeController.getModel().getHoles().get(0) == hole
        holeController.getModel().getHoles().get(0).getPosition().x == 1
        holeController.getModel().getHoles().get(0).getPosition().y == 1 + (int) (holeController.HOLE_SPEED * holeController.getModel().getPlayer().getSpeed())
    }
}
