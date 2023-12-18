package com.ldts.asphaltrush.model

import spock.lang.Specification;

class ImageTest extends Specification {
    def "Image Test: Check Width and Height"() {
        given:
        int width = 3
        int height = 4
        String[][] colorMatrix = [
                ["R", "G", "B"],
                ["R", "G", "B"],
                ["R", "G", "B"],
                ["R", "G", "B"]
        ]
        Image image = new Image(width, height, colorMatrix)

        expect:
        image.width == 3
        image.height == 4
    }

    def "Image Test: Check Color Matrix"() {
        given:
        int width = 2
        int height = 2
        String[][] colorMatrix = [
                ["R", "G"],
                ["B", "Y"]
        ]
        Image image = new Image(width, height, colorMatrix)

        expect:
        image.colorMatrix == colorMatrix
    }

    def "Image Test: Check default values"() {
        given:
        Image image = new Image(0, 0, null)

        expect:
        image.width == 0
        image.height == 0
        image.colorMatrix == null
    }
}
