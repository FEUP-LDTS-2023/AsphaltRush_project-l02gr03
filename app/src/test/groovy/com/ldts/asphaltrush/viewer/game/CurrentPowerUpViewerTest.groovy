package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.Player
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import spock.lang.Specification;

class CurrentPowerUpViewerTest extends Specification {
    def "PlayerViewer calls gui.drawImage with the correct arguments"() {
        given:
        PowerUp powerUp = new InvenciblePowerUp(0, 0)
        CurrentPowerUpViewer currentPowerUpViewer = new CurrentPowerUpViewer()
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        currentPowerUpViewer.draw(powerUp, gui, imageFactory)

        then:
        1 * gui.drawImage(_, _, _, _)
    }
}
