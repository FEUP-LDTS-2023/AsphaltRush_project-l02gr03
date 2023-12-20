package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.gui.GUI
import com.ldts.asphaltrush.model.ImageFactory
import com.ldts.asphaltrush.model.Position
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCar
import com.ldts.asphaltrush.model.game.elements.obstacleCar.ObstacleCarBuilder
import com.ldts.asphaltrush.model.game.street.Street
import com.ldts.asphaltrush.model.game.street.StreetBuilder
import spock.lang.Specification
import spock.lang.Subject

class ObstacleCarControllerTest extends Specification {

    ImageFactory imageFactory = new ImageFactory()
    ObstacleCarBuilder obstacleCarBuilder = new ObstacleCarBuilder(imageFactory)

    @Subject
    ObstacleCarController obstacleCarController

    def setup() {
        StreetBuilder streetBuilder = new StreetBuilder(1, imageFactory)
        Street street = streetBuilder.createStreet()
        obstacleCarController = new ObstacleCarController(street)
    }

    def "checkAndRemoveNewObstacleCars should remove obstacle cars that have moved off the screen"() {
        given:
        ObstacleCar obstacleCarToRemove = obstacleCarBuilder.createObstacleCar(2)
        obstacleCarToRemove.setPosition(new Position(2, obstacleCarController.getModel().getHeight()+400))
        obstacleCarController.getModel().getObstacleCars().add(obstacleCarToRemove)

        when:
        obstacleCarController.checkAndRemoveNewObstacleCars()

        then:
        !obstacleCarController.getModel().getObstacleCars().contains(obstacleCarToRemove)
    }

    def "ObstacleCarController should add new obstacle cars"() {
        when:
        obstacleCarController.addNewObstacleCars()

        then:
        if (obstacleCarController.getModel().getObstacleCars() == null) obstacleCarController.getModel().getObstacleCars().size() == 0
        else obstacleCarController.getModel().getObstacleCars().size() > 0
    }

    def "ObstacleCarController should move obstacle cars downward"() {
        given:
        ObstacleCar obstacleCar = obstacleCarBuilder.createObstacleCar(1)
        obstacleCar.setPosition(new Position(1, 1))
        obstacleCarController.getModel().getObstacleCars().add(obstacleCar)

        when:
        obstacleCarController.step(new Game(), GUI.ACTION.NONE, 150)

        then:
        obstacleCarController.getModel().getObstacleCars() != null
        obstacleCarController.getModel().getObstacleCars().get(0) == obstacleCar
        obstacleCarController.getModel().getObstacleCars().get(0).getPosition().x == 1
        obstacleCarController.getModel().getObstacleCars().get(0).getPosition().y == 1 + obstacleCarController.OBSTACLE_CAR_SPEED*obstacleCarController.getModel().getPlayer().getSpeed()
    }
}
