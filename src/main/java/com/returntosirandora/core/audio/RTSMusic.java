package com.returntosirandora.core.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.returntosirandora.core.protocol.MusicInterface;
import com.returntosirandora.core.protocol.ApplicationInterface;

public class RTSMusic implements MusicInterface {

    private Music music;
    private ApplicationInterface game;

    public RTSMusic(ApplicationInterface game) {
        this.game = game;
    }

    @Override
    public RTSMusic loadMusic(String fileName, Boolean isLooping, float musicVolume) {

        if (music != null) {
            music.stop();
            music.dispose();
        }

        music = Gdx.audio.newMusic(game.getPaths().getMusic(fileName));
        music.setLooping(isLooping);
        music.setVolume(musicVolume);

        return this;

    }

    @Override
    public void resumeOrPlay() {
        music.play();
    }

    @Override
    public void stop() {
        music.stop();
    }

    @Override
    public void pause() {
        music.pause();
    }

    @Override
    public Boolean isPlaying() {
        return music.isPlaying();
    }

    @Override
    public void setVolume(float musicVolume) {
        music.setVolume(musicVolume);
    }

    @Override
    public void dispose() {
        music.dispose();
    }

}
