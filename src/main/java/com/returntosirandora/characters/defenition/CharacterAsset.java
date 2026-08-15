package com.returntosirandora.characters.defenition;

public class CharacterAsset {
    private String assetPortrait;
    private String assetAtlas;

    public CharacterAsset(String assetAtlas, String assetPortrait) {
        this.assetAtlas = assetAtlas;
        this.assetPortrait = assetPortrait;
    }

    public String getAtlas() {
        return assetAtlas;
    }

    public String getPortrait() {
        return assetPortrait;
    }

    public static class SkinAsset {
        private String skinAtlas;

        public SkinAsset(String skinAtlas) {
            this.skinAtlas = skinAtlas;
        }

        public String getSkinAtlas() {
            return skinAtlas;
        }
    }
}
