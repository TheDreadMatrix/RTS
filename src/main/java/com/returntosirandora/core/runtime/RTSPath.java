package com.returntosirandora.core.runtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.returntosirandora.core.protocol.runtime.PathsInterface;

public class RTSPath implements PathsInterface {

    private final FileHandle assets;

    public RTSPath() {
        assets = Gdx.files.internal("assets");

    }

    @Override
    public FileHandle getUI(String path) {
        return assets.child("ui").child(path);
    }

    @Override
    public FileHandle _forInternal(String path) {
        return assets.child("_internal").child(path);
    }

    @Override
    public FileHandle getMaps(String path) {
        return assets.child("maps").child(path);
    }

    @Override
    public FileHandle getMusic(String path) {
        return assets.child("music").child(path);
    }

    @Override
    public FileHandle getShader(String path) {
        return assets.child("shaders").child(path);
    }

    @Override
    public FileHandle getImages(String path) {
        return assets.child("images").child(path);
    }

    @Override
    public FileHandle getFont(String path) {
        return assets.child("fonts").child(path);
    }

    @Override
    public FileHandle getSound(String path) {
        return assets.child("sound").child(path);
    }
}