package com.returntosirandora.core.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.returntosirandora.core.protocol.SoundInterface;

public class RTSSound implements SoundInterface {
    private Sound sound;

    public void load(FileHandle file) {
        if (sound != null)
            sound.dispose();
        sound = Gdx.audio.newSound(file);
    }

    public long play() {
        return sound.play();
    }

    public long play(float volume) {
        return sound.play(volume);
    }

    public void stop() {
        sound.stop();
    }

    public void dispose() {
        if (sound != null) {
            sound.dispose();
        }
    }
}
