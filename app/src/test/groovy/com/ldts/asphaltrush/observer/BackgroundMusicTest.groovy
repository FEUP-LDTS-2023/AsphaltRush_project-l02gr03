package com.ldts.asphaltrush.observer

import com.ldts.asphaltrush.model.menu.Menu
import com.ldts.asphaltrush.states.GameOverState
import com.ldts.asphaltrush.states.GameState
import com.ldts.asphaltrush.states.MenuState
import spock.lang.Specification
import spock.lang.Subject

class BackgroundMusicTest extends Specification {

    @Subject
    BackgroundMusic backgroundMusic
    GameState gameState

    def setup() {
        backgroundMusic = new BackgroundMusic(new GameState())
        gameState = new GameState()
    }


    def "BackgroundMusic Test: Initialization"() {
        expect:
        backgroundMusic.gamestate.getState().getModel() instanceof Menu
        backgroundMusic.backgroundMusicMainMenu != null
        backgroundMusic.backgroundMusicGameOverMenu != null
        backgroundMusic.currentBackgroundMusic != null
        backgroundMusic.previousState == "notgameover"

        cleanup:
        gameState = null
        backgroundMusic.backgroundMusicMainMenu.close()
        backgroundMusic.backgroundMusicGameOverMenu.close()
        backgroundMusic.currentBackgroundMusic.close()

    }

    def "BackgroundMusic Test: Update when not in GameOverState"() {
        when:
        backgroundMusic.update()

        then:
        backgroundMusic.currentBackgroundMusic == backgroundMusic.backgroundMusicMainMenu;
        backgroundMusic.previousState == "notgameover"

        cleanup:
        gameState = null
        backgroundMusic = null
    }

    def "BackgroundMusic Test: Update when transitioning from GameOverState to non-GameOverState"() {
        given:
        gameState.setState(new GameOverState(null))

        when:
        backgroundMusic.update()
        gameState.setState(new MenuState(null))
        backgroundMusic.update()

        then:
        backgroundMusic.currentBackgroundMusic == backgroundMusic.backgroundMusicMainMenu
        backgroundMusic.previousState == "notgameover"

        cleanup:
        gameState = null
        backgroundMusic = null
    }
}
