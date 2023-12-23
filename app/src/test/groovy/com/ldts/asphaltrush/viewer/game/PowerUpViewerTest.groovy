package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.powerup.InvenciblePowerUp
import com.ldts.asphaltrush.model.game.elements.powerup.PowerUp
import spock.lang.Specification;

class PowerUpViewerTest extends Specification {
    def "PowerUpViewer calls gui.drawImage with the correct arguments"() {
        given:
        PowerUp powerUp = new InvenciblePowerUp(0,0)
        PowerUpViewer powerUpViewer = new PowerUpViewer()
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        powerUpViewer.draw(powerUp, gui, imageFactory)

        then:
        1 * gui.drawImage(_, _, _, _);
    }
}
