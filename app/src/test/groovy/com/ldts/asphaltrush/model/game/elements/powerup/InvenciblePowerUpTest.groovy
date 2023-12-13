package com.ldts.asphaltrush.model.game.elements.powerup

import spock.lang.Specification

class InvenciblePowerUpTest extends Specification {

    def "InvenciblePowerUp should be created with correct Type"() {
        given:
        int x = 10
        int y = 20

        when:
        InvenciblePowerUp invenciblePowerUp = new InvenciblePowerUp(x, y)

        then:
        invenciblePowerUp != null
        invenciblePowerUp.getType() == "shield"
    }
}

