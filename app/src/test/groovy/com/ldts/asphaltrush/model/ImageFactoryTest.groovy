package com.ldts.asphaltrush.model

import spock.lang.Specification
import spock.lang.Subject

class ImageFactoryTest extends Specification {

    ImageFactory imageFactory = new ImageFactory()

    @Subject
    Image image

    def setup() {
        image = imageFactory.getImage("cars/obstacle/car1")
    }

    def "ImageFactory should load an image from file"() {
        expect:
        image != null
        image.width == 16
        image.height == 39
    }

    def "ImageFactory should return the same instance for a previously loaded image"() {
        given:
        Image image2 = imageFactory.getImage("cars/obstacle/car1")

        expect:
        image == image2
    }

    /*
    def "ImageFactory should handle non-existing images gracefully"() {
        given:
        def imageFactory = new ImageFactory()

        when:
        def image = imageFactory.getImage("cars/obstacle/car10")

        then:
        image == null
    }
     */
}
