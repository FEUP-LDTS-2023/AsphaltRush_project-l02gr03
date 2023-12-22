package com.ldts.asphaltrush.viewer.menu

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.menu.Menu
import spock.lang.Specification;

class MenuViewerTest extends Specification {
    def "MenuViewer calls gui.drawImage for each element"() {
        given:
        Menu menu = new Menu()
        MenuViewer menuViewer = new MenuViewer(menu)
        GUI gui = Mock()
        ImageFactory imageFactory = new ImageFactory()

        when:
        menuViewer.draw(gui, imageFactory)

        then:
        2 * gui.drawImage(_, _)
    }
}
