package com.ldts.asphaltrush.observer

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.menu.Menu
import com.ldts.asphaltrush.states.GameOverState
import com.ldts.asphaltrush.states.GameState
import com.ldts.asphaltrush.states.MenuState
import spock.lang.Specification
import javax.sound.sampled.*;

class BackgroundMusicTest extends Specification {
    def "BackgroundMusic Test: Initialization"() {
        given:
        def backgroundMusic = new BackgroundMusic(new GameState())

        expect:
        backgroundMusic.gamestate.getState().getModel() instanceof Menu
        backgroundMusic.backgroundMusicMainMenu != null
        backgroundMusic.backgroundMusicGameOverMenu != null
        backgroundMusic.currentBackgroundMusic != null
        backgroundMusic.previousState == "notgameover"
    }

    def "BackgroundMusic Test: Update when not in GameOverState"() {
        given:
        def backgroundMusic = new BackgroundMusic(new GameState())

        when:
        backgroundMusic.update()

        then:
        backgroundMusic.currentBackgroundMusic == backgroundMusic.backgroundMusicMainMenu;
        backgroundMusic.previousState == "notgameover"
    }

    def "BackgroundMusic Test: Update when in GameOverState"() {
        given:
        GameState gameState = new GameState()
        def backgroundMusic = new BackgroundMusic(gameState)
        gameState.setState(new GameOverState())

        when:
        backgroundMusic.update()

        then:
        backgroundMusic.currentBackgroundMusic == backgroundMusic.backgroundMusicGameOverMenu;
        backgroundMusic.previousState == "gameover"
    }

    def "BackgroundMusic Test: Update when transitioning from GameOverState to non-GameOverState"() {
        given:
        GameState gameState = new GameState()
        def backgroundMusic = new BackgroundMusic(gameState)
        gameState.setState(new GameOverState())

        when:
        backgroundMusic.update()
        gameState.setState(new MenuState())
        backgroundMusic.update()

        then:
        backgroundMusic.currentBackgroundMusic == backgroundMusic.backgroundMusicMainMenu
        backgroundMusic.previousState == "notgameover"
    }
}
