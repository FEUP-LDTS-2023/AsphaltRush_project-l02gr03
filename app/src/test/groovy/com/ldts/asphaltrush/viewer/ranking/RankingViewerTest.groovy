package com.ldts.asphaltrush.viewer.ranking

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.ranking.Ranking
import spock.lang.Specification;

class RankingViewerTest extends Specification {
    def "RankingViewer calls gui.drawImage for each element"() {
        given:
        Ranking ranking = new Ranking()
        RankingViewer rankingViewer = new RankingViewer(ranking)
        GUI gui = Mock()
        ImageFactory imageFactory = new ImageFactory()

        when:
        rankingViewer.draw(gui, imageFactory)

        then:
        3 * gui.drawImage(_, _)
    }
}
