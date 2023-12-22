package com.ldts.asphaltrush.model.gameOver

import spock.lang.Specification
import spock.lang.Subject

class GameOverTest extends Specification {

    @Subject
    GameOver gameOver

    def setup() {
        gameOver = new GameOver(100)
    }

    def "moveLeft should change currentEntry correctly"() {
        when:
        gameOver.moveLeft()

        then:
        gameOver.currentEntry == "Confirm"

        cleanup:
        gameOver = null
    }

    def "moveRight should change currentEntry correctly"() {
        when:
        gameOver.moveRight()

        then:
        gameOver.currentEntry == "Confirm"

        cleanup:
        gameOver = null
    }

    def "moveDown should change currentEntry correctly"() {
        when:
        gameOver.moveDown()

        then:
        gameOver.currentEntry == "Back"

        cleanup:
        gameOver = null
    }

    def "moveUp should change currentEntry correctly"() {
        given:
        gameOver.currentEntry = 14

        when:
        gameOver.moveUp()

        then:
        gameOver.currentEntry == "F"

        cleanup:
        gameOver = null
    }

    def "isSelectedConfirm should be true initially"() {
        expect:
        gameOver.isSelectedConfirm()

        cleanup:
        gameOver = null
    }

    def "isNameEmpty should return true for an empty name"() {
        when:
        gameOver.setName("")

        then:
        gameOver.isNameEmpty() == true

        cleanup:
        gameOver = null
    }

    def "isNameEmpty should return false for a non-empty name"() {
        when:
        gameOver.setName("John")

        then:
        gameOver.isNameEmpty() == false

        cleanup:
        gameOver = null
    }
}

