package com.returntosirandora.characters.defenition;

import java.util.List;

import com.returntosirandora.titles.Title;

import java.util.ArrayList;

public class CharacterDescription {
    public static enum CharacterRarity {
        COMMON("Common", "Common Rarity"),
        RARE("Rare", "Rare Rarity"),
        EPIC("Epic", "Epic Rarity"),
        LEGENDARY("Legendary", "Legendary Rarity");

        private String rarityName;
        private String rarityDesc;

        CharacterRarity(String rarityName, String rarityDesc) {
            this.rarityName = rarityName;
            this.rarityDesc = rarityDesc;
        }

        public String getDisplayName() {
            return rarityName;
        }

        public String getDisplayDesc() {
            return rarityDesc;
        }

    }

    public static enum CharacterClass {
        TANK("Tank", "Tank"),
        HYBRID("Hybrid", "Hybrid"),
        CONTROLLER("Controller", "Controller"),
        SUMMONER("Summoner", "Summoner"),
        HEALER("Healer", "Healer"),
        ASSASIN("Assasin", "Assasin"),
        MARKSMAN("Marksman", "Marksman");

        private String className;
        private String classDesc;

        CharacterClass(String className, String classDesc) {
            this.className = className;
            this.classDesc = classDesc;
        }

        public String getDisplayName() {
            return className;
        }

        public String getDisplayDesc() {
            return classDesc;
        }
    }

    public static enum CharacterType {
        SURVIVAL("Survivals", "Survival"),
        KILLER("Killers", "Killer"),
        DEFENDER("Defenders", "Defender");

        private String typeName;
        private String typeDesc;

        CharacterType(String typeName, String typeDesc) {
            this.typeName = typeName;
            this.typeDesc = typeDesc;
        }

        public String getDisplayName() {
            return typeName;
        }

        public String getDisplayDesc() {
            return typeDesc;
        }
    }

    private static int nextId = 0;
    private int chrId = 0;

    private String chrName = "Undefined name";
    private Title chrTitle;
    private String chrDescription = "Undefined description";

    private List<CharacterSkinDescription> chrSkins = new ArrayList<>();
    private CharacterAsset chrAsset = null;

    private int chrHealth = 0;
    private int chrSpeed = 0;
    private int chrSpeedUp = 0;
    private int chrStamina = 0;

    private CharacterClass chrClass;
    private CharacterType chrType;
    private CharacterRarity chrRarity;

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
        this.chrAsset = builder.chrAsset;
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
