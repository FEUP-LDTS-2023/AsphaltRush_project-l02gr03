import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.viewer.Viewer
import spock.lang.Specification
import com.ldts.asphaltrush.controller.garage.GarageController
import com.ldts.asphaltrush.model.garage.Garage
import com.ldts.asphaltrush.states.GarageState
import com.ldts.asphaltrush.viewer.garage.GarageViewer
import spock.lang.Subject

class GarageStateTest extends Specification {

    @Subject
    Garage garage
    GarageState garageState

    def setup() {
        garage = new Garage(1)
        garageState = new GarageState(garage)
    }

    def "GarageState should create the correct Controller and Viewer"() {
        when:
        Controller controller = garageState.getController()
        Viewer viewer = garageState.getViewer()

        then:
        controller instanceof GarageController
        viewer instanceof GarageViewer

        cleanup:
        garage = null
        garageState = null
    }
}
