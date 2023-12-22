package com.ldts.asphaltrush.model.ranking

import com.ldts.asphaltrush.model.menu.Menu
import spock.lang.Specification
import spock.lang.Subject

class RankingTest extends Specification {

    @Subject
    Ranking ranking = new Ranking()

    def setup() {
        ranking = new Ranking()
    }

    def "getRanking should return the correct ranking"() {
        when:
        def result = ranking.getRanking()

        then:
        result.size() == 5

        cleanup:
        ranking = null
    }

    def "isSelectedBack should be true initially"() {
        expect:
        ranking.isSelectedBack()

        cleanup:
        ranking = null
    }
}

