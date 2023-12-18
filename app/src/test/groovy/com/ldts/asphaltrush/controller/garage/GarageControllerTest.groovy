package com.ldts.asphaltrush.controller.garage

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.garage.Garage
import com.ldts.asphaltrush.states.GarageState
import spock.lang.Specification;

class GarageControllerTest extends Specification {
    def "GarageController should respond correctly to user actions"() {
        given:
        Game game = new Game()
        Garage garage = new Garage(0)
        GarageState garageState = new GarageState(garage)
        GarageController garageController = garageState.getController()

        when:
        garageController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis())
        int movedLeftCar = garage.getCurrentCar()

        and:
        garageController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis())
        int movedRightCar = garage.getCurrentCar()

        then:
        movedLeftCar == 5
        movedRightCar == 0
    }
}
