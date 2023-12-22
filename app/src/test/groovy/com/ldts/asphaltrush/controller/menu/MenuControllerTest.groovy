package com.ldts.asphaltrush.controller.menu

import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.menu.Menu

class MenuControllerTest extends Specification {

    @Subject
    MenuController menuController

    def setup() {
        menuController = new MenuController(new Menu())
    }

    def "step should update the menu selection based on UP and DOWN actions"() {
        when:
        menuController.step(new Game(), GUI.ACTION.UP, 0)

        then:
        // Verify that UP action moves to the previous menu entry
        menuController.getModel().currentEntry == 4

        when:
        menuController.step(new Game(), GUI.ACTION.DOWN, 0)

        then:
        // Verify that DOWN action moves to the next menu entry
        menuController.getModel().currentEntry == 0

        cleanup:
        menuController = null;
    }

}

