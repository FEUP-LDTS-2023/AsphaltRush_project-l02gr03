package com.ldts.asphaltrush.observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface GameStateObserver {
    void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
}
