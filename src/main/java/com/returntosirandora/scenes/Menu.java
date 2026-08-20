package com.returntosirandora.scenes;

import java.util.HashMap;
import java.util.function.Supplier;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.returntosirandora.subscenes.BaseSubScene;
import com.returntosirandora.subscenes.menu.MainSubScene;
import com.returntosirandora.subscenes.menu.ProfileSubScene;
import com.returntosirandora.subscenes.menu.BrawlersSubScene;
import com.returntosirandora.subscenes.menu.SettingsSubScene;
import com.returntosirandora.subscenes.menu.TrophieRoadSubScene;

public class Menu extends BaseScene {

    HashMap<String, Supplier<BaseSubScene>> subSceneDict = new HashMap<>();
    BaseSubScene currentSubScene = null;
    String currentName = "main";
    String stateMainScene = "main";

    float stateTime = 0f;

    SpriteBatch batch;
    Animation<TextureRegion> animation;

    Music MUSIC_MENU;

    @Override
    public void create() {

        batch = new SpriteBatch();
        TextureAtlas atlas = new TextureAtlas(paths.getImages("atlas/test/test.atlas"));

        animation = new Animation<>(0.1f, atlas.findRegions("icons"), Animation.PlayMode.LOOP);

        // Sub scenes
        subSceneDict.put("main", () -> new MainSubScene().initSubScene(game, this::redirect));
        subSceneDict.put("brawlers", () -> new BrawlersSubScene().initSubScene(game, this::redirect));
        subSceneDict.put("profile", () -> new ProfileSubScene().initSubScene(game, this::redirect));
        subSceneDict.put("trophie-road", () -> new TrophieRoadSubScene().initSubScene(game, this::redirect));
        subSceneDict.put("settings", () -> new SettingsSubScene().initSubScene(game, this::redirect));

        currentSubScene = subSceneDict.get(currentName).get();
        currentSubScene.create(mainStage);

        // Music menu
        // MUSIC_MENU = Gdx.audio.newMusic(paths.getMusic("menu.ogg"));
        // MUSIC_MENU.setLooping(true);
        // MUSIC_MENU.play();

    }

    public void redirect(String name) {
        currentName = name;
    }

    @Override
    public void update(float deltaTime) {
        String stateScene = currentName;
        stateTime += deltaTime;

        if (!currentName.equals(stateMainScene)) {
            currentSubScene.dispose();

            currentSubScene = subSceneDict.get(stateScene).get();
            currentSubScene.create(mainStage);
            stateMainScene = stateScene;

        }

        super.update(deltaTime);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();

        TextureRegion frame = animation.getKeyFrame(stateTime);

        batch.begin();
        batch.draw(frame, 100, 100);
        batch.end();

    }

    @Override
    public void end() {
        super.end();

        batch.dispose();

        MUSIC_MENU.dispose();
    }
}
