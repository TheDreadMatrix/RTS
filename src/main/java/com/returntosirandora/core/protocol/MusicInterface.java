package com.returntosirandora.core.protocol;

public interface MusicInterface {
    public void loadMusic(String musicPath, Boolean isLooping, float musicVolume);

    public void resumeOrPlay();

    public void stop();

    public void pause();

    public Boolean isPlaying();

    public void setVolume(float musicVolume);

    public void dispose();
}
