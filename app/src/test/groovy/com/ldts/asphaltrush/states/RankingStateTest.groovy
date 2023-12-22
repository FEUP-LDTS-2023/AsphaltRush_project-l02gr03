package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.controller.ranking.RankingController
import com.ldts.asphaltrush.model.ranking.Ranking
import com.ldts.asphaltrush.viewer.Viewer
import com.ldts.asphaltrush.viewer.ranking.RankingViewer
import spock.lang.Specification
import spock.lang.Subject;

class RankingStateTest extends Specification {

    @Subject
    Ranking rankingModel
    RankingState rankingState

    def setup() {
        rankingModel = new Ranking()
        rankingState = new RankingState(rankingModel)
    }

    def "RankingState should create RankingViewer and RankingController with the correct model"() {
        when:
        Viewer viewer = rankingState.getViewer()
        Controller controller = rankingState.getController()

        then:
        viewer instanceof RankingViewer
        controller instanceof RankingController
        controller.model == rankingModel

        cleanup:
        rankingModel = null
        rankingState = null
    }
}
