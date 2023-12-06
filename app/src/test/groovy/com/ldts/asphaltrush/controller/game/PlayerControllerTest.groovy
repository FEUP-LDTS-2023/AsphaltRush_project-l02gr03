package com.ldts.asphaltrush.controller.game

import spock.lang.Specification;

class PlayerControllerTest extends Specification {
    def "PlayerController Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
