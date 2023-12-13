package com.ldts.asphaltrush.model.game.elements

import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.model.game.elements.Player
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp

class PlayerSpec extends Specification {

    @Subject
    Player player

    def setup() {
        player = new Player(1, 1)
    }

    def "increaseSpeed should increase player speed within the maximum limit"() {
        when:
        player.increaseSpeed()

        then:
        // Verify that increaseSpeed increases the player speed
        player.getSpeed() == 1.2

        when:
        // Increase speed until it reaches the maximum limit
        player.increaseSpeed()
        player.increaseSpeed()
        player.increaseSpeed()
        player.increaseSpeed()

        then:
        // Verify that speed doesn't exceed the maximum limit
        player.getSpeed() == 3.4
    }

    def "decreaseSpeed should decrease player speed within the minimum limit"() {
        when:
        player.decreaseSpeed()

        then:
        // Verify that decreaseSpeed decreases the player speed
        player.getSpeed() == 0.6

        when:
        // Decrease speed until it reaches the minimum limit
        player.decreaseSpeed()
        player.decreaseSpeed()
        player.decreaseSpeed()
        player.decreaseSpeed()

        then:
        // Verify that speed doesn't go below the minimum limit
        player.getSpeed() == 1.0
    }

    def "increaseMinSpeed should increase the minimum speed"() {
        when:
        player.increaseMinSpeed()

        then:
        // Verify that increaseMinSpeed increases the minimum speed
        player.getSpeed() == 1.0

        when:
        // Increase minimum speed
        player.increaseMinSpeed()
        player.increaseMinSpeed()

        then:
        // Verify that the minimum speed is correctly updated
        player.getSpeed() == 1.002
        player.getMinSpeed() == 1.002
    }

    def "setCrashed should mark the player as crashed"() {
        when:
        player.setCrashed()

        then:
        // Verify that setCrashed marks the player as crashed
        player.getCrashed() == true
    }

    def "addPowerUp and removePowerUp should correctly manage power-ups"() {
        given:
        def powerUp = new PowerUp(1, 1)

        when:
        player.addPowerUp(powerUp)

        then:
        // Verify that addPowerUp sets the power-up and initializes power-up time
        player.getPowerUp() == powerUp
        player.getPowerUpTime() == 15.0

        when:
        player.removePowerUp()

        then:
        // Verify that removePowerUp resets the power-up and power-up time
        player.getPowerUp() == null
        player.getPowerUpTime() == 0
    }

    def "decreasePowerUpTime should decrease the power-up time"() {
        when:
        player.addPowerUp(new PowerUp(1, 1))
        player.decreasePowerUpTime()

        then:
        // Verify that decreasePowerUpTime decreases the power-up time
        player.getPowerUpTime() == 14.9
    }
}
