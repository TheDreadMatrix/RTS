package com.returntosirandora.characters.enums;

public enum CharacterType {
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
