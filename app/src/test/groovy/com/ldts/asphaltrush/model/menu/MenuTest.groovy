package com.ldts.asphaltrush.model.menu
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Specification
import spock.lang.Subject
import com.ldts.asphaltrush.model.menu.Menu

class MenuTest extends Specification {

    @Subject
    Menu menu

    def setup() {
        menu = new Menu()
    }

    def "nextEntry should move to the next menu entry in a circular manner"() {
        when:
        menu.nextEntry()

        then:
        // Verify that currentEntry has incremented and is within the valid range
        menu.currentEntry == 1
    }

    def "previousEntry should move to the previous menu entry in a circular manner"() {
        when:
        menu.previousEntry()

        then:
        // Verify that currentEntry has decremented and is within the valid range
        menu.currentEntry == 3
    }

    def "isSelected should return true for the selected entry and false for others"() {
        when:
        menu.nextEntry()

        then:
        // Verify that isSelected returns true for the selected entry (currentEntry)
        menu.isSelected(1) == true
        menu.isSelected(0) == false
        menu.isSelected(2) == false
        menu.isSelected(3) == false
    }

    def "isSelectedStart, isSelectedGarage, isSelectedRanking, isSelectedExit should return true for the corresponding entries"() {
        when:
        menu.nextEntry()

        then:
        // Verify that the corresponding isSelected methods return true for the selected entry
        menu.isSelectedStart() == false
        menu.isSelectedGarage() == true
        menu.isSelectedRanking() == false
        menu.isSelectedExit() == false
    }
}

