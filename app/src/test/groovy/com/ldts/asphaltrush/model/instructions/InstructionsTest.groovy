package com.ldts.asphaltrush.model.instructions

import com.ldts.asphaltrush.model.instructions.Instructions
import spock.lang.Specification

class InstructionsTest extends Specification {
    def "isSelected should return true for the current entry"() {
        given:
        Instructions instructions = new Instructions()

        expect:
        instructions.isSelected(0) == true

        when:
        instructions.currentEntry = 1

        then:
        instructions.isSelected(1) == true
        instructions.isSelected(0) == false
    }

    def "isSelectedBack should return true only for the 'Back' entry"() {
        given:
        Instructions instructions = new Instructions()

        expect:
        instructions.isSelectedBack() == true

        when:
        instructions.currentEntry = 1

        then:
        instructions.isSelectedBack() == false
    }

    def "isSelectedConfirm should be true initially"() {
        given:
        Instructions instructions = new Instructions()

        expect:
        instructions.isSelectedBack()
    }
}

