package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.gameOver.GameOverController
import com.ldts.asphaltrush.model.gameOver.GameOver
import com.ldts.asphaltrush.viewer.gameOver.GameOverViewer
import spock.lang.Specification;

class GameOverStateTest extends Specification {
    def "GameOverState should create GameOverViewer and GameOverController with the correct model"() {
        given:
        def gameOverModel = new GameOver(100)
        def gameOverState = new GameOverState(gameOverModel)

        when:
        def viewer = gameOverState.getViewer()
        def controller = gameOverState.getController()

        then:
        viewer instanceof GameOverViewer
        controller instanceof GameOverController
        controller.model == gameOverModel
    }
}
