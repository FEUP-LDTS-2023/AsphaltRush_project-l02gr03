package com.ldts.asphaltrush.model.game.elements

import spock.lang.Specification

class LineTest extends Specification {

    def "initialize with the correct position"() {
        when:
        Line line = new Line(10, 20)

        then:
        line.getPosition().getX() == 10
        line.getPosition().getY() == 20
    }
}

