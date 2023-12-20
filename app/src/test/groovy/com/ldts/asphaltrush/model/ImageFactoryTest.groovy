package com.ldts.asphaltrush.model

import spock.lang.Specification;

class ImageFactoryTest extends Specification {
    def "ImageFactory should load an image from file"() {
        given:
        ImageFactory imageFactory = new ImageFactory()

        when:
        Image image = imageFactory.getImage("cars/obstacle/car1")

        then:
        image != null
        image.width == 16
        image.height == 39
    }

    def "ImageFactory should return the same instance for a previously loaded image"() {
        given:
        def imageFactory = new ImageFactory()

        when:
        def image1 = imageFactory.getImage("cars/obstacle/car1")
        def image2 = imageFactory.getImage("cars/obstacle/car1")

        then:
        image1 == image2
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
