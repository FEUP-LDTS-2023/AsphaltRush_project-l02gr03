package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.Hole
import spock.lang.Specification

class HoleViewerTest extends Specification {
    def "HoleViewer calls gui.drawImage with the correct arguments"() {
        given:
        Hole hole = new Hole(0, 0)
        HoleViewer holeViewer = new HoleViewer()
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        holeViewer.draw(hole, gui, imageFactory)

        then:
        1 * gui.drawImage(hole.getPosition(), imageFactory.getImage( "/elements/hole"))
    }
}
