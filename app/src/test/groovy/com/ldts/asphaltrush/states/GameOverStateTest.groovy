package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.controller.gameOver.GameOverController
import com.ldts.asphaltrush.model.gameOver.GameOver
import com.ldts.asphaltrush.viewer.Viewer
import com.ldts.asphaltrush.viewer.gameOver.GameOverViewer
import spock.lang.Specification
import spock.lang.Subject

class GameOverStateTest extends Specification {

    @Subject
    GameOver gameOverModel
    GameOverState gameOverState

    def setup() {
        gameOverModel = new GameOver(100)
        gameOverState = new GameOverState(gameOverModel)
    }

    def "GameOverState should create GameOverViewer and GameOverController with the correct model"() {
        when:
        Viewer viewer = gameOverState.getViewer()
        Controller controller = gameOverState.getController()

        then:
        viewer instanceof GameOverViewer
        controller instanceof GameOverController
        controller.model == gameOverModel

        cleanup:
        gameOverModel = null
        gameOverState = null
    }
}
