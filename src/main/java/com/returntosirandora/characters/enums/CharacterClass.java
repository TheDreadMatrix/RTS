package com.returntosirandora.characters.enums;

public enum CharacterClass {
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
