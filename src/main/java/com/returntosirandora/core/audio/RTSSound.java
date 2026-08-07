package com.returntosirandora.core.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

public class RTSSound {
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
