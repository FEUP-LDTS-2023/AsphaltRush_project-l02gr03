package com.ldts.asphaltrush.model.ranking

import spock.lang.Specification

class PairTest extends Specification {
    def "getFirst should return the correct value"() {
        given:
        Pair pair = new Pair("John", 100)

        expect:
        pair.getFirst() == "John"
    }

    def "getSecond should return the correct value"() {
        given:
        Pair pair = new Pair("John", 100)

        expect:
        pair.getSecond() == 100
    }

    def "pair with different values should not be equal"() {
        given:
        Pair pair1 = new Pair("John", 100)
        Pair pair2 = new Pair("Jane", 200)

        expect:
        !(pair1 == pair2)
    }

    def "pair with the same values should be equal"() {
        given:
        Pair pair1 = new Pair("John", 100)
        Pair pair2 = new Pair("John", 100)

        expect:
        pair1.first == pair2.first
        pair1.second == pair2.second
    }
}

