package com.ldts.asphaltrush.controller.gameOver

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.gameOver.GameOver
import spock.lang.Specification
import spock.lang.Subject


class GameOverControllerTest extends Specification {

    @Subject
    GameOverController gameOverController

    def setup() {
        gameOverController = new GameOverController(new GameOver(10))
    }

    def "step should move up in the model when UP action is performed"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        gameOverController.step(game, GUI.ACTION.UP, 150)

        then:
        gameOverController.getModel().isSelectedDelete()

        cleanup:
        gameOverController = null
        game.gui.close()
    }

    def "step should move down in the model when DOWN action is performed"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        gameOverController.step(game, GUI.ACTION.DOWN, 150)

        then:
        gameOverController.getModel().isSelectedBackToMenu()

        cleanup:
        gameOverController = null
        game.gui.close()
    }

    /*
    def "step should change game state to MenuState when SELECT action and Back to Menu is selected"() {
        given:
        GameState gameState = Mock(GameState)
        game.getGameState() >> gameState
        gameOverController.getModel().currentEntry = 1

        when:
        gameOverController.step(game, GUI.ACTION.SELECT, 150)

        then:
        1 * gameState.setState(_)

        cleanup:
        gameOverController = null
        game.gui.close()
    }
     */

}
