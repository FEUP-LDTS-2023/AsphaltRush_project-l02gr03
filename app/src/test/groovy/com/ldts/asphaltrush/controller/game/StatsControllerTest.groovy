package com.ldts.asphaltrush.controller.game

import com.ldts.asphaltrush.Game
import com.ldts.asphaltrush.model.game.elements.powerup.PointMultiplierPowerUp
import com.ldts.asphaltrush.model.game.street.Street
import spock.lang.Specification
import spock.lang.Subject;

class StatsControllerTest extends Specification {
    /*def "StatsController Test 1"() {
        setup:
        def result;

        when:
        result = 0;

        then:
        result != 0;
    }
     */


    @Subject
    PointsController pointsController

    def setup() {
        pointsController = new PointsController(new Street())
    }

    def "step should update points with correct multiplier and interval"() {
        given:
        def playerPowerUp = new PointMultiplierPowerUp(1, 1)
        def player = pointsController.getModel().getPlayer()
        player.setPowerUp(playerPowerUp)
        player.setSpeed(2) // Set an arbitrary speed

        def points = pointsController.getModel().getPoints()
        points.setMultiplier(1) // Initial multiplier

        when:
        pointsController.step(new Game(), GUI.ACTION.NONE, 500) // Simulate 500 milliseconds elapsed

        then:
        // Verify that the multiplier is correctly updated based on the PointMultiplierPowerUp
        points.getMultiplier() == 20

        // Verify that the points are increased based on the elapsed time (POINTS_UPDATE_INTERVAL)
        points.getPoints() == 1
    }
}
