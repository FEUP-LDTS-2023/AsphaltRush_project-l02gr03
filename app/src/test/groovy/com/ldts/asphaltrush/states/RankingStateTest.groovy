package com.ldts.asphaltrush.states

import com.ldts.asphaltrush.controller.ranking.RankingController
import com.ldts.asphaltrush.model.ranking.Ranking
import com.ldts.asphaltrush.viewer.ranking.RankingViewer
import spock.lang.Specification;

class RankingStateTest extends Specification {
    def "RankingState should create RankingViewer and RankingController with the correct model"() {
        given:
        def rankingModel = new Ranking()
        def rankingState = new RankingState(rankingModel)

        when:
        def viewer = rankingState.getViewer()
        def controller = rankingState.getController()

        then:
        viewer instanceof RankingViewer
        controller instanceof RankingController
        controller.model == rankingModel
    }
}
