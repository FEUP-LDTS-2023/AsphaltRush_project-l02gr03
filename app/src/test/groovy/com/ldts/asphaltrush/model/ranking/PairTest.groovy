package com.ldts.asphaltrush.model.ranking

import com.ldts.asphaltrush.model.menu.Menu
import spock.lang.Specification
import spock.lang.Subject

class PairTest extends Specification {

    @Subject
    Pair pair

    def setup() {
        pair = new Pair("John", 100)
    }

    def "getFirst should return the correct value"() {
        expect:
        pair.getFirst() == "John"

        cleanup:
        pair = null
    }

    def "getSecond should return the correct value"() {
        expect:
        pair.getSecond() == 100

        cleanup:
        pair = null
    }

    def "pair with different values should not be equal"() {
        given:
        Pair pair2 = new Pair("Jane", 200)

        expect:
        !(pair == pair2)

        cleanup:
        pair = null
    }

    def "pair with the same values should be equal"() {
        given:
        Pair pair2 = new Pair("John", 100)

        expect:
        pair.first == pair2.first
        pair.second == pair2.second

        cleanup:
        pair = null
    }
}

