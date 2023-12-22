package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.viewer.Viewer
import spock.lang.Specification
import com.ldts.asphaltrush.controller.menu.MenuController
import com.ldts.asphaltrush.model.menu.Menu
import com.ldts.asphaltrush.viewer.menu.MenuViewer
import spock.lang.Subject

class MenuStateTest extends Specification {

    @Subject
    Menu menuModel
    MenuState menuState

    def setup() {
        menuModel = new Menu()
        menuState = new MenuState(menuModel)
    }

    def "MenuState should create MenuViewer and MenuController with the correct model"() {
        when:
        Viewer viewer = menuState.getViewer()
        Controller controller = menuState.getController()

        then:
        viewer instanceof MenuViewer
        controller instanceof MenuController
        controller.model == menuModel

        cleanup:
        menuModel = null
        menuState = null
    }
}
