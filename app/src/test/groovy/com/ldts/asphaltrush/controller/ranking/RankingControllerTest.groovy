package com.ldts.asphaltrush.controller.ranking

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ranking.Ranking
import com.ldts.asphaltrush.states.MenuState
import com.ldts.asphaltrush.states.State
import spock.lang.Specification
import spock.lang.Subject;

class RankingControllerTest extends Specification {

    @Subject
    RankingController rankingController

    def setup() {
        rankingController = new RankingController(new Ranking())
    }

    def "step should change game state to MenuState when SELECT action is performed and Back is selected"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}

        when:
        rankingController.step(game, GUI.ACTION.SELECT, 150)

        then:
        game.getGameState().getState() instanceof MenuState

        cleanup:
        rankingController = null
        game.gui.close()
    }

    def "step should not change game state when SELECT action is not performed"() {
        given:
        Game game = new Game()
        game.backgroundMusic.initializeSounds() >> {}
        State initialState = game.getGameState().getState()

        when:
        rankingController.step(game, GUI.ACTION.NONE, 0)

        then:
        initialState == game.getGameState().getState()

        cleanup:
        rankingController = null
        game.gui.close()
    }
}
