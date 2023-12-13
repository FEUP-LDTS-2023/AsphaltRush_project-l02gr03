package com.ldts.asphaltrush.model.game.street

import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.Line
import com.ldts.asphaltrush.model.game.elements.Player
import spock.lang.Specification

class StreetBuilderTest extends Specification {

    def "StreetBuilder should create a street with a player and lines"() {
        given:
        ImageFactory imageFactory = new ImageFactory()
        StreetBuilder streetBuilder = new StreetBuilder(1, imageFactory)

        when:
        Street street = streetBuilder.createStreet()

        then:
        street != null
        street.getPlayer() != null
        street.getLines() != null && !street.getLines().isEmpty()
    }

/*
    def "StreetBuilder should create lines with correct attributes"() {
        given:
        ImageFactory imageFactory = new ImageFactory()
        StreetBuilder streetBuilder = new StreetBuilder(1, imageFactory)

        when:
        LinkedList<Line> lines = streetBuilder.createLines()

        then:
        lines != null && !lines.isEmpty()
        lines.size() == 8 // Adjust the expected size based on your implementation
        lines.first().getPosition().getX() == 87
        lines.first().getPosition().getY() == 0
        lines.last().getPosition().getX() == 87
        lines.last().getPosition().getY() == 198 // Adjust the expected Y coordinate based on your implementation
    }
 */
}
