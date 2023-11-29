package com.ldts.asphaltrush.gui

import spock.lang.Specification;

class GUITest extends Specification {
    def "GUI Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
}
