package com.returntosirandora.characters.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.returntosirandora.characters.defenition.CharacterDescription;

public class Character {

    protected int health;
    protected boolean isStanding;

    protected int speed;
    protected int speedUp;

    protected float stamina;
    protected float staminaMax;
    protected float staminaRegen = 35f;
    protected float staminaDrain = 55f;

    protected Vector2 position;
    protected Vector2 velocity = new Vector2();

    public Character initChr(CharacterDescription character, float x, float y) {
        this.isStanding = true;

        this.speed = character.getSpeed();
        this.speedUp = character.getSpeedUp();

        this.staminaMax = character.getStamina();
        this.stamina = staminaMax;

        this.health = character.getHealth();

        this.position = new Vector2(x, y);
        return this;
    }

    public void create(CharacterDescription character) {

    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health <= 0) {
            health = 0;
            isStanding = false;
        }
    }

    public float getStamina() {
        return stamina;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Vector2 getPos() {
        return position;
    }

    protected void controlPlayer(float deltaTime) {

        boolean isRunning = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)
                && stamina > 0;

        float currentSpeed = isRunning ? speedUp : speed;

        // X direction
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.x = currentSpeed;

        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.x = -currentSpeed;
        } else {
            velocity.x = 0;
        }

        // Y direction
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.y = -currentSpeed;

        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.y = currentSpeed;
        } else {
            velocity.y = 0;
        }

        // Sprint
        if (isRunning && stamina != 0) {
            stamina -= staminaDrain * deltaTime;

            if (stamina < 0) {
                stamina = 0;
            }

        } else {
            stamina += staminaRegen * deltaTime;

            if (stamina > staminaMax) {
                stamina = staminaMax;
            }

        }

        position.mulAdd(velocity, deltaTime);

    }

    public void update(float deltaTime) {
        controlPlayer(deltaTime);

    }

    public void render(SpriteBatch batch) {

    }

    public void end() {

    }

}
