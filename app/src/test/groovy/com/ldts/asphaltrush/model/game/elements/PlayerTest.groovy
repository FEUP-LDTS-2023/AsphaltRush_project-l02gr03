package com.ldts.asphaltrush.model.game.elements

import spock.lang.Specification
import spock.lang.Subject

class PlayerTest extends Specification {

    @Subject
    Player player

    def setup() {
        player = new Player(0, 0, 0, 0, 1)
    }

    def "Player should increase speed"() {
        when:
        player.increaseSpeed()

        then:
        player.speed == 1.2

        cleanup:
        player = null
    }

    def "Speed should not pass below 1"() {
        when:
        player.decreaseSpeed()

        then:
        player.speed == 1

        cleanup:
        player = null
    }

    def "Player should increase minimum speed"() {
        when:
        player.increaseMinSpeed()

        then:
        player.minSpeed == 1.005

        cleanup:
        player = null
    }

    def "Player should set crashed state"() {
        when:
        player.setCrashed()

        then:
        player.crashed

        cleanup:
        player = null
    }

    def "Player should return type"() {
        given:
        player = new Player(0, 0, 0, 0, 42)

        expect:
        player.getType() == 42

        cleanup:
        player = null
    }
}
