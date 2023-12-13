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
        def garage = new Garage()
        def garageState = new GarageState(garage)

        when:
        def controller = garageState.getController()
        def viewer = garageState.getViewer()

        then:
        controller instanceof GarageController
        viewer instanceof GarageViewer
    }

    def "GarageController should respond correctly to user actions"() {
        given:
        def garage = new Garage()
        def game = new Game()
        def garageState = new GarageState(garage)
        def garageController = garageState.getController()

        when:
        garageController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis())
        def movedLeftCar = garage.getCurrentCar()

        and:
        garageController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis())
        def movedRightCar = garage.getCurrentCar()

        then:
        movedLeftCar == 10
        movedRightCar == 0
    }

}
