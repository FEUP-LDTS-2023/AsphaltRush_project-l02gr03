package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.controller.game.StreetController
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.viewer.Viewer
import com.ldts.asphaltrush.viewer.game.GameViewer
import spock.lang.Specification
import spock.lang.Subject;

class StreetStateTest extends Specification {

    @Subject
    Street streetModel
    StreetState streetState

    def setup() {
        streetModel = new Street()
        streetState = new StreetState(streetModel)
    }

    def "StreetState should create GameViewer and StreetController with the correct model"() {
        when:
        Viewer viewer = streetState.getViewer()
        Controller controller = streetState.getController()

        then:
        viewer instanceof GameViewer
        controller instanceof StreetController
        controller.model == streetModel

        cleanup:
        streetModel = null
        streetState = null
    }
}
