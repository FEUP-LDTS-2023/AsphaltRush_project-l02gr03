package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.Line
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import spock.lang.Specification
import spock.lang.Subject

class LineControllerTest extends Specification {

    @Subject
    LineController lineController

    def setup() {
        ImageFactory imageFactory = new ImageFactory()
        StreetBuilder streetBuilder = new StreetBuilder(1, imageFactory)
        Street street = streetBuilder.createStreet()
        lineController = new LineController(street)
    }

    def "LineController should move lines downward and add new lines when the line reaches the end of the street"() {
        when:
        lineController.step(new Game(), GUI.ACTION.NONE, 500)

        then:
        lineController.getModel().getLines().size() > 0
        lineController.getModel().getLines().size() == 8
    }
}
