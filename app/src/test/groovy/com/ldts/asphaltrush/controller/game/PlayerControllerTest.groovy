package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.Position

class PlayerControllerSpec extends Specification {

    @Subject
    PlayerController playerController

    def setup() {
        playerController = new PlayerController(new Street())
    }

    def "movePlayerLeft should move the player to the left"() {
        given:
        def initialPosition = new Position(2, 2)
        playerController.getModel().getPlayer().setPosition(initialPosition)

        when:
        playerController.movePlayerLeft()

        then:
        playerController.getModel().getPlayer().getPosition() == new Position(1, 2)
    }

    def "movePlayerRight should move the player to the right"() {
        given:
        def initialPosition = new Position(2, 2)
        playerController.getModel().getPlayer().setPosition(initialPosition)

        when:
        playerController.movePlayerRight()

        then:
        playerController.getModel().getPlayer().getPosition() == new Position(3, 2)
    }

    def "increasePlayerSpeed should increase the player speed"() {
        when:
        playerController.increasePlayerSpeed()

        then:
        playerController.getModel().getPlayer().getSpeed() == 2
    }

    def "decreasePlayerSpeed should decrease the player speed"() {
        when:
        playerController.decreasePlayerSpeed()

        then:
        playerController.getModel().getPlayer().getSpeed() == 0
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


