package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import com.ldts.asphaltrush.gui.GUI
import spock.lang.Specification
import spock.lang.Subject;

class PowerUpControllerTest extends Specification {

    @Subject
    PowerUpController powerUpController

    def setup() {
        StreetBuilder streetBuilder = new StreetBuilder(1, new ImageFactory())
        Street street = streetBuilder.createStreet()
        powerUpController = new PowerUpController(street)
    }

    def "checkAndRemovePowerUps should remove power-ups that have moved off the screen"() {
        given:
        InvenciblePowerUp powerUpToRemove = new InvenciblePowerUp(2,powerUpController.getModel().getHeight());
        powerUpController.getModel().getPowerUps().add(powerUpToRemove);

        when:
        powerUpController.checkAndRemovePowerUps()

        then:
        !powerUpController.getModel().getPowerUps().contains(powerUpToRemove)
    }

    def "PowerUpController should add new power-ups"() {
        when:
        powerUpController.addNewPowerUps()

        then:
        if(powerUpController.getModel().getPowerUps() == null) powerUpController.getModel().getPowerUps().size() == 0
        else powerUpController.getModel().getPowerUps().size() > 0
    }

    def "PowerUpController should move power-ups downward"() {
        given:
        InvenciblePowerUp powerUp = new InvenciblePowerUp(1,1);
        powerUpController.getModel().getPowerUps().add(powerUp);

        when:
        powerUpController.step(new Game(), GUI.ACTION.NONE, 150)

        then:
        powerUpController.getModel().getPowerUps() != null
        powerUpController.getModel().getPowerUps().get(0) == powerUp
        powerUpController.getModel().getPowerUps().get(0).getPosition() == new Position(1, 2)
    }
}