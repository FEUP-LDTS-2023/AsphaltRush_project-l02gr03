package com.ldts.asphaltrush.model.gameOver

import spock.lang.Specification

class GameOverTest extends Specification {
    def "moveLeft should change currentEntry correctly"() {
        given:
        def gameOver = new GameOver(100)

        when:
        gameOver.moveLeft()

        then:
        gameOver.currentEntry == "Confirm"
    }

    def "moveRight should change currentEntry correctly"() {
        given:
        def gameOver = new GameOver(100)

        when:
        gameOver.moveRight()

        then:
        gameOver.currentEntry == "Confirm"
    }

    def "moveDown should change currentEntry correctly"() {
        given:
        def gameOver = new GameOver(100)

        when:
        gameOver.moveDown()

        then:
        gameOver.currentEntry == "Back"
    }

    def "moveUp should change currentEntry correctly"() {
        given:
        def gameOver = new GameOver(100)
        gameOver.currentEntry = 14

        when:
        gameOver.moveUp()

        then:
        gameOver.currentEntry == "F"
    }

    def "isSelectedConfirm should be true initially"() {
        given:
        def gameOver = new GameOver(100)

        expect:
        gameOver.isSelectedConfirm()
    }

    def "isNameEmpty should return true for an empty name"() {
        given:
        def gameOver = new GameOver(100)

        when:
        gameOver.setName("")

        then:
        gameOver.isNameEmpty() == true
    }

    def "isNameEmpty should return false for a non-empty name"() {
        given:
        def gameOver = new GameOver(100)

        when:
        gameOver.setName("John")

        then:
        gameOver.isNameEmpty() == false
    }
}

