package com.ldts.asphaltrush.model.garage

import spock.lang.Specification
import spock.lang.Subject

class GarageTest extends Specification {

    @Subject
    Garage garage

    def setup() {
        garage = new Garage(0)
    }

    def "moveLeft should change currentCar correctly"() {
        when:
        garage.moveLeft()

        then:
        garage.getCurrentCar() == 5

        cleanup:
        garage = null
    }

    def "moveRight should change currentCar correctly"() {
        when:
        garage.moveRight()

        then:
        garage.getCurrentCar() == 1

        cleanup:
        garage = null
    }

    def "isSelectedConfirm should be true initially"() {
        expect:
        garage.isSelectedConfirm()

        cleanup:
        garage = null
    }

}

