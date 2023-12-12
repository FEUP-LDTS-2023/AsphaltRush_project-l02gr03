import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.model.game.elements.Hole

class HoleTest extends Specification {

    @Subject
    Hole hole

    def setup() {
        hole = new Hole(1, 1)
    }

    def "should initialize with the correct position"() {
        expect:
        // Verify that the Hole initializes with the correct position
        hole.getX() == 1
        hole.getY() == 1
    }
}
