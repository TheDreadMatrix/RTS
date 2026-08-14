package com.returntosirandora.characters;

import java.util.List;
import java.util.ArrayList;

import com.returntosirandora.characters.titles.Title;

public class CharacterDescription {
    public static enum CharacterRarity {
        COMMON,
        RARE,
        EPIC,
        LEGENDARY
    }

    public static enum CharacterClass {
        TANK,
        HYBRID,
        CONTROLLER,
        SUMMONER,
        HEALER,
        ASSASIN,
        DEFENDER,
        SPEEDSTER,
        MARKSMAN
    }

    public static enum CharacterType {
        SURVIVAL,
        KILLER,
        DEFENDER
    }

    private static int nextId = 0;
    private int chrId = 0;

    public String chrName;
    public Title chrTitle;
    public String chrDescription;

    // This is chrPower_1
    // This is chrPower_2
    // This is chrStarPower

    public List<CharacterSkin> chrSkins = new ArrayList<>();

    public int chrHealth;
    public int chrSpeed;
    public int chrSpeedUp;
    public int chrStamina;

    public CharacterClass chrClass;
    public CharacterType chrType;
    public CharacterRarity chrRarity;

    private CharacterDescription(Builder builder) {
        this.chrId = ++nextId;

        this.chrName = builder.chrName;
        this.chrDescription = builder.chrDescription;

        this.chrHealth = builder.chrHealth;
        this.chrSpeed = builder.chrSpeed;
        this.chrSpeedUp = builder.chrSpeedUp;
        this.chrStamina = builder.chrStamina;

        this.chrClass = builder.chrClass;
        this.chrType = builder.chrType;
        this.chrRarity = builder.chrRarity;

        this.chrTitle = builder.chrTitle;
        this.chrSkins = builder.chrSkins;
    }

    public int getId() {
        return chrId;
    }

    public String getName() {
        return chrName;
    }

    public String getDescription() {
        return chrDescription;
    }

    public int getHealth() {
        return chrHealth;
    }

    public int getSpeed() {
        return chrSpeed;
    }

    public int getSpeedUp() {
        return chrSpeedUp;
    }

    public int getStamina() {
        return chrStamina;
    }

    public Title getTitle() {
        return chrTitle;
    }

    public CharacterClass getClassCharacter() {
        return chrClass;
    }

    public CharacterType getTypeCharacter() {
        return chrType;
    }

    public List<CharacterSkin> getSkins() {
        return chrSkins;
    }

    public CharacterRarity getRarity() {
        return chrRarity;
    }

    public String toString() {
        return chrName;
    }

    public static class Builder {

        private String chrName;
        private String chrDescription;

        private int chrHealth;
        private int chrSpeed;
        private int chrSpeedUp;
        private int chrStamina;

        private CharacterClass chrClass;
        private CharacterType chrType;
        private CharacterRarity chrRarity;

        private Title chrTitle;
        private List<CharacterSkin> chrSkins = new ArrayList<>();

        public Builder name(String name) {
            this.chrName = name;
            return this;
        }

        public Builder description(String description) {
            this.chrDescription = description;
            return this;
        }

        public Builder health(int health) {
            this.chrHealth = health;
            return this;
        }

        public Builder speed(int speed) {
            this.chrSpeed = speed;
            return this;
        }

        public Builder speedUp(int speedUp) {
            this.chrSpeedUp = speedUp;
            return this;
        }

        public Builder stamina(int stamina) {
            this.chrStamina = stamina;
            return this;
        }

        public Builder characterClass(CharacterClass characterClass) {
            this.chrClass = characterClass;
            return this;
        }

        public Builder characterType(CharacterType characterType) {
            this.chrType = characterType;
            return this;
        }

        public Builder rarity(CharacterRarity rarity) {
            this.chrRarity = rarity;
            return this;
        }

        public Builder title(Title title) {
            this.chrTitle = title;
            return this;
        }

        public Builder skins(List<CharacterSkin> skins) {
            this.chrSkins = skins;
            return this;
        }

        public CharacterDescription build() {
            return new CharacterDescription(this);
        }
    }
}
