package com.ldts.asphaltrush.model.game.street

import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.*
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import com.ldts.asphaltrush.model.game.Points
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import spock.lang.Specification

class StreetTest extends Specification {

    def "Street should initialize correctly"() {
        when:
        Street street = new Street()

        then:
        street.getWidth() == 126
        street.getHeight() == 240
        street.getPoints() != null
    }

    def "Street should check if a position is empty"() {
        given:
        Street street = new Street()
        street.setBarriers([new Barrier(10, 20)])

        expect:
        !street.isEmpty(new Position(10, 20))
        street.isEmpty(new Position(30, 40))
    }

    def "Street should detect obstacle cars"() {
        given:
        Street street = new Street()
        ObstacleCarBuilder obstacleCarBuilder = new ObstacleCarBuilder(new ImageFactory())
        ObstacleCar obstacleCar = obstacleCarBuilder.createObstacleCar(1)
        obstacleCar.setPosition(new Position(10,20))
        street.setObstacleCars([obstacleCar])

        expect:
        street.isObstacleCar(new Position(10, 20), 30, 40)
        !street.isObstacleCar(new Position(30, 40), 30, 40)
    }

    def "Street should detect holes"() {
        given:
        Street street = new Street()
        street.setHoles([new Hole(10, 20)])

        expect:
        street.isHole(new Position(10, 20), 1, 1)
        !street.isHole(new Position(30, 40), 1, 1)
    }

    def "Street should detect power ups"() {
        given:
        Street street = new Street()
        street.setPowerUps([new InvenciblePowerUp(10, 20)])

        expect:
        street.isPowerUp(new Position(10, 20), 1, 1)
        !street.isPowerUp(new Position(30, 40), 1, 1)
    }

    def "Street should get points"() {
        given:
        Street street = new Street()

        when:
        Points points = street.getPoints()

        then:
        points != null
    }
}
