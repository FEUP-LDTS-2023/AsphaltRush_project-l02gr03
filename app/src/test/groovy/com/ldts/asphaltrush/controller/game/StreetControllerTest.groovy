package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.Hole
import com.ldts.asphaltrush.model.game.elements.Player
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import com.ldts.asphaltrush.states.GameOverState
import spock.lang.Specification
import spock.lang.Subject

class StreetControllerTest extends Specification {

    ImageFactory imageFactory = new ImageFactory()
    ObstacleCarBuilder obstacleCarBuilder = new ObstacleCarBuilder(imageFactory)

    @Subject
    StreetController streetController
    StreetBuilder streetBuilder
    Street street

    def setup() {
        streetBuilder = new StreetBuilder(1, imageFactory)
        street = streetBuilder.createStreet()
        streetController = new StreetController(street)
        streetController.crashSound.initializeSounds() >> {}
        streetController.powerUpSound.initializeSounds() >> {}
    }

    def "StreetController should transition to GameOverState when the player crashes"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}
        streetController.getModel().getPlayer().setCrashed()

        when:
        streetController.step(game, GUI.ACTION.NONE, 150)

        then:
        game.getGameState().getState() instanceof GameOverState

        cleanup:
        streetBuilder = null
        street = null
        streetController = null
        game.gui.close()
    }

    def "StreetController should check and handle collisions with obstacle cars"() {
        given:
        streetController.getModel().getPlayer().setPosition(new Position(10, 10))
        streetController.getModel().getObstacleCars().add(obstacleCarBuilder.createObstacleCar(1))
        streetController.getModel().getObstacleCars().get(0).setPosition(new Position(10, 10))

        when:
        streetController.checkCollisions()

        then:
        streetController.getModel().getPlayer().getCrashed()

        cleanup:
        streetBuilder = null
        street = null
        streetController = null
    }

    def "StreetController should check and handle collisions with power-ups"() {
        given:
        Player player = streetController.getModel().getPlayer()
        player.setPosition(new Position(10, 10))
        PowerUp powerUp = new InvenciblePowerUp(10,10)
        streetController.getModel().getPowerUps().add(powerUp)

        when:
        streetController.checkCollisions()

        then:
        player.getPowerUp() == powerUp
        streetController.getModel().getPowerUps().isEmpty()

        cleanup:
        streetBuilder = null
        street = null
        streetController = null
    }

    def "StreetController should check and handle collisions with holes"() {
        given:
        Player player = streetController.getModel().getPlayer()
        player.setPosition(new Position(10, 10))
        streetController.getModel().getHoles().add(new Hole(10, 10))

        when:
        streetController.checkCollisions()

        then:
        player.getCrashed()

        cleanup:
        streetBuilder = null
        street = null
        streetController = null
    }

    def "StreetController should check and handle collisions with obstacle cars when player is invencible"() {
        given:
        streetController.getModel().getPlayer().setPosition(new Position(10, 10))
        def obstacleCar = obstacleCarBuilder.createObstacleCar(1)
        streetController.getModel().getObstacleCars().add(obstacleCar)
        streetController.getModel().getObstacleCars().get(0).setPosition(new Position(10, 10))
        streetController.getModel().getPlayer().addPowerUp(new InvenciblePowerUp(1,1))

        when:
        streetController.checkCollisions()

        then:
        !streetController.getModel().getPlayer().getCrashed()

        cleanup:
        streetBuilder = null
        street = null
        streetController = null
    }

    def "StreetController should check and handle collisions with holes when player is invencible"() {
        given:
        Player player = streetController.getModel().getPlayer()
        player.setPosition(new Position(10, 10))
        streetController.getModel().getHoles().add(new Hole(10, 10))
        streetController.getModel().getPlayer().addPowerUp(new InvenciblePowerUp(1,1))

        when:
        streetController.checkCollisions()

        then:
        !player.getCrashed()

        cleanup:
        streetBuilder = null
        street = null
        streetController = null
    }
}
