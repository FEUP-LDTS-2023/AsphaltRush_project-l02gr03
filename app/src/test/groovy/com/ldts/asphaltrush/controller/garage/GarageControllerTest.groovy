package com.ldts.asphaltrush.controller.garage

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.garage.Garage
import spock.lang.Specification
import spock.lang.Subject;

class GarageControllerTest extends Specification {

    @Subject
    GarageController garageController
    Garage garage

    def setup() {
        garage = new Garage(0)
        garageController = new GarageController(garage)
    }

    def "GarageController should respond correctly to user actions"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        garageController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis())
        int movedLeftCar = garage.getCurrentCar()

        and:
        garageController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis())
        int movedRightCar = garage.getCurrentCar()

        then:
        movedLeftCar == 5
        movedRightCar == 0

        cleanup:
        game.backgroundMusic.backgroundMusicMainMenu.close()
        game.backgroundMusic.backgroundMusicGameOverMenu.close()
        game.backgroundMusic.currentBackgroundMusic.close()
        game.gui.close()
    }
}
