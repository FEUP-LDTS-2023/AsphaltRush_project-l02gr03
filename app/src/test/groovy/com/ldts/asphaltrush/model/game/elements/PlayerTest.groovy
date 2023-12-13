package com.ldts.asphaltrush.model.game.elements

import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import spock.lang.Specification

class PlayerTest extends Specification {

    def "Player should increase speed"() {
        given:
        Player player = new Player(0, 0, 0, 0, 1)

        when:
        player.increaseSpeed()

        then:
        player.speed == 1.2
    }

    def "Speed should not pass below 1"() {
        given:
        Player player = new Player(0, 0, 0, 0, 1)

        when:
        player.decreaseSpeed()

        then:
        player.speed == 1
    }

    def "Player should increase minimum speed"() {
        given:
        Player player = new Player(0, 0, 0, 0, 1)

        when:
        player.increaseMinSpeed()

        then:
        player.minSpeed == 1.005
    }

    def "Player should set crashed state"() {
        given:
        Player player = new Player(0, 0, 0, 0, 1)

        when:
        player.setCrashed()

        then:
        player.crashed
    }

    def "Player should return type"() {
        given:
        Player player = new Player(0, 0, 0, 0, 42)

        expect:
        player.getType() == 42
    }
}
