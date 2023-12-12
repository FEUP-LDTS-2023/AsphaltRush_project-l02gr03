import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.model.game.elements.Barrier

class BarrierTest extends Specification {

    @Subject
    Barrier barrier

    def setup() {
        barrier = new Barrier(1, 1)
    }

    def "should initialize with the correct position"() {
        expect:
        // Verify that the Barrier initializes with the correct position
        barrier.getX() == 1
        barrier.getY() == 1
    }
}
