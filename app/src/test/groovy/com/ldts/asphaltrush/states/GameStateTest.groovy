package com.ldts.asphaltrush.states

import spock.lang.Specification;

class GameStateTest extends Specification {
    def "GameState Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
