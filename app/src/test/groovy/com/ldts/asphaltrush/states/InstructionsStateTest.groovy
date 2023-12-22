package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.controller.instructions.InstructionsController
import com.ldts.asphaltrush.model.instructions.Instructions
import com.ldts.asphaltrush.viewer.Viewer
import com.ldts.asphaltrush.viewer.instructions.InstructionsViewer
import spock.lang.Specification
import spock.lang.Subject

class InstructionsStateTest extends Specification {

    @Subject
    Instructions instructionsModel
    InstructionsState instructionsState

    def setup() {
        instructionsModel = new Instructions()
        instructionsState = new InstructionsState(instructionsModel)
    }

    def "InstructionsState should create InstructionsViewer and InstructionsController with the correct model"() {
        when:
        Viewer viewer = instructionsState.getViewer()
        Controller controller = instructionsState.getController()

        then:
        viewer instanceof InstructionsViewer
        controller instanceof InstructionsController
        controller.model == instructionsModel

        cleanup:
        instructionsModel = null
        instructionsState = null
    }
}
