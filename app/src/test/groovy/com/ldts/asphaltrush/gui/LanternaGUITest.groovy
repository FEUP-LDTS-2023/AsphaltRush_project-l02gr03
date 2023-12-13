package com.ldts.asphaltrush.gui

import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import com.ldts.asphaltrush.model.Image
import com.ldts.asphaltrush.model.Position
import spock.lang.Specification
import spock.lang.Subject
import spock.mock.MockFactory;

class LanternaGUITest extends Specification {

    def "LanternaGUITest 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }




    /*
    @Subject
    LanternaGUI gui

    @Mock
    Screen screen

    def setup() {
        gui = new LanternaGUI(10, 10)
        gui.screen = screen
    }

    def "drawImage should correctly draw an image on the screen"() {
        given:
        def position = new Position(1, 1)
        def image = new Image(2, 2, [["#FFFFFF", "#000000"], ["#000000", "#FFFFFF"]])

        when:
        gui.drawImage(position, image)

        then:
        1 * screen.newTextGraphics()
        1 * screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"))
        1 * screen.newTextGraphics().setForegroundColor(TextColor.Factory.fromString("#FFFFFF"))
        1 * screen.newTextGraphics().putString(1, 1, " ")

        1 * screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("#000000"))
        1 * screen.newTextGraphics().setForegroundColor(TextColor.Factory.fromString("#000000"))
        1 * screen.newTextGraphics().putString(2, 1, " ")

        1 * screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("#000000"))
        1 * screen.newTextGraphics().setForegroundColor(TextColor.Factory.fromString("#000000"))
        1 * screen.newTextGraphics().putString(1, 2, " ")

        1 * screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"))
        1 * screen.newTextGraphics().setForegroundColor(TextColor.Factory.fromString("#FFFFFF"))
        1 * screen.newTextGraphics().putString(2, 2, " ")
    }

    def "drawText should correctly draw text on the screen"() {
        given:
        def position = new Position(1, 1)

        when:
        gui.drawText(position, "Hello", "#FFFFFF")

        then:
        1 * screen.newTextGraphics()
        1 * screen.newTextGraphics().setForegroundColor(TextColor.Factory.fromString("#FFFFFF"))
        1 * screen.newTextGraphics().putString(1, 1, "Hello")
    }

*/

}
