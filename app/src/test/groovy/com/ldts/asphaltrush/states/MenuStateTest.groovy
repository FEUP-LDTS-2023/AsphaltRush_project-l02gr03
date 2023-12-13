package com.ldts.asphaltrush.states
import spock.lang.Specification
import com.ldts.asphaltrush.controller.menu.MenuController
import com.ldts.asphaltrush.model.menu.Menu
import com.ldts.asphaltrush.viewer.menu.MenuViewer

class MenuStateSpec extends Specification {

    def "MenuState should create MenuViewer and MenuController with the correct model"() {
        given:
        def menuModel = new Menu()
        def menuState = new MenuState(menuModel)

        when:
        def viewer = menuState.getViewer()
        def controller = menuState.getController()

        then:
        viewer instanceof MenuViewer
        controller instanceof MenuController
        controller.model == menuModel
    }
}
