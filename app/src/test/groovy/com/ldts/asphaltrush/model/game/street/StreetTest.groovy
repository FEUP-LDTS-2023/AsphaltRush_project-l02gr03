package com.ldts.asphaltrush.model.game.street

import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.*
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import com.ldts.asphaltrush.model.game.Points
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import spock.lang.Specification
import spock.lang.Subject

class StreetTest extends Specification {

    @Subject
    Street street

    def setup() {
        street = new Street(null)
    }

    def "Street should initialize correctly"() {
        given:
        Points points = street.getPoints()

        expect:
        street.getWidth() == 126
        street.getHeight() == 240
        points != null

        cleanup:
        street = null
    }

    def "Street should detect obstacle cars"() {
        given:
        ObstacleCarBuilder obstacleCarBuilder = new ObstacleCarBuilder(new ImageFactory())
        ObstacleCar obstacleCar = obstacleCarBuilder.createObstacleCar(1)
        obstacleCar.setPosition(new Position(10,20))
        street.setObstacleCars([obstacleCar])

        expect:
        street.isObstacleCar(new Position(10, 20), 30, 40)
        !street.isObstacleCar(new Position(30, 40), 30, 40)

        cleanup:
        street = null
    }

    def "Street should detect holes"() {
        given:
        street.setHoles([new Hole(10, 20)])

        expect:
        street.isHole(new Position(10, 20), 1, 1)
        !street.isHole(new Position(30, 40), 1, 1)

        cleanup:
        street = null
    }

    def "Street should detect power ups"() {
        given:
        street.setPowerUps([new InvenciblePowerUp(10, 20)])

        expect:
        street.isPowerUp(new Position(10, 20), 1, 1)
        !street.isPowerUp(new Position(30, 40), 1, 1)

        cleanup:
        street = null
    }
}
