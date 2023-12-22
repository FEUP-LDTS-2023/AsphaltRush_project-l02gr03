package com.ldts.asphaltrush.viewer.game

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import spock.lang.Specification;

class ObstacleCarViewerTest extends Specification {
    def "ObstacleCarViewer calls gui.drawImage with the correct arguments"() {
        given:
        ObstacleCar obstacleCar = new ObstacleCar(0, 0, 0, 0, 0)
        ObstacleCarViewer obstacleCarViewer = new ObstacleCarViewer()
        GUI gui = Mock()
        ImageFactory imageFactory = Mock()

        when:
        obstacleCarViewer.draw(obstacleCar, gui, imageFactory)

        then:
        1 * gui.drawImage(obstacleCar.getPosition(), imageFactory.getImage("/cars/player/car" + obstacleCar.getType()))
    }
}
