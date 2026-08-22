package com.returntosirandora.characters.enums;

public enum SkinCategory {
    COMMON("Common"),
    RARE("Rare"),
    EPIC("Epic");

    private String skinName;

    SkinCategory(String skinName) {
        this.skinName = skinName;
    }

    public String getDisplayName() {
        return skinName;
    }
}
