package com.ldts.asphaltrush.model.ranking

import spock.lang.Specification

class RankingTest extends Specification {
    def "getRanking should return the correct ranking"() {
        given:
        def ranking = new Ranking()

        when:
        def result = ranking.getRanking()

        then:
        result.size() == 0
    }

    def "isSelectedBack should be true initially"() {
        given:
        def ranking = new Ranking()

        expect:
        ranking.isSelectedBack()
    }
}

