package com.ldts.asphaltrush.rules.controller.game

import spock.lang.Specification;

class GameControllerTest extends Specification {
    def "GameController Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
