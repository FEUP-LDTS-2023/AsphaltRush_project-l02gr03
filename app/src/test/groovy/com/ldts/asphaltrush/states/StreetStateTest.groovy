package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.game.StreetController
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.viewer.game.GameViewer
import spock.lang.Specification;

class StreetStateTest extends Specification {
    def "StreetState should create GameViewer and StreetController with the correct model"() {
        given:
        def streetModel = new Street()
        def streetState = new StreetState(streetModel)

        when:
        def viewer = streetState.getViewer()
        def controller = streetState.getController()

        then:
        viewer instanceof GameViewer
        controller instanceof StreetController
        controller.model == streetModel
    }
}
