package com.ldts.asphaltrush.states

import spock.lang.Specification;

class MenuStateTest extends Specification {
    def "MenuState Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
