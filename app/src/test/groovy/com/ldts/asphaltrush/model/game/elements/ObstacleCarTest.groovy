package com.ldts.asphaltrush.model.game.elements

import com.ldts.asphaltrush.model.Image
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import spock.lang.Specification

class ObstacleCarTest extends Specification {

    def "ObstacleCar should initialize with the correct type and dimensions"() {
        given:
        ImageFactory imageFactory = new ImageFactory()
        Image image = imageFactory.getImage("/cars/obstacle/car1")

        when:
        ObstacleCar obstacleCar = new ObstacleCar(0, 0, 1)

        then:
        obstacleCar.getType() == 1
        obstacleCar.getWidth() == image.getWidth()
        obstacleCar.getHeight() == image.getHeight()
    }

    def "ObstacleCar should return the correct type"() {
        given:
        ObstacleCar obstacleCar = new ObstacleCar(0, 0, 5)

        expect:
        obstacleCar.getType() == 5
    }
}
