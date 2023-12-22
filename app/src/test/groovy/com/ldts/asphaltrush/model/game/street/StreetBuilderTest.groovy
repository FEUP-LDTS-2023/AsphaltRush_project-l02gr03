package com.ldts.asphaltrush.model.game.street

import com.ldts.asphaltrush.model.ImageFactory
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
}
