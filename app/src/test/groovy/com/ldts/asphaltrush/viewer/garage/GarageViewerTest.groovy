package com.ldts.asphaltrush.viewer.garage

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.garage.Garage
import spock.lang.Specification;

class GarageViewerTest extends Specification {
    def "GarageViewer calls gui.drawImage for each element"() {
        given:
        Garage garage = new Garage(0)
        GarageViewer garageViewer = new GarageViewer(garage)
        GUI gui = Mock()
        ImageFactory imageFactory = new ImageFactory()

        when:
        garageViewer.draw(gui, imageFactory)

        then:
        1 * gui.drawImage(_, _)
    }
}
