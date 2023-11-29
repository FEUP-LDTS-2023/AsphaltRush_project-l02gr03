package com.ldts.asphaltrush.rules.states

import spock.lang.Specification;

class GarageStateTest extends Specification {
    def "GarageState Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
