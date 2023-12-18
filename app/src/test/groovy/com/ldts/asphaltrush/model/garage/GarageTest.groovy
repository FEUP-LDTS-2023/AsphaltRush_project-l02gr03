package com.ldts.asphaltrush.model.garage

import spock.lang.Specification

class GarageTest extends Specification {

    def "moveLeft should change currentCar correctly"() {
        given:
        def garage = new Garage(0)

        when:
        garage.moveLeft()

        then:
        garage.getCurrentCar() == 5
    }

    def "moveRight should change currentCar correctly"() {
        given:
        def garage = new Garage(0)

        when:
        garage.moveRight()

        then:
        garage.getCurrentCar() == 1
    }

    def "isSelectedConfirm should be true initially"() {
        given:
        def garage = new Garage(0)

        expect:
        garage.isSelectedConfirm()
    }

}

