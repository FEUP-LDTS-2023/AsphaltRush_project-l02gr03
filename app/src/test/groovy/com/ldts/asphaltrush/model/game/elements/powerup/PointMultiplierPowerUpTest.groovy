package com.ldts.asphaltrush.model.game.elements.powerup

import spock.lang.Specification;


class PointMultiplierPowerUpTest extends Specification {

    def "PointMultiplierPowerUp should be created with correct Type"() {
        given:
        int x = 10
        int y = 20

        when:
        PointMultiplierPowerUp pointmultiplierPowerUp = new PointMultiplierPowerUp(x, y)

        then:
        pointmultiplierPowerUp != null
        pointmultiplierPowerUp.getType() == "star"
    }
}

