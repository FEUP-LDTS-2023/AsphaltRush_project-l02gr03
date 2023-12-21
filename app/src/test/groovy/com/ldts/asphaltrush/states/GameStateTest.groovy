package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.model.gameOver.GameOver
import com.ldts.asphaltrush.model.menu.Menu
import com.ldts.asphaltrush.observer.BackgroundMusicTest
import com.ldts.asphaltrush.observer.GameStateObserver
import spock.lang.Specification;

class GameStateTest extends Specification {
    def "GameState should transition to GameOverState with the correct model"() {
        given:
        GameState gameState = new GameState()
        GameOver gameOverModel = new GameOver(100)

        when:
        gameState.setState(new GameOverState(gameOverModel))

        then:
        gameState.getState() instanceof GameOverState
        gameState.getState().getModel() == gameOverModel
    }

    def "GameState should transition to MenuState with the correct model"() {
        given:
        GameState gameState = new GameState()
        Menu menuModel = new Menu()

        when:
        gameState.setState(new MenuState(menuModel))

        then:
        gameState.getState() instanceof MenuState
        gameState.getState().getModel() == menuModel
    }

    def "GameState should notify observers when the state changes"() {
        given:
        GameState gameState = new GameState()
        GameStateObserver observerMock = Mock()

        when:
        gameState.addObserver(observerMock)

        then:
        1 * observerMock.update()
    }

    def "GameState should set and get car type correctly"() {
        given:
        GameState gameState = new GameState()

        when:
        gameState.setCarType(1)

        then:
        gameState.getCarType() == 1
    }
}
