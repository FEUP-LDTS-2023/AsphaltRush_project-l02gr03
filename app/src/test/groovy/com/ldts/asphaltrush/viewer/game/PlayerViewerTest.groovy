package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.Player
import spock.lang.Specification;

class PlayerViewerTest extends Specification {
    def "PlayerViewer calls gui.drawImage with the correct arguments"() {
        given:
        Player player = new Player(0, 0, 18, 35, 0)
        PlayerViewer playerViewer = new PlayerViewer()
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        playerViewer.draw(player, gui, imageFactory)

        then:
        1 * gui.drawImage(player.getPosition(), imageFactory.getImage("/cars/player/car" + player.getType()))
    }
}
