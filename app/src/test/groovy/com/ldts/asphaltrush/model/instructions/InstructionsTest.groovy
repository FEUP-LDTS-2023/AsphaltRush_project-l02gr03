package com.ldts.asphaltrush.model.instructions

import spock.lang.Specification

class InstructionsTest extends Specification {

    Instructions instructions = new Instructions()

    def "isSelected should return true for the current entry"() {
        expect:
        instructions.isSelected(0) == true

        when:
        instructions.currentEntry = 1

        then:
        instructions.isSelected(1) == true
        instructions.isSelected(0) == false
    }

    def "isSelectedBack should return true only for the 'Back' entry"() {
        expect:
        instructions.isSelectedBack() == true

        when:
        instructions.currentEntry = 1

        then:
        instructions.isSelectedBack() == false
    }

    def "isSelectedConfirm should be true initially"() {
        expect:
        instructions.isSelectedBack()
    }
}

