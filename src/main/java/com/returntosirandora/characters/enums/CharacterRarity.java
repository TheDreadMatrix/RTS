package com.returntosirandora.characters.enums;

public enum CharacterRarity {
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
