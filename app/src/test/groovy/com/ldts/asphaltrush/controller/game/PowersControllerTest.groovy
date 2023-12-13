package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp
import com.ldts.asphaltrush.model.game.street.Street
import spock.lang.Specification
import spock.lang.Subject;

class PowersControllerTest extends Specification {
    /*def "PowersController Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
     */

    @Subject
    PowerUpController powerUpController

    def setup() {
        powerUpController = new PowerUpController(new Street())
    }

    def "movePowerUp should move the power-up down"() {
        given:
        def powerUp = new PointMultiplierPowerUp(2, 2)
        powerUpController.getModel().getPowerUps().add(powerUp)

        when:
        powerUpController.step(new Game(), GUI.ACTION.NONE, 150)

        then:
        powerUp.getPosition() == new Position(2, 3)
    }

    def "addNewPowerUps should add new power-ups to the model"() {
        when:
        powerUpController.addNewPowerUps()

        then:
        // Add assertions based on your expected behavior
        // For example, you can check that the number of power-ups in the model has increased
        powerUpController.getModel().getPowerUps().size() > 0
    }

    def "checkAndRemovePowerUps should remove power-ups that have moved off the screen"() {
        given:
        def powerUpToRemove = new InvenciblePowerUp(2, 25)
        powerUpController.getModel().getPowerUps().add(powerUpToRemove)

        when:
        powerUpController.checkAndRemovePowerUps()

        then:
        // Add assertions based on your expected behavior
        // For example, you can check that powerUpToRemove is no longer in the model
        !powerUpController.getModel().getPowerUps().contains(powerUpToRemove)
    }
}
