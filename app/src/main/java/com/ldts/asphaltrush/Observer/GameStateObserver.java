package com.ldts.asphaltrush.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface GameStateObserver {
    public void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
}
