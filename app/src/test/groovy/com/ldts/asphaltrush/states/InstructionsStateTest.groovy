package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.instructions.InstructionsController
import com.ldts.asphaltrush.model.instructions.Instructions
import com.ldts.asphaltrush.viewer.instructions.InstructionsViewer
import spock.lang.Specification

class InstructionsStateTest extends Specification {
    def "InstructionsState should create InstructionsViewer and InstructionsController with the correct model"() {
        given:
        def instructionsModel = new Instructions()
        def instructionsState = new InstructionsState(instructionsModel)

        when:
        def viewer = instructionsState.getViewer()
        def controller = instructionsState.getController()

        then:
        viewer instanceof InstructionsViewer
        controller instanceof InstructionsController
        controller.model == instructionsModel
    }
}
