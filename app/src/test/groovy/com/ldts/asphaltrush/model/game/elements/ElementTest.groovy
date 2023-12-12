package com.ldts.asphaltrush.model.game.elements
import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.model.Position

class ElementTest extends Specification {

    @Subject
    Element element

    def setup() {
        element = new Element(1, 1)
    }

    def "should initialize with the correct position"() {
        expect:
        // Verify that the Element initializes with the correct position
        element.getPosition() == new Position(1, 1)
    }

    def "setPosition should update the position"() {
        when:
        element.setPosition(new Position(2, 3))

        then:
        // Verify that setPosition updates the position correctly
        element.getPosition() == new Position(2, 3)
    }
}
