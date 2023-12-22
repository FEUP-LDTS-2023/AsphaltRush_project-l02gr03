package com.ldts.asphaltrush.viewer.gameOver

import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.gameOver.GameOver
import spock.lang.Specification;

class GameOverViewerTest extends Specification {
    def "GameOverViewer calls gui.drawImage for each element"() {
        given:
        GameOver gameOver = new GameOver(10);
        GameOverViewer gameOverViewer = new GameOverViewer(gameOver)
        GUI gui = Mock()
        ImageFactory imageFactory = new ImageFactory()

        when:
        gameOverViewer.draw(gui, imageFactory)

        then:
        31 * gui.drawImage(_, _)
    }
}
