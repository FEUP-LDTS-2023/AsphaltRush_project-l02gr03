package com.ldts.asphaltrush.model.game.elements

import com.ldts.asphaltrush.model.Image
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import spock.lang.Specification

class ObstacleCarTest extends Specification {

    ImageFactory imageFactory = new ImageFactory()
    ObstacleCarBuilder obstacleCarBuilder = new ObstacleCarBuilder(new ImageFactory())

    def "ObstacleCar should initialize with the correct type and dimensions"() {
        given:
        Image image = imageFactory.getImage("/cars/obstacle/car1")

        when:
        ObstacleCar obstacleCar = obstacleCarBuilder.createObstacleCar(1)

        then:
        obstacleCar.getType() == 1
        obstacleCar.getWidth() == image.getWidth()
        obstacleCar.getHeight() == image.getHeight()
    }

    def "ObstacleCar should return the correct type"() {
        when:
        ObstacleCar obstacleCar = obstacleCarBuilder.createObstacleCar(4)

        then:
        obstacleCar.getType() == 4
    }
}
