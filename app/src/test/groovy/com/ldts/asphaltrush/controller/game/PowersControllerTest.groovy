package com.ldts.asphaltrush.controller.game

import spock.lang.Specification;

class PowersControllerTest extends Specification {
    def "PowersController Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
