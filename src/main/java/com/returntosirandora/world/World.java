package com.returntosirandora.world;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class World {
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;

    public World(FileHandle file) {
        map = new TmxMapLoader().load(file.path());

        renderer = new OrthogonalTiledMapRenderer(map);

    }

    public void render() {
        renderer.render();
    }
}
