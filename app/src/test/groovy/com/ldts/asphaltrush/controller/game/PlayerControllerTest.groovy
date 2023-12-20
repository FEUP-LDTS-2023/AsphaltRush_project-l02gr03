package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.Position

class PlayerControllerTest extends Specification {

    @Subject
    PlayerController playerController

    def setup() {
        StreetBuilder streetBuilder = new StreetBuilder(1, new ImageFactory())
        Street street = streetBuilder.createStreet()
        playerController = new PlayerController(street)
    }

    def "movePlayerLeft should move the player to the left"() {
        given:
        int x = playerController.getModel().getPlayer().getPosition().getX()
        int y = playerController.getModel().getPlayer().getPosition().getY()


        when:
        playerController.movePlayerLeft()

        then:
        playerController.getModel().getPlayer().getPosition() == new Position(x - 28, y)
    }

    def "movePlayerRight should move the player to the right"() {
        given:
        int x = playerController.getModel().getPlayer().getPosition().getX()
        int y = playerController.getModel().getPlayer().getPosition().getY()

        when:
        playerController.movePlayerRight()

        then:
        playerController.getModel().getPlayer().getPosition() == new Position(x + 28, y)
    }

    def "increasePlayerSpeed should increase the player speed"() {
        when:
        double speed = playerController.getModel().getPlayer().getSpeed()
        playerController.increasePlayerSpeed()

        then:
        playerController.getModel().getPlayer().getSpeed() == speed+0.2
    }

    def "decreasePlayerSpeed should decrease the player speed"() {
        when:
        double speed = playerController.getModel().getPlayer().getSpeed()
        playerController.increasePlayerSpeed()
        playerController.decreasePlayerSpeed()

        then:
        playerController.getModel().getPlayer().getSpeed() == speed
    }

    def "step should handle power-up and increase player speed accordingly"() {
        given:
        PowerUp powerUp = new InvenciblePowerUp(1,1)
        playerController.getModel().getPlayer().addPowerUp(powerUp)

        when:
        playerController.step(new Game(), GUI.ACTION.NONE, 150)

        then:
        playerController.getModel().getPlayer().getPowerUp() == powerUp
        playerController.getModel().getPlayer().getPowerUpTime() == 4.9
        playerController.getModel().getPlayer().getSpeed() == 1.005
    }
}


