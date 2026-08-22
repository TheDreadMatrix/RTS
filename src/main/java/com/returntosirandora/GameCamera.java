package com.returntosirandora;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class GameCamera {
    private OrthographicCamera camera;
    private ExtendViewport viewport;
    private float smoothness = 8f;

    public GameCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true);

        viewport = new ExtendViewport(1280f, 720f, camera);
    }

    public void update(float deltaTime, float targetX, float targetY) {
        float alpha = 1f - (float) Math.exp(-smoothness * deltaTime);

        camera.position.x = MathUtils.lerp(
                camera.position.x,
                targetX,
                alpha);

        camera.position.y = MathUtils.lerp(
                camera.position.y,
                targetY,
                alpha);

        camera.update();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public Matrix4 getCombined() {
        return camera.combined;
    }
}
