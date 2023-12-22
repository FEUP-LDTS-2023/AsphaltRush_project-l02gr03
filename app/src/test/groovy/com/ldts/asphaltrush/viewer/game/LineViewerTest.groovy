package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.Line
import spock.lang.Specification;

class LineViewerTest extends Specification {
    def "LineViewer calls gui.drawImage with the correct arguments"() {
        given:
        Line line = new Line(0, 0)
        LineViewer lineViewer = new LineViewer()
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        lineViewer.draw(line, gui, imageFactory)

        then:
        4 * gui.drawImage(_, imageFactory.getImage("/elements/line"));
    }
}
