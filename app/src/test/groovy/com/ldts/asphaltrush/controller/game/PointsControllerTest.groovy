package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import spock.lang.Specification
import spock.lang.Subject

class PointsControllerTest extends Specification {

    @Subject
    PointsController pointsController
    Street street

    def setup() {
        street = new StreetBuilder(1, new ImageFactory()).createStreet()
        pointsController = new PointsController(street)
    }

    def "PointsController should increase points with multiplier after a certain interval"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        pointsController.step(game, GUI.ACTION.NONE, 500)

        then:
        pointsController.getModel().getPoints().getPoints() > 0

        cleanup:
        street = null
        pointsController = null
        game.gui.close()
    }

    def "PointsController should consider power-up multiplier in points calculation"() {
        given:
        PointMultiplierPowerUp pointMultiplierPowerUp = new PointMultiplierPowerUp(1, 1)
        pointsController.getModel().getPlayer().addPowerUp(pointMultiplierPowerUp)
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        pointsController.step(game, GUI.ACTION.NONE, 500)

        then:
        pointsController.getModel().getPoints().getPoints() > 0
        pointsController.getModel().getPoints().getMultiplier() > 1

        cleanup:
        street = null
        pointsController = null
        game.backgroundMusic.backgroundMusicMainMenu.close()
        game.backgroundMusic.backgroundMusicGameOverMenu.close()
        game.backgroundMusic.currentBackgroundMusic.close()
        game.gui.close()
    }
}
