package com.ldts.asphaltrush.model.game.elements.powerup

import spock.lang.Specification;

class InvencibleTest extends Specification {
    def "Invencible Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
