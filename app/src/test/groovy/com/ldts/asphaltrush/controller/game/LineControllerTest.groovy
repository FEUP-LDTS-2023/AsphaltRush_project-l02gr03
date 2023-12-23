package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import spock.lang.Specification
import spock.lang.Subject

class LineControllerTest extends Specification {

    @Subject
    ImageFactory imageFactory
    StreetBuilder streetBuilder
    Street street
    LineController lineController

    def setup() {
        imageFactory = new ImageFactory()
        streetBuilder = new StreetBuilder(1, imageFactory)
        street = streetBuilder.createStreet()
        lineController = new LineController(street)
    }

    def "LineController should move lines downward and add new lines when the line reaches the end of the street"() {
        when:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}
        lineController.step(new Game(), GUI.ACTION.NONE, 500)

        then:
        lineController.getModel().getLines().size() > 0
        lineController.getModel().getLines().size() == 8

        cleanup:
        imageFactory = null
        streetBuilder = null
        street = null
        lineController = null
        game.gui.close()
    }
}
