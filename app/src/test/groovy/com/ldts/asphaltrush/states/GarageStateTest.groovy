import spock.lang.Specification
import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.controller.garage.GarageController
import com.ldts.asphaltrush.model.garage.Garage
import com.ldts.asphaltrush.states.GarageState
import com.ldts.asphaltrush.viewer.garage.GarageViewer
import com.ldts.asphaltrush.viewer.Viewer
import com.ldts.asphaltrush.controller.Controller
import com.ldts.asphaltrush.gui.GUI

class GarageStateTest extends Specification {

    def "GarageState should create the correct Controller and Viewer"() {
        given:
        Garage garage = new Garage(1)
        GarageState garageState = new GarageState(garage)

        when:
        GarageController controller = garageState.getController()
        GarageViewer viewer = garageState.getViewer()

        then:
        controller instanceof GarageController
        viewer instanceof GarageViewer
    }
}
