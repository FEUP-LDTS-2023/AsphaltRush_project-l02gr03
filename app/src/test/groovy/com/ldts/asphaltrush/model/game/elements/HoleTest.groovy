import spock.lang.Specification
import com.ldts.asphaltrush.model.game.elements.Hole
import com.ldts.asphaltrush.model.Position

class HoleTest extends Specification {

    def "Hole should be initialized with the correct position"() {
        given:
        def x = 5
        def y = 10

        when:
        def hole = new Hole(x, y)
        def position = hole.getPosition()

        then:
        position.getX() == x
        position.getY() == y
    }

    def "Hole should be able to set a new position"() {
        given:
        def hole = new Hole(0, 0)
        def newPosition = new Position(3, 5)

        when:
        hole.setPosition(newPosition)
        def position = hole.getPosition()

        then:
        position == newPosition
    }
}

