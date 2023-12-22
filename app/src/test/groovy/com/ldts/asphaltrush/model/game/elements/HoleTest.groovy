import spock.lang.Specification
import com.ldts.asphaltrush.model.game.elements.Hole
import com.ldts.asphaltrush.model.Position

class HoleTest extends Specification {

    def "Hole should be initialized with the correct position"() {
        given:
        int x = 5
        int y = 10

        when:
        Hole hole = new Hole(x, y)
        Position position = hole.getPosition()

        then:
        position.getX() == x
        position.getY() == y
    }

    def "Hole should be able to set a new position"() {
        given:
        Hole hole = new Hole(0, 0)
        Position newPosition = new Position(3, 5)

        when:
        hole.setPosition(newPosition)
        Position position = hole.getPosition()

        then:
        position == newPosition
    }
}

