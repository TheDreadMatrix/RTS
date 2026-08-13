package com.returntosirandora.core.protocol.runtime;

import com.badlogic.gdx.files.FileHandle;

public interface PathsInterface {
    public FileHandle getUI(String path);

    public FileHandle getMaps(String path);

    public FileHandle getMusic(String path);

    public FileHandle getShader(String path);

    public FileHandle getImages(String path);

    public FileHandle getFont(String path);

    public FileHandle getSound(String path);

    public FileHandle _forInternal(String path);
}