package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.Hole
import com.ldts.asphaltrush.model.game.elements.Player
import com.ldts.asphaltrush.model.game.street.Street
import spock.lang.Specification

class GameViewerTest extends Specification {
    def "GameViewer calls drawText for each element type with the correct arguments"() {
        given:
        Street street = new Street(null)
        street.player = new Player(0, 0, 0, 0, 0)
        street.obstacleCars = new LinkedList<>()
        street.powerUps = new LinkedList<>()
        street.lines = new LinkedList<>()
        street.holes = new LinkedList<>()
        GameViewer gameViewer = new GameViewer(street)
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        gameViewer.draw(gui, imageFactory)

        then:
        2 * gui.drawText(_, _, _, _, _)
    }
}
