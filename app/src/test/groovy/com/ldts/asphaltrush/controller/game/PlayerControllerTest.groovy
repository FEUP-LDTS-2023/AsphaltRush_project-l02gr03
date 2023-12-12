package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import com.ldts.asphaltrush.model.game.street.Street
import spock.lang.Specification
import spock.lang.Subject;
import com.ldts.asphaltrush.gui.GUI

class PlayerControllerTest extends Specification {
    /*def "PlayerController Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }

     */


    @Subject
    PlayerController playerController

    def setup() {
        playerController = new PlayerController(new Street())
    }

    def "movePlayerLeft"() {
        given:
        def initialPosition = new Position(20, 20)
        playerController.getModel().getPlayer().setPosition(initialPosition)

        when:
        playerController.movePlayerLeft()

        then:
        playerController.getModel().getPlayer().getPosition() == new Position(19, 20)
    }

    def "movePlayerRight"() {
        given:
        def initialPosition = new Position(2, 2)
        playerController.getModel().getPlayer().setPosition(initialPosition)

        when:
        playerController.movePlayerRight()

        then:
        playerController.getModel().getPlayer().getPosition() == new Position(3, 2)
    }

    def "increasePlayerSpeed"() {
        when:
        playerController.increasePlayerSpeed()

        then:
        playerController.getModel().getPlayer().getSpeed() == 1.2
    }

    def "decreasePlayerSpeed"() {
        when:
        playerController.decreasePlayerSpeed()

        then:
        playerController.getModel().getPlayer().getSpeed() == 0.6
    }

    def "step should handle power-up and increase player speed accordingly"() {
        given:
        playerController.getModel().getPlayer().setPowerUpTime(1)
        playerController.getModel().getPlayer().setPowerUp(new PowerUp()) // Mock PowerUp class

        when:
        playerController.step(new Game(), GUI.ACTION.NONE, 150)

        then:
        playerController.getModel().getPlayer().getPowerUp() == null
        playerController.getModel().getPlayer().getSpeed() == 4
    }
}
