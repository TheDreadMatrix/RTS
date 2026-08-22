package com.returntosirandora.characters.defenition;

import java.util.List;

import com.returntosirandora.characters.enums.CharacterRarity;
import com.returntosirandora.characters.enums.CharacterClass;
import com.returntosirandora.characters.enums.CharacterType;
import com.returntosirandora.content.titles.Title;

import java.util.ArrayList;

public class CharacterDescription {
    private String chrName = "Undefined name";
    private Title chrTitle;
    private String chrDescription = "Undefined description";

    private List<CharacterSkinDescription> chrSkins = new ArrayList<>();
    private CharacterAsset chrAsset = null;

    private int chrHealth = 0;
    private int chrSpeed = 0;
    private int chrSpeedUp = 0;
    private int chrDamage = 0;
    private int chrStamina = 0;

    private CharacterClass chrClass;
    private CharacterType chrType;
    private CharacterRarity chrRarity;

    private CharacterDescription(Builder builder) {

        this.chrName = builder.chrName;
        this.chrDescription = builder.chrDescription;

        this.chrHealth = builder.chrHealth;
        this.chrSpeed = builder.chrSpeed;
        this.chrSpeedUp = builder.chrSpeedUp;
        this.chrStamina = builder.chrStamina;
        this.chrDamage = builder.chrDamage;

        this.chrClass = builder.chrClass;
        this.chrType = builder.chrType;
        this.chrRarity = builder.chrRarity;

        this.chrTitle = builder.chrTitle;
        this.chrSkins = builder.chrSkins;
        this.chrAsset = builder.chrAsset;
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

    public int getDamage() {
        return chrDamage;
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

    public List<CharacterSkinDescription> getSkins() {
        return chrSkins;
    }

    public CharacterRarity getRarity() {
        return chrRarity;
    }

    public CharacterAsset getAsset() {
        return chrAsset;
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
        private int chrDamage;

        private CharacterClass chrClass;
        private CharacterType chrType;
        private CharacterRarity chrRarity;

        private Title chrTitle;
        private CharacterAsset chrAsset;
        private List<CharacterSkinDescription> chrSkins = new ArrayList<>();

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

        public Builder damage(int damage) {
            this.chrDamage = damage;
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

        public Builder skins(List<CharacterSkinDescription> skins) {
            this.chrSkins.addAll(skins);
            return this;
        }

        public Builder skins(CharacterSkinDescription skin) {
            this.chrSkins.add(skin);
            return this;
        }

        public Builder asset(CharacterAsset asset) {
            this.chrAsset = asset;
            return this;
        }

        public CharacterDescription build() {
            return new CharacterDescription(this);
        }
    }
}
