package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.model.gameOver.GameOver
import com.ldts.asphaltrush.model.menu.Menu
import com.ldts.asphaltrush.observer.GameStateObserver
import spock.lang.Specification
import spock.lang.Subject;

class GameStateTest extends Specification {

    @Subject
    GameState gameState

    def setup() {
        gameState = new GameState()
    }

    def "GameState should transition to GameOverState with the correct model"() {
        given:
        GameOver gameOverModel = new GameOver(100)

        when:
        gameState.setState(new GameOverState(gameOverModel))

        then:
        gameState.getState() instanceof GameOverState
        gameState.getState().getModel() == gameOverModel

        cleanup:
        gameState.setState(null)
        gameState = null
    }

    def "GameState should transition to MenuState with the correct model"() {
        given:
        Menu menuModel = new Menu()

        when:
        gameState.setState(new MenuState(menuModel))

        then:
        gameState.getState() instanceof MenuState
        gameState.getState().getModel() == menuModel

        cleanup:
        gameState.setState(null)
        gameState = null
    }

    def "GameState should notify observers when the state changes"() {
        given:
        GameStateObserver observerMock = Mock()

        when:
        gameState.addObserver(observerMock)

        then:
        1 * observerMock.update()

        cleanup:
        gameState.setState(null)
        gameState = null
    }

    def "GameState should set and get car type correctly"() {
        when:
        gameState.setCarType(1)

        then:
        gameState.getCarType() == 1

        cleanup:
        gameState.setState(null)
        gameState = null
    }
}
