package com.ldts.asphaltrush.model.soundEffects

import com.ldts.asphaltrush.model.menu.Menu
import spock.lang.Specification
import spock.lang.Subject

import javax.sound.sampled.Clip

class SoundEffectsTest extends Specification {

    @Subject
    SoundEffect soundEffect

    def setup() {
        soundEffect = new SoundEffect("crash.wav")
        soundEffect.soundEffect = Mock(Clip)
    }

    def "play should start the clip"() {
        when:
        soundEffect.play()

        then:
        1 * soundEffect.soundEffect.start()

        cleanup:
        soundEffect = null
    }

    def "initializeSounds should set the frame position to 0"() {
        when:
        soundEffect.play()

        then:
        1 * soundEffect.soundEffect.setFramePosition(0)

        cleanup:
        soundEffect = null
    }
}

