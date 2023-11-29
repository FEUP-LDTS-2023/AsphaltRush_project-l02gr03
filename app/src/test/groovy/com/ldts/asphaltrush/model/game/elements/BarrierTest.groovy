package com.ldts.asphaltrush.model.game.elements

import spock.lang.Specification;

class BarrierTest extends Specification {
    def "Barrier Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
