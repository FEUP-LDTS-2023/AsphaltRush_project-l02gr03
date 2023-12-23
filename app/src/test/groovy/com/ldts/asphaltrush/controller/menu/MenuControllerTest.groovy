package com.ldts.asphaltrush.controller.menu

import com.ldts.asphaltrush.model.soundEffects.SelectOptionSound
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
        menuController.selectOptionSound = Mock(SelectOptionSound)
        menuController.selectOptionSound.play() >> {}
    }

    def "step should update the menu selection based on UP and DOWN actions"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        menuController.step(game, GUI.ACTION.UP, 0)

        then:
        // Verify that UP action moves to the previous menu entry
        menuController.getModel().currentEntry == 4

        when:
        menuController.step(game, GUI.ACTION.DOWN, 0)

        then:
        // Verify that DOWN action moves to the next menu entry
        menuController.getModel().currentEntry == 0

        cleanup:
        menuController = null
        game.backgroundMusic.backgroundMusicMainMenu.close()
        game.backgroundMusic.backgroundMusicGameOverMenu.close()
        game.backgroundMusic.currentBackgroundMusic.close()
        game.gui.close()
    }

}

