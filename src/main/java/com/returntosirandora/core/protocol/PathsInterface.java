package com.returntosirandora.core.protocol;

import com.badlogic.gdx.files.FileHandle;

public interface PathsInterface {
    public FileHandle getMaps(String path);

    public FileHandle getMusic(String path);

    public FileHandle getShader(String path);

    public FileHandle getTexture(String path);

    public FileHandle getFont(String path);

    public FileHandle getSound(String path);
}