import spock.lang.Specification
import com.ldts.asphaltrush.model.game.elements.Barrier


class BarrierTest extends Specification {

    def "initialize with the correct position"() {
        when:
        Barrier barrier = new Barrier(10, 20)

        then:
        barrier.getPosition().getX() == 10
        barrier.getPosition().getY() == 20
    }
}

