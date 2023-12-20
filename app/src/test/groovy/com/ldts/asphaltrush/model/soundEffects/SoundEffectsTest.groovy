package com.ldts.asphaltrush.model.soundEffects

import spock.lang.Specification
import javax.sound.sampled.Clip

class SoundEffectsTest extends Specification {
    def "play should start the clip"() {
        given:
        SoundEffect soundEffect = new SoundEffect("crash.wav")
        soundEffect.soundEffect = Mock(Clip)

        when:
        soundEffect.play()

        then:
        1 * soundEffect.soundEffect.start()
    }

    def "initializeSounds should set the frame position to 0"() {
        given:
        SoundEffect soundEffect = new SoundEffect("crash.wav")
        soundEffect.soundEffect = Mock(Clip)

        when:
        soundEffect.play()

        then:
        1 * soundEffect.soundEffect.setFramePosition(0)
    }
}

